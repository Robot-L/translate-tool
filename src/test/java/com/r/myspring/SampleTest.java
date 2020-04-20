package com.r.myspring;

import com.r.myspring.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private AccountMapper accountMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        // List<User> userList = userMapper.selectList(null);
        // Assert.assertEquals(5, userList.size());
        String dictValueByCode = accountMapper.getDictValueByCode(5);
        // System.out.println(accountMapper.selectById(4));
        System.out.println(dictValueByCode);
        // userList.forEach(System.out::println);
    }
}