package com.benqio.quartz.dao;

import com.benqio.quartz.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/10/14
 * @desc:
 */
@Component
@Repository
public interface UserMapper {
    List<User> userLogin(@Param("userName") String userName, @Param("password") String password);
    void insertByQuartz(User user);
}
