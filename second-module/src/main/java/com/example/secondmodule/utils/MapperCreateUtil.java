package com.example.secondmodule.utils;

import com.example.secondmodule.dao.GardenDaoImpl;
import com.example.secondmodule.entity.*;
import org.dom4j.*;
import org.dom4j.dom.DOMText;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public class MapperCreateUtil {

    private static String tableName;
    private static String daoUrl;
    private static Map<String,String> constantMap = new HashMap<>();
    private static String resultName;
    private static List<Field> fieldList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        setConstantMap(ChannelType.class);
//        buildXML(ChannelType.class, "cn.com.payment.order.dao.impl.ChannelTypeDaoImpl");
        setConstantMap(OrderDetail.class);
        buildXML(OrderDetail.class, "cn.com.payment.order.dao.impl.ChannelTypeDaoImpl");
//        setConstantMap(PayChannel.class);
//        buildXML(PayChannel.class, "cn.com.payment.order.dao.impl.ChannelTypeDaoImpl");
//        setConstantMap(PayeeOnline.class);
//        buildXML(PayeeOnline.class, "cn.com.payment.order.dao.impl.ChannelTypeDaoImpl");
//        setConstantMap(SysSetting.class);
//        buildXML(SysSetting.class, "cn.com.payment.order.dao.impl.ChannelTypeDaoImpl");
    }

    public static void buildXML(Class entity, String dao) throws IOException {
        resultName = entity.getSimpleName()+"Map";
        if (tableName == null) {
            tableName = getConstant(entity.getSimpleName());
        }
        daoUrl = dao;
        System.out.println(entity.getClassLoader().toString());
        Document document = DocumentHelper.createDocument();
        document.addDocType("mapper", "-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd", null);
        //<mapper>
        Element mapperElement = document.addElement("mapper");
        mapperElement.addAttribute("namespace", daoUrl);
        //<table>
        Element table = mapperElement.addElement("sql");
        table.addAttribute("id", "table");
        table.addText(tableName);
        //<resultMap>
        Element resultMapElement = mapperElement.addElement("resultMap");
        resultMapElement.addAttribute("id", resultName)
                .addAttribute("type", entity.getSimpleName());
        //<selectConditionSql>
        Element selectConditionSql = mapperElement.addElement("sql");
        selectConditionSql.addAttribute("id", "select_condition_sql");
        //<insertFrontConditionSql>
        Element insertFrontConditionSql = mapperElement.addElement("sql")
                .addAttribute("id", "insert_front_condition_sql");
        //<insertBehindConditionSql>
        Element insertBehindConditionSql = mapperElement.addElement("sql")
                .addAttribute("id", "insert_behind_condition_sql");
        //<updateConditionSql>
        Element updateConditionSql = mapperElement.addElement("sql")
                .addAttribute("id", "update_condition_sql");


        resultMapElement.addElement("id")
                .addAttribute("column", "id")
                .addAttribute("property", "id")
                .addAttribute("jdbcType", "BIGINT");
        for (Field field : fieldList) {
            if (field.getModifiers() > 10 || field.getName().equals("id")) {
                continue;
            }
            Element condition = selectConditionSql.addElement("if");
            Element result = resultMapElement.addElement("result");
            if (field.getType() == String.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"VARCHAR");
            }
            if (field.getType() == Date.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"TIMESTAMP");
            }
            if (field.getType() == Short.class || field.getType() == short.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"SMALLINT");
            }
            if (field.getType() == Long.class || field.getType() == long.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"BIGINT");
            }
            if (field.getType() == Float.class || field.getType() == float.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"FLOAT");
            }
            if (field.getType() == Integer.class || field.getType() == int.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"INTEGER");
            }
            if (field.getType() == Byte.class || field.getType() == byte.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"TINYINT");
            }
            if (field.getType() == Boolean.class || field.getType() == boolean.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"BOOLEAN");
            }
            if (field.getType() == BigDecimal.class) {
                spliceSql(result,condition,insertFrontConditionSql,insertBehindConditionSql,updateConditionSql,field,"DECIMAL");
            }
        }

        //<insert>
        Element insert = mapperElement.addElement("insert");
        insert.addAttribute("id", "insert")
                .addAttribute("parameterType", entity.getSimpleName())
                .addText("insert into")
                .addElement("include").addAttribute("refid", "table");
            //front
        Element insertFrontTrim = insert.addElement("trim").addAttribute("prefix", "(")
                .addAttribute("suffix", ")")
                .addAttribute("suffixOverrides", ",");
        insertFrontTrim.addElement("include").addAttribute("refid", "insert_front_condition_sql");
            //behind
        Element insertBehindTrim = insert.addElement("trim").addAttribute("prefix", "values (")
                .addAttribute("suffix", ")")
                .addAttribute("suffixOverrides", ",");
        insertBehindTrim.addElement("include").addAttribute("refid", "insert_behind_condition_sql");

        //<update>
        Element update = mapperElement.addElement("update")
                .addAttribute("id", "update")
                .addAttribute("parameterType", entity.getSimpleName())
                .addText("update");
        update.addElement("include").addAttribute("refid", "table");
        update.addElement("trim")
                .addAttribute("prefix","set")
                .addAttribute("suffixOverrides",",")
                .addElement("include")
                .addAttribute("refid", "update_condition_sql");
        update.addText("where id = #{id, jdbcType=BIGINT}");

        //<delete>
        Element delete = mapperElement.addElement("delete")
                .addAttribute("id", "deleteById")
                .addAttribute("parameterType", "java.lang.Long")
                .addText("update");
        delete.addElement("include")
                .addAttribute("refid", "table");
        delete.addText("set valid_state = 0 where id = #{id, jdbcType=BIGINT}");

        //<listPage>
        Element pageList = mapperElement.addElement("select")
                .addAttribute("id", "listPage")
                .addAttribute("parameterType", "java.util.Map")
                .addAttribute("resultMap", resultName)
                .addText("select * from ");
        pageList.addElement("include")
                .addAttribute("refid", "table");
        pageList.addElement("where")
                .addElement("include")
                .addAttribute("refid", "select_condition_sql");
        pageList.addText(" order by id desc ");


        //<listBy>
        Element listBy = mapperElement.addElement("select")
                .addAttribute("id", "listBy")
                .addAttribute("parameterType", "java.util.Map")
                .addAttribute("resultMap", resultName)
                .addText("select * from ");
        listBy.addElement("include")
                .addAttribute("refid", "table");
        listBy.addElement("where")
                .addElement("include")
                .addAttribute("refid", "select_condition_sql");
        listBy.addText(" order by id desc ");

        //<getById>
        Element getById = mapperElement.addElement("select")
                .addAttribute("id", "getById")
                .addAttribute("parameterType", "java.lang.Long")
                .addAttribute("resultMap", resultName)
                .addText("select * from ");
        getById.addElement("include")
                .addAttribute("refid", "table");
        getById.addText("where id = #{id, jdbcType=BIGINT}");

        document.setXMLEncoding("UTF-8");
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("UTF-8");
//        outputFormat.setSuppressDeclaration(true);
        outputFormat.setNewlines(true);
        StringWriter stringWriter = new StringWriter();
        XMLWriter xmlWriter = new XMLWriter(stringWriter, outputFormat);

        xmlWriter.write(document);
        // 打印字符串,即是XML文档
