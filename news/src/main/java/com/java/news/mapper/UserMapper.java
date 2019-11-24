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
public interface UserMapper {
    List<User> userLogin(@Param("userName") String userName, @Param("password") String password);

    void insertUser(User user);

    void updateInfo(User user);

    int getCount();

    List<User> queryUser(@Param("userId") String userId, @Param("userName") String userName, @Param("phoneNumber") String phoneNumber);

    int batchDeleteUser(List<String> ids);
}
