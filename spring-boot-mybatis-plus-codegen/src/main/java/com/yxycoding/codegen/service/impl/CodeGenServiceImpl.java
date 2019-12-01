package com.yxycoding.codegen.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.db.Entity;
import cn.hutool.setting.dialect.Props;
import com.yxycoding.codegen.entity.ColumnEntity;
import com.yxycoding.codegen.entity.GenConfig;
import com.yxycoding.codegen.entity.TableEntity;
import com.yxycoding.codegen.service.CodeGenService;
import com.yxycoding.codegen.utils.CodeGenUtil;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class CodeGenServiceImpl implements CodeGenService {

    @Autowired
    CodeGenUtil codeGenUtil;

    @Override
    public byte[] generatorCode(GenConfig genConfig) {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        //配置信息
        Props props = getConfig();
        //查询列信息
        List<ColumnEntity> columnEntityList = codeGenUtil.qrySqlField(genConfig.getQrySql());

        genConfig.getTableName();


        //表信息
        TableEntity tableEntity = new TableEntity();
        tableEntity.setQrySql(genConfig.getQrySql());
        tableEntity.setTableName(genConfig.getTableName());

        if (StrUtil.isNotBlank(genConfig.getComments())) {
            tableEntity.setComments(genConfig.getComments());
        }
        //表名转换成Java类名
        String className = codeGenUtil.sqlnameToJava(tableEntity.getTableName());
        tableEntity.setCaseClassName(className);
        tableEntity.setLowerClassName(StrUtil.lowerFirst(className));

        tableEntity.setColumns(columnEntityList);

        //没主键，则第一个字段为主键
        if (tableEntity.getPk() == null) {
            tableEntity.setPk(tableEntity.getColumns().get(0));
        }



        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        //封装模板数据
        Map<String, Object> map = new HashMap<>(16);
        map.put("tableName", tableEntity.getTableName());
        map.put("qrySql",tableEntity.getQrySql());
        map.put("pk", tableEntity.getPk());
        map.put("className", tableEntity.getCaseClassName());
        map.put("classname", tableEntity.getLowerClassName());
        map.put("pathName", tableEntity.getLowerClassName().toLowerCase());
        map.put("columns", tableEntity.getColumns());
//        map.put("hasBigDecimal", hasBigDecimal);
        map.put("datetime", DateUtil.now());
        map.put("year", DateUtil.year(new Date()));

        if (StrUtil.isNotBlank(genConfig.getComments())) {
            map.put("comments", genConfig.getComments());
        } else {
            map.put("comments", tableEntity.getComments());
        }

        if (StrUtil.isNotBlank(genConfig.getAuthor())) {
            map.put("author", genConfig.getAuthor());
        } else {
            map.put("author", props.getStr("author"));
        }

        if (StrUtil.isNotBlank(genConfig.getModuleName())) {
            map.put("moduleName", genConfig.getModuleName());
        } else {
            map.put("moduleName", props.getStr("moduleName"));
        }

        if (StrUtil.isNotBlank(genConfig.getPackageName())) {
            map.put("package", genConfig.getPackageName());
            map.put("mainPath", genConfig.getPackageName());
        } else {
            map.put("package", props.getStr("package"));
            map.put("mainPath", props.getStr("mainPath"));
        }
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, CharsetUtil.UTF_8);
            tpl.merge(context, sw);

            System.out.println(template+"::::::::::::::"+sw.toString());
//            try {
//                //添加到zip
//                zip.putNextEntry(new ZipEntry(Objects.requireNonNull(getFileName(template, tableEntity.getCaseClassName(), map
//                        .get("package")
//                        .toString(), map.get("moduleName").toString()))));
//                IoUtil.write(zip, StandardCharsets.UTF_8, false, sw.toString());
//                IoUtil.close(sw);
//                zip.closeEntry();
//            } catch (IOException e) {
//                throw new RuntimeException("渲染模板失败，表名：" + tableEntity.getTableName(), e);
//            }
        }


        IoUtil.close(zip);
        return outputStream.toByteArray();
    }



    /**
     * 获取配置信息
     */
    private Props getConfig() {
        Props props = new Props("generator.properties");
        props.autoLoad(true);
        return props;
    }


    private List<String> getTemplates() {
        List<String> templates = new ArrayList<>();
        templates.add("template/Entity.java.vm");
        templates.add("template/Mapper.java.vm");
        templates.add("template/Mapper.xml.vm");
//        templates.add("template/Service.java.vm");
//        templates.add("template/ServiceImpl.java.vm");
        return templates;
    }



}
