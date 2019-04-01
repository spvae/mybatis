package com.mybatis.utils;
import org.apache.ibatis.jdbc.SQL ;
import org.apache.ibatis.annotations.Param;

public class AuthorSqlBuilder {

   /* public String buildGetUsersByName(final String name) {
        return new SQL(){{
            SELECT("*");
            FROM("users");
            if (name != null) {
                WHERE("name like #{value} || '%'");
            }
            ORDER_BY("id");
        }}.toString();
    }*/

    // If use @Param, you can define only arguments to be used

    public String buildGetUsersByName(@Param("orderByColumn") final String name) {
        return new SQL(){{
            SELECT("*");
            FROM("users");
            if (name != null) {
                WHERE("name like #{value} || '%'");
            }
            ORDER_BY("id");
        }}.toString();
    }



    // If not use @Param, you should be define same arguments with mapper method

    public String buildGetUsersByName(
            final String name, final String orderByColumn) {
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("name like #{name} || '%'");
            ORDER_BY(orderByColumn);
        }}.toString();
    }



}