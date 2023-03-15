package com.hunzhizi.service;

import com.hunzhizi.GraduationDesignApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 魂之子
 * @since 2023-03-14 21:49
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class PhotoServiceTest {
    @Resource
    PhotoService photoService;


}
