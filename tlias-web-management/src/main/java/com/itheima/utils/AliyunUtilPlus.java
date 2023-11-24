package com.itheima.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @auth 王华衡
 */
@Component
public class AliyunUtilPlus {
    // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
    @Value("${aliyun.oss.endpoint}")
    private  String endpoint ;
    @Value("${aliyun.oss.bucketname}")
//    Bucket名称
    private  String bucketName ;

    public  String uploadFileByOss(MultipartFile file) throws ClientException, IOException {
        // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
        EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
//        获取文件的输入流
        InputStream inputStream = file.getInputStream();
//        获取文件的原名
        String filename = file.getOriginalFilename();
//          为防止图片被覆盖
        UUID uuid = UUID.randomUUID();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);


        int i = endpoint.lastIndexOf("/");
        String substringHead = endpoint.substring(0, i + 1);
//        System.out.println(substringHead);
        String substringBack = endpoint.substring(i+1);
//        System.out.println(substringBack);
        String lastName = substringHead+bucketName+"."+substringBack+"/"+uuid+filename;
        try {
            // 创建PutObjectRequest对象。
//            第一个参数是想要存入的bucketName实例的名字，第二个是存入实例中的文件的名字，第三个可以是文件也可以是输入流
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,uuid+ filename, inputStream);

            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

            // 上传字符串。
            ossClient.putObject(putObjectRequest);

            return lastName;
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (com.aliyun.oss.ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            inputStream.close();
    }
        return null;
    }
}
