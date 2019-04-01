package com.mybatis.blog;

import com.mybatis.utils.MyLanguageDriver;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Select;

/*对象生命周期和依赖注入框架

        依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中，
        因此可以直接忽略它们的生命周期。如果对如何通过依赖注入框架来使用 MyBatis
        感兴趣可以研究一下 MyBatis-Spring 或 MyBatis-Guice 两个子项目。*/

public interface IBlogMapper {
    public Blog selectBlog(String id) ;

    /**
     * use the customer Language
     * @return
     */

    @Lang(MyLanguageDriver.class)
    @Select("SELECT * FROM BLOG")
    public Blog selectAllBlogs() ;


    public Blog insertBlog(Blog blog) ;

    public Blog updateBlog(Blog blog) ;

    @Delete("DELETE * FROM blog WHERE id = #{id}")
    public Blog deleteBlog(String id) ;

    public Blog deleteBlog(Blog blog) ;

}