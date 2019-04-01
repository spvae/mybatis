package com.mybatis.utils;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseIdProviderImp implements DatabaseIdProvider{
   String currDbBaseId=null ;
    @Override
    public void setProperties(Properties p){
    }


    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException{
        return "mysql";
    }

    public String getCurrDbBaseId() {
        return currDbBaseId;
    }

    public void setCurrDbBaseId(String currDbBaseId) {
        this.currDbBaseId = currDbBaseId;
    }
}
