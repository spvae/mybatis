package com.mybatis.author;

import org.apache.ibatis.jdbc.SQL;

public class AuthorSql {

    private String selectAuthorSql() {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
            SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
            FROM("BLOG P");
            FROM("AUTHOR A");
            INNER_JOIN("POST D on D.POSTREF = P.ID");
            INNER_JOIN("COMMENT C on D.PKID = C.COMMENTREF");
            WHERE("P.REFID = A.ID");
            WHERE("P.USERNAME like ?");
            OR();
            WHERE("P.TITLE like ?");
            GROUP_BY("P.ID");
            HAVING("P.USERNAME like ?");
            OR();
            HAVING("P.TITLE like ?");
            ORDER_BY("P.ID");
            ORDER_BY("P.TITLE");
        }}.toString();
    }

    // Anonymous inner class
    public String deleteAuthorSql() {
        return new SQL() {{
            DELETE_FROM("Author");
            WHERE("ID = #{id}");
        }}.toString();
    }

    // Builder / Fluent style
    public String insertPersonSql() {
        String sql = new SQL()
                .INSERT_INTO("Author")
                .VALUES("ID, FIRST_NAME", "#{id}, #{firstName}")
                .VALUES("LAST_NAME", "#{lastName}")
                .toString();
        return sql;
    }

    // With conditionals (note the final parameters, required for the anonymous inner class to access them)
    public String selectPersonLike(final String id, final String firstName, final String lastName) {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
            FROM("PERSON P");
            if (id != null) {
                WHERE("P.ID like #{id}");
            }
            if (firstName != null) {
                WHERE("P.FIRST_NAME like #{firstName}");
            }
            if (lastName != null) {
                WHERE("P.LAST_NAME like #{lastName}");
            }
            ORDER_BY("P.LAST_NAME");
        }}.toString();
    }

    public String updatePersonSql() {
        return new SQL() {{
            UPDATE("Author");
            SET("username = #{firstName}");
            WHERE("ID = #{id}");
        }}.toString();
    }


    public String insertAuthorSqlByColumnAndValues() {
        return new SQL()
                .INSERT_INTO("PERSON")
                .INTO_COLUMNS("ID", "FULL_NAME")
                .INTO_VALUES("#{id}", "#{fullName}")
                .toString();
    }

}