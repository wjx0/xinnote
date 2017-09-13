package com.xin.note.common.mybatis;

import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

import java.util.Set;

/**
 * @author xin
 * 对通用mapper中不适用的方法做了重写修改
 */
public class CustomizedSqlHelper extends SqlHelper {
    public static final String mainTablePrefix = "main.";
    public static final String languageTablePrefix = "lang.";

    public static String getAllColumns(Class<?> entityClass) {
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        StringBuilder sql = new StringBuilder();
        for (EntityColumn entityColumn : columnList) {
            sql.append(mainTablePrefix).append(entityColumn.getColumn()).append(",");
        }
        return sql.substring(0, sql.length() - 1);
    }

    public static String fromTable(Class<?> entityClass, String defaultTableName) {
        StringBuilder sql = new StringBuilder();
        sql.append(" FROM ");
        sql.append(getDynamicTableName(entityClass, defaultTableName)).append(" "+mainTablePrefix.substring(0,mainTablePrefix.length()-1));
        sql.append(" ");
        return sql.toString();
    }

    public static String whereAllIfColumns(Class<?> entityClass, boolean empty) {
        StringBuilder sql = new StringBuilder();
        sql.append("<where>");
        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        for (EntityColumn column : columnList) {
            sql.append(getIfNotNull("record",column, " AND " +  mainTablePrefix + column.getColumnEqualsHolder("record"), empty));
        }
        sql.append("</where>");
        return sql.toString();
    }
}
