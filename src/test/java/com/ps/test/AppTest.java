package com.ps.test;

import config.SpringConfiguration;
import com.ls.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: 使用Junit单元测试，测试我们的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AppTest {

    @Autowired
    private IAccountService as;

    @Test
    public void testTransfer(){
        as.transfer("aa","bb",100F);
    }
}
