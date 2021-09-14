package com.liuwohe;

import com.liuwohe.entity.EmployeeEntity;
import com.liuwohe.entity.OrganizationEntity;
import com.liuwohe.repository.EmployeeEntityMapper;
import com.liuwohe.repository.OrganizationEntityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmployeeEntityMapper empMapper;

    @Test
    public void test(){
        EmployeeEntity empList = empMapper.selectById(5);
        redisTemplate.opsForSet().add("emp",empList);
    }
}
