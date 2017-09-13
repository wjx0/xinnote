package com.xin.note.common;

import com.xin.note.common.enums.LanguagesEnum;

import java.util.List;

public interface MultiLanguageService<T extends EntityBean> extends BaseService<T>{
    List<T> selectByLanguage(T record, LanguagesEnum languagesEnum);

    T selectOneByLanguage(T record, LanguagesEnum languagesEnum);
}
