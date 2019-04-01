package com.mybatis.author;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.annotations.ConstructorArgs;
import org.apache.ibatis.annotations.Arg;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Param;
import com.mybatis.utils.AuthorSqlBuilder ;
import org.apache.ibatis.executor.BatchResult;
import java.util.List;

/*对象生命周期和依赖注入框架

        依赖注入框架可以创建线程安全的、基于事务的 SqlSession 和映射器（mapper）并将它们直接注入到你的 bean 中，
        因此可以直接忽略它们的生命周期。如果对如何通过依赖注入框架来使用 MyBatis
        感兴趣可以研究一下 MyBatis-Spring 或 MyBatis-Guice 两个子项目。*/

public interface IAuthorMapper {


    /**
     // (Author) selectOne("selectAuthor",5);
     Author selectAuthor(int id);
     // (List<Author>) selectList(“selectAuthors”)
     List<Author> selectAuthors();
     // (Map<Integer,Author>) selectMap("selectAuthors", "id")
     @MapKey("id")
     Map<Integer, Author> selectAuthors();
     // insert("insertAuthor", author)
     int insertAuthor(Author author);
     // updateAuthor("updateAuthor", author)
     int updateAuthor(Author author);
     // delete("deleteAuthor",5)
     int deleteAuthor(int id);
     * @param id
     * @return
     */


    public Author selectAuthor(String id) ;
    /*
    @Insert("insert into table2 (name) values(#{name})")
    @SelectKey(statement="call identity()", keyProperty="nameId", before=false, resultType=int.class)
    int insertTable2(Author  author);
    */

    @Insert("insert into Author (id, username,password) values(#{id}, #{username}, #{password)")
    @SelectKey(statement="call identity()", keyProperty="id", before=true, resultType=int.class)
    public int insertPojo(Author author) ;

    public void updatePojo(Author author) ;

    @Delete("DELETE * FROM Author WHERE id = #{id}")
    public void  deletePojo(String id) ;

    public void deletePojo(Author author) ;

    @Flush
    List<BatchResult> flush();


    @Results(id = "authorResult", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password")
    })
    @Select("select * from users where id = #{id}")
    Author getUserById(Integer id);

    @Results(id = "companyResults")
    @ConstructorArgs({
            @Arg(name = "id", column = "id", id = true),
            @Arg(name = "username", column = "username")
    })
    @Select("select * from company where id = #{id}")
    Author getCompanyById(Integer id);



    @SelectProvider(type = AuthorSqlBuilder.class, method = "buildGetUsersByName")
    List<Author> getUsersByName(String name);

    @SelectProvider(type = AuthorSqlBuilder.class, method = "buildGetUsersByName")
    List<Author> getUsersByName(@Param("name") String name, @Param("orderByColumn") String orderByColumn);


}