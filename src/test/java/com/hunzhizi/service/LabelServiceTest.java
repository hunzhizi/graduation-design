package com.hunzhizi.service;

import com.hunzhizi.GraduationDesignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2023-03-14 21:53
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class LabelServiceTest {
    @Resource
    LabelService service;
    @Test
    public void labelImg(){
        service.labelImg("person.jpg",2);
    }
}
