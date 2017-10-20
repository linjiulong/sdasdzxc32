package com.effecia;

import com.alibaba.fastjson.JSON;
import com.effecia.common.utils.RedisUtils;
import com.effecia.modules.sys.entity.SysUserEntity;
import com.effecia.modules.sys.service.SysUserService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-jdbc.xml",
        "classpath:spring-redis.xml",})
public class RedisTest {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private SysUserService sysUserService;
//
//    @Test
//    public void test(){
//        SysUserEntity user = sysUserService.queryObject(1L);
//        System.out.println(ToStringBuilder.reflectionToString(user));
//
//        redisUtils.set("user", user);
//
//        user = redisUtils.get("user", SysUserEntity.class);
//        System.out.println(ToStringBuilder.reflectionToString(user));
//    }
    
    @Test
    public void asdasd(){
    	List<Integer> ids=new ArrayList<>();;
    	ids.add(1);
    	ids.add(2);
    	ids.add(3);
    	Gson gson=new Gson();
    	System.out.println(gson.toJson(ids));
    	
    }
    
}
