package com.mybatis.post;

import com.mybatis.blog.Blog;

/*对象生命周期和依赖注入框架

        依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中，
        因此可以直接忽略它们的生命周期。如果对如何通过依赖注入框架来使用 MyBatis
        感兴趣可以研究一下 MyBatis-Spring 或 MyBatis-Guice 两个子项目。*/

public interface IPostMapper {

    public Blog selectPojo(String id) ;

    public Blog insertPojo(Post blog) ;

    public Blog updatePojo(Post blog) ;

    public Blog deletePojo(String id) ;

    public Blog deletePojo(Post blog) ;

}