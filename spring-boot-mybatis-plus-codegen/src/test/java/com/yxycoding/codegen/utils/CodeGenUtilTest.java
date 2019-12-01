package com.yxycoding.codegen.utils;

import com.yxycoding.codegen.SpringBootMybatisPlusCodegenApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class CodeGenUtilTest extends SpringBootMybatisPlusCodegenApplicationTest {

    @Autowired
    CodeGenUtil codeGenUtil;
    @Test
    public void qrySqlField() {

        String sql ="SELECT\n" +
                "\ta.id AS id,\n" +
                "\ta.NAME AS NAME,\n" +
                "\ta.PASSWORD AS PASSWORD,\n" +
                "\ta.salt AS salt,\n" +
                "\ta.email AS email,\n" +
                "\ta.phone_number AS phone_number,\n" +
                "\ta.STATUS AS STATUS,\n" +
                "\ta.create_time AS create_time,\n" +
                "\ta.last_login_time AS last_login_time,\n" +
                "\ta.last_update_time AS last_update_time,\n" +
                "\tc.id AS role_id,\n" +
                "\tc.NAME AS rolename\n" +
                "FROM\n" +
                "\torm_user a\n" +
                "LEFT JOIN orm_user_role b ON a.id = b.user_id\n" +
                "LEFT JOIN orm_role c ON b.role_id = c.id";

        codeGenUtil.qrySqlField(sql);
    }
}