package com.benqio.dynamicdatasource.dao;

import com.benqio.dynamicdatasource.model.RoleDept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:gengdz
 * @date:2019/9/26
 * @desc:
 */

@Component
public interface RoleDeptMapper {
    List<RoleDept> queryRoleDept();
}
