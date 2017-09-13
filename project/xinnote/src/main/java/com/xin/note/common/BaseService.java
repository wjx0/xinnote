package com.xin.note.common;

import com.github.pagehelper.Page;
import tk.mybatis.mapper.common.IdsMapper;

import java.io.Serializable;

public  interface BaseService<T extends EntityBean> extends tk.mybatis.mapper.common.Mapper<T>,IdsMapper<T> {
    /**
     * 公用分页查询
     * @param record 查询条件
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @return 分页结果
     */
     Page<T> selectPage(T record, int pageNum, int pageSize);

     <K extends Serializable> T selectById(K id);

     <K extends Serializable> int deleteById(K id);

    /**
     * 公用逻辑删除
     * @param key 对象
     * @return 删除条数
     */
    int deleteByPrimaryKeyLogical(T key);

    /**
     * 公用逻辑删除
     * @param key 对象
     * @return 删除条数
     */
    <K extends Serializable> int deleteByIdLogical(K id);

    /**
     * 逻辑删除
     * @param record record中的属性是要删除的条件
     * @return 影响的行数
     */
    int deleteLogical(T record);
}
