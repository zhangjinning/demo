package com.zjn.demo.mybatistest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjn.demo.entity.User;
import com.zjn.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrudTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void testSelect() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id", "1");
        User user = userMapper.selectOne(wrapper);
        System.out.printf("%s - %s%n", user.getName(), user.getAge());
    }
}
