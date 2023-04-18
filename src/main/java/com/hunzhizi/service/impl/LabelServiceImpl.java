package com.hunzhizi.service.impl;

import com.hunzhizi.dao.LabelDao;
import com.hunzhizi.domain.Label;
import com.hunzhizi.service.LabelService;
import com.hunzhizi.tool.PythonCall;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-13 20:35
 * program: graduation-design
 * description:
 */
@Service
@Slf4j
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelDao labelDao;
    @Override
    public Boolean createLabel(Label label) {
        return labelDao.createLabel(label);
    }

    @Override
    public List<Integer> getLabelByField(String fields) {
        //对字符串进行解析
        char[] chars = fields.trim().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        ArrayList<String> res = new ArrayList<>();
        for (char aChar : chars) {
            if(aChar=='#'){
                res.add(stringBuffer.toString());
                stringBuffer = new StringBuffer();
                continue;
            }
            stringBuffer.append(aChar);
        }
        res.add(stringBuffer.toString());
        return labelDao.selectByField(res);
    }

    @Override
    public boolean labelImg(String imgName, int photoId) {
        List<Integer> integers = PythonCall.labelImg(PythonCall.UPLODA_DIR + imgName);
        Label label = new Label();
        label.setPhotoId(photoId);
        for (Integer integer : integers) {
            label.setLabelByOrder(integer);
        }
        if(integers==null || integers.size()==0){
            log.info("label图片失败");
            return false;
        }

        return labelDao.createLabel(label);
    }
}
