package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliyunUtil;
import com.itheima.utils.AliyunUtilPlus;
import com.itheima.utils.AliyunUtilPlusPro;
import org.jacoco.agent.rt.internal_43f5073.core.runtime.AgentOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

import static org.jacoco.agent.rt.internal_43f5073.core.runtime.AgentOptions.OutputMode.file;

// 本地文件上传
@RestController
@RequestMapping("/upload")
public class UploadController {
//    @Autowired
//    private AliyunUtilPlus aliyunUtilPlus;

    @Autowired
    private AliyunUtilPlusPro aliyunUtilPlusPro;
    @PostMapping
    public Result uploadImage(MultipartFile image) throws Exception{

////        获取文件名
//        String filename = image.getOriginalFilename();
////        System.out.println(filename);
////        找点的位置
////        int indexOf = filename.indexOf(".");
//        int indexOf = filename.lastIndexOf(".");//找最后一个点的位置
////        取文件后缀
//        String typeName = filename.substring(indexOf);
////        System.out.println(typeName);
////        使用UUID给文件设置一个新的name
//        String fileNewName = UUID.randomUUID() + typeName;
////        System.out.println(fileNewName);
////        存储文件
//        image.transferTo(new File("D:\\software\\nginx-1.22.0-tlias\\html\\static\\headImg\\"+fileNewName));
//
//        String realName = "static\\headImg\\";

//        String file = AliyunUtil.uploadFileByOss(image);
        String file = aliyunUtilPlusPro.uploadFileByOss(image);
        return Result.success(file);
    }
}
