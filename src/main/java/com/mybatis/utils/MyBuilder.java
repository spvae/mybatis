package com.mybatis.utils;
import static org.apache.ibatis.jdbc.SelectBuilder.*;
import static org.apache.ibatis.jdbc.SqlBuilder.*;

/**
 *  在3.2版本之前，我们使用了一点不同的做法，通过实现ThreadLocal变量来掩盖一些导致Java DSL麻烦的语言限制。
 *  但这种方式已经废弃了，现代的框架都欢迎人们使用构建器类型和匿名内部类的想法。因此，SelectBuilder 和 SqlBuilder 类都被废弃了。
    下面的方法仅仅适用于废弃的SqlBuilder 和 SelectBuilder 类。
*/

public class MyBuilder {

  /*

    public String selectBlogsSql() {
        BEGIN(); // Clears ThreadLocal variable
        SELECT("*");
        FROM("BLOG");
        return SQL();
    }


    private String selectPersonSql() {
        BEGIN(); // Clears ThreadLocal variable
        SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
        SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
        FROM("PERSON P");
        FROM("ACCOUNT A");
        INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
        INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
        WHERE("P.ID = A.ID");
        WHERE("P.FIRST_NAME like ?");
        OR();
        WHERE("P.LAST_NAME like ?");
        GROUP_BY("P.ID");
        HAVING("P.LAST_NAME like ?");
        OR();
        HAVING("P.FIRST_NAME like ?");
        ORDER_BY("P.ID");
        ORDER_BY("P.FULL_NAME");
        return SQL();
    }
        */

}