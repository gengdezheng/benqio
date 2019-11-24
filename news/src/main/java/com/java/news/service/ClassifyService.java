package com.java.news.service;

import com.java.news.model.Classify;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface ClassifyService {
    List<Classify> queryClassify();
    int deleteById( int id);
    String insert(String name);
}
