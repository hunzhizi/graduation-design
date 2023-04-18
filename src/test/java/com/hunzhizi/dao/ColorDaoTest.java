package com.hunzhizi.dao;

import com.hunzhizi.GraduationDesignApplication;
import com.hunzhizi.domain.Color;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-12 18:29
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class ColorDaoTest {
    @Resource
    private ColorDao test;

    @Test
    public void selectByRGB1(){
        List<Integer> colors = test.selectByRGB1(20, 20, 20);
        for (Integer color : colors) {
            System.out.println(color);
        }
    }

    @Test
    public void createItem(){
        Color color = new Color(1, 1, 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Boolean color1 = test.createColor(color);
        System.out.println(color1);
    }

    @Test
    public void selectByIds(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        System.out.println(test.selectByIds(integers));
    }

    @Test
    public void selectByPhotoId(){
        Color color = test.selectByPhotoId(15);
        System.out.println(color);
    }
}
