package com.yxycoding.codegen.entity;


import lombok.Data;

@Data
public class TableRequest {

    /**
     * 表名
     */
    private String tableName;

    private String qrySql;
}
