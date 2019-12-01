package com.yxycoding.codegen.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import com.mysql.cj.MysqlType;
import com.yxycoding.codegen.entity.ColumnEntity;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodeGenUtil {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    /**
     * 根据查询sql取得sql字段名、字段类型
     * @param sql
     * @return
     */
    public List<ColumnEntity> qrySqlField(String sql){

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        SqlRowSetMetaData metaData = sqlRowSet.getMetaData();
        Props props = getConfig();
        List<ColumnEntity> columnEntityList = new ArrayList<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setColumnName( metaData.getColumnLabel(i));
            columnEntity.setDataType( metaData.getColumnTypeName(i));
            columnEntity.setCaseAttrName(sqlnameToJava(columnEntity.getColumnName()));
            columnEntity.setLowerAttrName(StrUtil.lowerFirst(columnEntity.getCaseAttrName()));

            String attrType = props.getStr(columnEntity.getDataType(), "unknownType");
            columnEntity.setAttrType(attrType);

            columnEntity.setComments(" ");
            columnEntityList.add(columnEntity);
        }

        System.out.println("");

        return  columnEntityList;
    }


    /**
     * sql字段，改为java，首字母大写，以_分割首字母大写，去除_
     * 例：  role_id  --> RoleId
     *
     * @param sqlName
     * @return
     */
    public String sqlnameToJava(String sqlName) {
        return WordUtils.capitalizeFully(sqlName, new char[]{'_'}).replace("_", "");
    }


    private Props getConfig() {
        Props props = new Props("generator.properties");
        props.autoLoad(true);
        return props;
    }

}
