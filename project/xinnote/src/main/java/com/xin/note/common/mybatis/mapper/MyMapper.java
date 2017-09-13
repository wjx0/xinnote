package com.xin.note.common.mybatis.mapper;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;

public interface MyMapper<T> extends Mapper<T>,IdsMapper<T>,MultiLanguageMapper<T> {
}
