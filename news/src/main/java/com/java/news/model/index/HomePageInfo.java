package com.java.news.model.index;

import com.java.news.model.Classify;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/11/16
 * @desc:
 */
@Setter
@Getter
public class HomePageInfo {
    private int userCount;
    private int unPassCountForArti;
    private int passCountForArti;
    private List<Classify> classifyList;
}
