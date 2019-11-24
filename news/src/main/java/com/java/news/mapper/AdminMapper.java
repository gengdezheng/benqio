package com.java.news.mapper;

import com.java.news.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Component
public interface AdminMapper {
    int addAdmin(@Param("adminName")String adminName ,
                 @Param("adminPass")String adminPass ,
                 @Param("phone") String phone);
    int adminLogin(@Param("adminName") String adminName ,
                   @Param("adminPass") String adminPass);
}
