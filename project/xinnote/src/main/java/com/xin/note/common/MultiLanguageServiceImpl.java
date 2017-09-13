package com.xin.note.common;

import com.xin.note.common.enums.LanguagesEnum;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xin
 */
public class MultiLanguageServiceImpl<T extends EntityBean>  extends BaseServiceImpl<T> implements MultiLanguageService<T> {
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByLanguage(T record, LanguagesEnum languagesEnum) {
        return mapper.selectByLanguage(record,languagesEnum);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public T selectOneByLanguage(T record, LanguagesEnum languagesEnum) {
        return mapper.selectOneByLanguage(record,languagesEnum);
    }
}
