package com.hunzhizi.service;

import com.hunzhizi.GraduationDesignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2023-03-14 21:51
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class ColorServiceTest {
    @Resource
    ColorService service;
    @Test
    public void analyzeColor(){
        boolean b = service.analyzeColor("person.jpg", 1);
        System.out.println(b);
    }
}
