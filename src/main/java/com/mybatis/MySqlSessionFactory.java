package com.mybatis;

import com.mybatis.author.Author;
import com.mybatis.author.IAuthorMapper;
import com.mybatis.blog.Blog;
import com.mybatis.blog.IBlogMapper;
import com.mybatis.post.Post;
import message.Messages;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class MySqlSessionFactory {

    private static DataSource dataSourc1e = null ;
    private static SqlSessionFactory sqlSessionFactory = null;

    static{
        genDataSourceFactory();
        genSqlSessionFactory ();
    }


    private static void genDataSourceFactory (){
        Messages msgs = Messages.getInstance();
        Properties properties = msgs.getProperties();
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        dataSourc1e = pooledDataSourceFactory.getDataSource();
    }

    private static void genSqlSessionFactory () {
        try{
        String resource = "mybatis/configuration.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        if(dataSourc1e == null){
            genDataSourceFactory();
        }
        return dataSourc1e ;
    }



    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory == null){
            genSqlSessionFactory();
        }
        return sqlSessionFactory ;
    }


    /**
     *   SqlSessionFactory build(InputStream inputStream)
         SqlSessionFactory build(InputStream inputStream, String environment)
         SqlSessionFactory build(InputStream inputStream, Properties properties)
         SqlSessionFactory build(InputStream inputStream, String env, Properties props)
         SqlSessionFactory build(Configuration config)
     * @return
     */


    public static SqlSessionFactory getSqlSessionFactoryByInputStream() {
        try{
            if(sqlSessionFactory == null){
                String resource = "org/mybatis/builder/mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                sqlSessionFactory = builder.build(inputStream);;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory ;
    }


    /**
     * only to see it not to use
     * @return
     */
    @Deprecated
    public static SqlSessionFactory getSqlSessionFactoryByConfig() {
        try{
            if(sqlSessionFactory == null){
               // DataSource dataSource = BaseDataTest.createBlogDataSource();
                DataSource dataSource = getDataSource();
                TransactionFactory transactionFactory = new JdbcTransactionFactory();

                Environment environment = new Environment("development", transactionFactory, dataSource);

                Configuration configuration = new Configuration(environment);
                configuration.setLazyLoadingEnabled(true);
                //configuration.setEnhancementEnabled(true);
                configuration.setCacheEnabled(true);
                configuration.getTypeAliasRegistry().registerAlias(Blog.class);
                configuration.getTypeAliasRegistry().registerAlias(Post.class);
                configuration.getTypeAliasRegistry().registerAlias(Author.class);
                configuration.addMapper(IBlogMapper.class);
                configuration.addMapper(IAuthorMapper.class);

                SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
                sqlSessionFactory = builder.build(configuration);;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sqlSessionFactory ;
    }





   /*
    public SqlSessionFactory getSqlSessionFactory(){
       DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        return  new SqlSessionFactoryBuilder().build(configuration);
    }
        */

}