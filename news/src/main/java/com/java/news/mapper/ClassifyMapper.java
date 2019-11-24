package com.java.news.mapper;

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
public interface ClassifyMapper {
    List<Classify> queryClassify();
    int deleteById(@Param("id") int id);
    void insert(@Param("name")String name);
}
