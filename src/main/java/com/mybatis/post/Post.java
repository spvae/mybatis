package com.mybatis.post;

import com.mybatis.author.Author;
import com.mybatis.comment.Comment;
import com.mybatis.tag.Tag;

import java.util.List;

public class Post {

    private String id ;
    private String subject ;
    private Author author  ;
    private List<Comment>  comments  ;
    private List<Tag>  tags  ;


}