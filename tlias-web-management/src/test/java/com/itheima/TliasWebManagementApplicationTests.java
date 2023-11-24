package com.itheima;

import com.itheima.mapper.DeptMapper;
import com.itheima.utils.MyJwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private MyJwt myJwt;
    @Test
    void contextLoads() {
//        deptMapper.getAllDept().stream().forEach(s-> System.out.println(s));
//        System.out.println(deptMapper.delDeptById(10));
        Map<String,Object> map = new HashMap<>();
        map.put("name","www");
        System.out.println(myJwt.parseToken(myJwt.createToken(map,10000L)));
    }

    @Test
    void creatJWT(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","GGBond");
        map.put("password","123456");

        String s = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS256, "WHH666")
                .setExpiration(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .compact();
        System.out.println(s);
    }
    

}
