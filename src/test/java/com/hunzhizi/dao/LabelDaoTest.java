package com.hunzhizi.dao;

import com.hunzhizi.GraduationDesignApplication;
import com.hunzhizi.domain.Label;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-12 21:47
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class LabelDaoTest {
    @Resource
    private LabelDao test;

    @Test
    public void selectByField(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("person");
        strings.add("traffic_light");
        List<Integer> integers = test.selectByField(strings);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
//        List<Label> labels = test.selectByField(strings);
//        for (Label label : labels) {
//            System.out.println(label);
//        }
        System.out.println("end");
    }
    @Test
    public void createLabel(){
        Label label = new Label();
        label.setPerson(true);
        label.setTrafficLight(true);
        label.setTrafficLight(true);
        label.setPhotoId(1);
        test.createLabel(label);
    }
}
