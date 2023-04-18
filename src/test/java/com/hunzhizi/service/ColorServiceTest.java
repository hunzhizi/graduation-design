package com.hunzhizi.service;

import com.hunzhizi.GraduationDesignApplication;
import com.hunzhizi.domain.Color;
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
        Color color = new Color();
        color.setPhotoId(1);
        boolean b = service.analyzeColor("person.jpg", color);
        System.out.println(b);
    }
}
