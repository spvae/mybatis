package com.mybatis.utils;



import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class ExampleObjectFactory extends DefaultObjectFactory{

private String tmpValue = "";

    @Override
    public Object create(Class type) {
        return super.create(type);
    }
    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    /*public Object create(Class type, List<Class> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }*/

    @Override
    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    @Override
    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }


    public String getTmpValue() {
        return tmpValue;
    }

    public void setTmpValue(String tmpValue) {
        this.tmpValue = tmpValue;
    }
}