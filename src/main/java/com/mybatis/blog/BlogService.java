package com.mybatis.blog;

import com.mybatis.MySqlSessionFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

// @Controller
public class BlogService {
    public Blog selectBlog(String did){
        SqlSessionFactory sqlSessionFactory  = MySqlSessionFactory.getSqlSessionFactory();

        /**
         SqlSession openSession()
         SqlSession openSession(boolean autoCommit)
         SqlSession openSession(Connection connection)
         SqlSession openSession(TransactionIsolationLevel level)
         SqlSession openSession(ExecutorType execType,TransactionIsolationLevel level)
         SqlSession openSession(ExecutorType execType)
         SqlSession openSession(ExecutorType execType, boolean autoCommit)
         SqlSession openSession(ExecutorType execType, Connection connection)
         Configuration getConfiguration();

         默认的 openSession()方法没有参数,它会创建有如下特性的 SqlSession:

         会开启一个事务(也就是不自动提交)
         连接对象会从由活动环境配置的数据源实例中得到。
         事务隔离级别将会使用驱动或数据源的默认设置。
         预处理语句不会被复用,也不会批量处理更新。

         ExecutorType.SIMPLE: 这个执行器类型不做特殊的事情。它为每个语句的执行创建一个新的预处理语句。
         ExecutorType.REUSE: 这个执行器类型会复用预处理语句。
         ExecutorType.BATCH: 这个执行器会批量执行所有更新语句,如果 SELECT 在它们中间执行还会标定它们是 必须的,来保证一个简单并易于理解的行为。


         注意 在 SqlSessionFactory 中还有一个方法我们没有提及,就是 getConfiguration()。
         这 个方法会返回一个 Configuration 实例,在运行时你可以使用它来自检 MyBatis 的配置。

         注意 如果你已经使用之前版本 MyBatis,你要回忆那些 session,transaction 和 batch 都是分离的。
         现在和以往不同了,这些都包含在 session 的作用域内了。你需要处理分开处理 事务或批量操作来得到它们的效果。

         */


        SqlSession session = sqlSessionFactory.openSession(ExecutorType.REUSE);
      /*
       old
       Blog blog = null ;
        try {
             blog = (Blog) session.selectOne("com.mybatis.BlogMapper.selectBlog", "1");
        } finally {
            session.close();
        }
        return blog ;*/

        Blog blog = null ;
        try {
            IBlogMapper mapper = session.getMapper(IBlogMapper.class);
            blog = mapper.selectBlog("1");
        } finally {
            session.close(); // must the session scope is request
        }
        return blog ;
    }
}