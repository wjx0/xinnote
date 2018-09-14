package com.github.pagehelper.dialect.helper;

import com.github.pagehelper.Page;
import com.github.pagehelper.dialect.AbstractHelperDialect;
import org.apache.ibatis.cache.CacheKey;

/**
 * @author xin
 * 因为原分页插件row_id参数与表中字段可能冲突的问题，
 * 对源代码覆盖修改为row_ids,该类加载顺序优先,会将jar包里相同class覆盖掉
 */
public class OracleDialect extends AbstractHelperDialect {

    @Override
    public String getPageSql(String sql, Page page, CacheKey pageKey) {
        StringBuilder sqlBuilder = new StringBuilder(sql.length() + 120);
        if (page.getStartRow() > 0) {
            sqlBuilder.append("SELECT * FROM ( ");
        }
        if (page.getEndRow() > 0) {
            sqlBuilder.append(" SELECT TMP_PAGE.*, ROWNUM ROW_IDS FROM ( ");
        }
        sqlBuilder.append(sql);
        if (page.getEndRow() > 0) {
            sqlBuilder.append(" ) TMP_PAGE WHERE ROWNUM <= ");
            sqlBuilder.append(page.getEndRow());
            pageKey.update(page.getEndRow());
        }
        if (page.getStartRow() > 0) {
            sqlBuilder.append(" ) WHERE ROW_IDS > ");
            sqlBuilder.append(page.getStartRow());
            pageKey.update(page.getStartRow());
        }
        return sqlBuilder.toString();
    }

}
