package com.benqio.dynamicdatasource.dao;

import com.benqio.dynamicdatasource.model.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:
 */
@Component
public interface UserRoleMapper {
    List<UserRole> queryUserRole();
}
