package com.java.news.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * @author:gengdz
 * @date:2019/10/30
 * @desc:
 */
@Setter
@Getter
@ToString

public class Article {
   private String articleId;
   private  String title;
   private String content;
   private Date time;
   private String userId;
   private int classId;
   private int state;
   private String imgs;
   private MultipartFile[] file;

   private User user;
   private Classify classify;
}
