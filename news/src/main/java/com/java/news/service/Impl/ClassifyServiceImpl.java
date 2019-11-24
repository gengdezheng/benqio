package com.java.news.service.Impl;

import com.java.news.Constant;
import com.java.news.mapper.ClassifyMapper;
import com.java.news.model.Classify;
import com.java.news.service.ClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {

    @Autowired
    ClassifyMapper classifyMapper;
    @Override
    public List<Classify> queryClassify() {
        return classifyMapper.queryClassify();
    }

    @Override
    public int deleteById(int id) {
        return classifyMapper.deleteById(id);
    }

    @Override
    public String insert(String name) {
        List<Classify> classifies = queryClassify();
        for (Classify c:classifies){
            if(c.getName().equals(name))
               return Constant.CLASSIFYNAME_IS_EXIST;
        }
        classifyMapper.insert(name);
        return Constant.CLASSIFYNAME_IS_SUCCESS;
    }
}
