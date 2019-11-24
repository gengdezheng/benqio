package com.java.news.service.Impl;

import com.java.news.Constant;
import com.java.news.mapper.UserMapper;
import com.java.news.model.User;
import com.java.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("${Img.head_path}")
    String head_path;
    @Autowired
    UserMapper userMapper;

    @Autowired
    HttpSession session;


    @Override
    public void insertUser(User user) {

           MultipartFile file = user.getHeadfile();
           user.setHeadImg(file.getOriginalFilename());
           user.setUserId(UUID.randomUUID().toString().replace("-",""));
           File  uploadDirectory = new File(head_path+"/"+file.getOriginalFilename());
           try{
            file.transferTo(uploadDirectory);
        }
        catch (Exception e){
        }
        userMapper.insertUser(user);
    }

    @Override
    public void updateInfo(User user) {
        String pass = "";
        if(user.getPassword().equals("") || user.getPassword()==null){
            pass = ((User)session.getAttribute("user")).getPassword();
        }
        else
            pass = user.getPassword();

        userMapper.updateInfo(user);
        session.removeAttribute("user");
        userMapper.userLogin(user.getUserName(),pass);
        session.setAttribute("user",userMapper.userLogin(user.getUserName(),pass).get(0));
    }

    @Override
    public int getCount() {
        return userMapper.getCount();
    }

    @Override
    public List<User> queryUser(String userId, String userName, String phoneNumber) {
        return userMapper.queryUser(userId,userName,phoneNumber);
    }

    @Override
    public int batchDeleteUser(List<String> ids) {
        return userMapper.batchDeleteUser(ids);
    }
}
