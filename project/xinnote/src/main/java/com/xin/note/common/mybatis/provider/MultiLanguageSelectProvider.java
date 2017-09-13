/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.xin.note.common.mybatis.provider;

import com.xin.note.common.mybatis.CustomizedSqlHelper;
import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

/**
 * 带语言参数的select查询,只能针对单表，且表名规则固定
 *
 * @author xin
 */
public class MultiLanguageSelectProvider extends MapperTemplate {

    public MultiLanguageSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    /**
     * 查询
     *
     * @param ms
     * @return
     */
    public String selectByLanguage(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        StringBuilder sql = getStringBuilder(ms);
        sql.append(CustomizedSqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }

    public String selectOneByLanguage(MappedStatement ms) {
        StringBuilder sql = getStringBuilder(ms);
        return sql.toString();
    }

    private StringBuilder getStringBuilder(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        //修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append(CustomizedSqlHelper.getAllColumns(entityClass).replace(CustomizedSqlHelper.mainTablePrefix+"NAME", CustomizedSqlHelper.languageTablePrefix+"NAME"));
        sql.append(" "+CustomizedSqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(" left join ").append(tableName(entityClass)).append("_LANG ").append(CustomizedSqlHelper.languageTablePrefix.substring(0,CustomizedSqlHelper.languageTablePrefix.length()-1))
                .append(" on "+ CustomizedSqlHelper.mainTablePrefix.substring(0,CustomizedSqlHelper.mainTablePrefix.length()-1)).append(".id = ")
                .append(CustomizedSqlHelper.languageTablePrefix+"KEY_ID and "+ CustomizedSqlHelper.languageTablePrefix+"deleted_flag = '0' and ")
                .append(CustomizedSqlHelper.languageTablePrefix+"LANGUAGE_CODE = #{language.value}");
        sql.append(CustomizedSqlHelper.whereAllIfColumns(entityClass, isNotEmpty()));
        return sql;
    }


}
