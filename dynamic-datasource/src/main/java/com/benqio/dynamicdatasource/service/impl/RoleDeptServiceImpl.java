package com.benqio.dynamicdatasource.service.impl;

import com.benqio.dynamicdatasource.config.TargetDS;
import com.benqio.dynamicdatasource.dao.RoleDeptMapper;
import com.benqio.dynamicdatasource.model.RoleDept;
import com.benqio.dynamicdatasource.service.RoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:
 */
@Service
public class RoleDeptServiceImpl implements RoleDeptService {

    @Autowired
    RoleDeptMapper roleDeptMapper;

    @TargetDS("master")
    @Override
    public List<RoleDept> queryRoleDept() {
        return roleDeptMapper.queryRoleDept();
    }
}
