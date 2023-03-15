package com.hunzhizi.dao;

import com.hunzhizi.GraduationDesignApplication;
import com.hunzhizi.domain.Photo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-12 23:41
 * program: graduation-design
 * description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GraduationDesignApplication.class)
public class PhotoDaoTest {
    @Resource
    PhotoDao test;

    @Test
    public void createPhoto(){
        test.createPhoto(new Photo(10,1,"jpg","https://www.baidu.com", "later_address"));
    }

    @Test
    public void selectByPhotoIds(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        List<Photo> photos = test.selectByPhotoIds(integers);
        for (Photo photo : photos) {
            System.out.println(photo);
        }
    }
}
