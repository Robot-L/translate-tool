package com.r.myspring;

import com.r.myspring.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.BaseExecutor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest implements ApplicationContextAware {

    @Resource
    private AccountMapper accountMapper;
    @Autowired
    private static ApplicationContext context;
    @Resource
    private JdbcTemplate template;
    @Resource
    private SqlSessionTemplate template1;
    @Resource
    private SqlSessionFactory factory;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        // List<User> userList = userMapper.selectList(null);
        // Assert.assertEquals(5, userList.size());
        String dictValueByCode = accountMapper.getDictValueByCode(5);
        // System.out.println(accountMapper.selectById(4));
        System.out.println(dictValueByCode);
        // userList.forEach(System.out::println);
        BaseExecutor executor = context.getBean(BaseExecutor.class);
        try(Connection connection = executor.getTransaction().getConnection()){
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}