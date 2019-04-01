package com.mybatis.utils;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;


/**
 *  下面的插件将会拦截在 Executor 实例中所有的 “update” 方法调用， 这里的 Executor 是负责执行低层映射语句的内部对象。
 *  NOTE 覆盖配置类

    除了用插件来修改 MyBatis 核心行为之外，还可以通过完全覆盖配置类来达到目的。
    只需继承后覆盖其中的每个方法，再把它传递到 SqlSessionFactoryBuilder.build(myConfig) 方法即可。
    再次重申，这可能会严重影响 MyBatis 的行为，务请慎之又慎。
 */

@Intercepts({@Signature(type= Executor.class,method = "update",args = {MappedStatement.class,Object.class})})
public class ExamplePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return invocation.proceed();
    }
    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }
    @Override
    public void setProperties(Properties properties) {
    }
}
