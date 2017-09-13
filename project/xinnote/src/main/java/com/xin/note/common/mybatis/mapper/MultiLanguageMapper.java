package com.xin.note.common.mybatis.mapper;

import com.xin.note.common.enums.LanguagesEnum;
import com.xin.note.common.mybatis.provider.MultiLanguageSelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface MultiLanguageMapper<T> {
    /**
     * 根据实体中的属性值进行查询，查询条件使用等号,同时增加语言参数
     *
     * @param record
     * @return
     */
    @SelectProvider(type = MultiLanguageSelectProvider.class, method = "dynamicSQL")
    List<T> selectByLanguage(@Param("record") T record, @Param("language") LanguagesEnum languagesEnum);

    @SelectProvider(type = MultiLanguageSelectProvider.class, method = "dynamicSQL")
    T selectOneByLanguage(@Param("record") T record, @Param("language") LanguagesEnum languagesEnum);
}