//        System.out.println(stringWriter.toString());
        xmlWriter.close();

        Writer fileWriter = new FileWriter("E:/test/"+entity.getSimpleName()+"Mapper.xml");
        fileWriter.write(stringWriter.toString());
        fileWriter.flush();
        fileWriter.close();


    }


    public void buildXML(Class entity, String dao, String tableName) throws IOException {
        this.tableName = tableName;
        buildXML(entity, dao);
    }

    private static void spliceSql(Element result,Element condition,Element insertFrontConditionSql,Element insertBehindConditionSql,Element updateConditionSql,Field field,String type) {
        result.addAttribute("column", constantMap.get(field.getName()));
        result.addAttribute("property", field.getName());
        result.addAttribute("jdbcType", type);

        StringBuilder attribute = new StringBuilder();
        attribute.append(field.getName() + " != null ");
        if (type.equals("VARCHAR")) {
            attribute.append("and " + field.getName() + " != ''");
        }

        condition.addAttribute("test", attribute.toString())
                .addText("and " + constantMap.get(field.getName()) + "=#{" + field.getName() + ",jdbcType=" + type + "}");

        insertFrontConditionSql.addElement("if")
                .addAttribute("test", attribute.toString())
                .addText(constantMap.get(field.getName())+",");

        insertBehindConditionSql.addElement("if")
                .addAttribute("test", attribute.toString())
                .addText("#{"+field.getName()+",jdbcType="+type+"},");

        updateConditionSql.addElement("if")
                .addAttribute("test", attribute.toString())
                .addText(constantMap.get(field.getName())+"=#{"+field.getName()+",jdbcType="+type+"},");
    }

    /**
     * 设置常量
     * @param entity
     */
    public static void setConstantMap(Class entity) {
        Class tempClass = entity;
        while (tempClass != null) {
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass();
        }
        for (Field field : fieldList) {
            if (field.getModifiers() < 10) {
                constantMap.put(field.getName(), getConstant(field.getName()));
            }
        }
    }

    /**
     * 获取常量
     * @param name
     */
    public static String getConstant(String name) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = name.toCharArray();
        //转ASCLL
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1){
                if (chars[i] < 97) {
                    if (i == 0) {
                        sbu.append(chars[i] + 32).append(",");
                        continue;
                    }
                    sbu.append(95)
                            .append(",")
                            .append(chars[i] + 32)
                            .append(",");
                }else{
                    sbu.append((int)chars[i]).append(",");
                }
            }else {
                sbu.append((int)chars[i]);
            }
        }
        //转String
        String[] charList = sbu.toString().split(",");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charList.length; i++) {
            stringBuffer.append((char) Integer.parseInt(charList[i]));
        }
        return stringBuffer.toString();
    }
}
