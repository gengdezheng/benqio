package com.java.news;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
public interface Constant {
    //待审核
    int NEED_CHECK = 0;
    //审核通过
    int CHECK_PASS = 1;
    //登录成功
    int LOGIN_SUCCESS = 0;
    //登录失败
    int LOGIN_ERROR = 1;

    String LOGIN_REASON_IS_ERROR ="用户名/密码错误！";
    //管理员角色
    int ADMIN_ROLE = 0;
    //普通用户角色
    int USER_ROLE =1 ;

    String REGIST_SUCCESS="注册成功！";

    String REGIST_ERROR="注册失败！";
    //未登录
    String UNLOGIN = "0";
    //已登录
    String LOGINED = "1";

    String UPDATE_SUCCESS="修改成功！";

    String SET_PASS_SUCCESS = "设置成功";

    String SET_PASS_ERROR = "设置失败";

    String CLASSIFYNAME_IS_EXIST = "分类名已存在";
    String CLASSIFYNAME_IS_SUCCESS="添加成功";
    int PAGE_SIZE = 6;

}
