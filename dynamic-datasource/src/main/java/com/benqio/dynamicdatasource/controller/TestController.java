package com.benqio.dynamicdatasource.controller;

import com.benqio.dynamicdatasource.model.RoleDept;
import com.benqio.dynamicdatasource.model.UserRole;
import com.benqio.dynamicdatasource.service.RoleDeptService;
import com.benqio.dynamicdatasource.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:
 */
@RestController
public class TestController {

    @Autowired
    UserRoleService userRoleService;
    @Autowired
    RoleDeptService roleDeptService;

    @GetMapping(value = "/getRoleDept")
    public List<RoleDept> getRoleDept(){
        return roleDeptService.queryRoleDept();
    }

    @GetMapping(value="/getUserRole")
    public List<UserRole> getUserRole(){
        return userRoleService.queryUserRole();
    }
}
