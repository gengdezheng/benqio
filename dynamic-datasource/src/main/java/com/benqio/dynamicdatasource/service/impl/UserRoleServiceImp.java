package com.benqio.dynamicdatasource.service.impl;

import com.benqio.dynamicdatasource.config.TargetDS;
import com.benqio.dynamicdatasource.dao.UserRoleMapper;
import com.benqio.dynamicdatasource.model.UserRole;
import com.benqio.dynamicdatasource.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:
 */
@Service
public class UserRoleServiceImp implements UserRoleService {

    @Autowired
    UserRoleMapper userRoleMapper;

    @TargetDS("slave")
    @Override
    public List<UserRole> queryUserRole() {
        return userRoleMapper.queryUserRole();
    }
}
