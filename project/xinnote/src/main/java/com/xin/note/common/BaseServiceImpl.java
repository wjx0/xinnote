package com.xin.note.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xiaoleilu.hutool.util.BeanUtil;
import com.xin.note.common.enums.DeletedFlagEnum;
import com.xin.note.common.exception.AppException;
import com.xin.note.common.mybatis.mapper.MyMapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 基础service接口实现，转发通用mapper响应方法，具体业务实现Service继承此类即可拥有基本单表常用方法操作
 * @param <T> 参数必须继承BentityBean 因此才有deleted_flag等属性
 * @author xin
 */
public abstract class BaseServiceImpl<T extends EntityBean> implements BaseService<T> {

    protected static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    @Autowired
    protected MyMapper<T> mapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKeyLogical(T key) {
        key.setDeletedFlag(DeletedFlagEnum.DELETED.getValue());
        key.setGmtModified(new Date());
        return mapper.updateByPrimaryKeySelective(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public <K extends Serializable> int deleteByIdLogical(K id) {
        T bean = this.getBean(id);
        return this.deleteByPrimaryKeyLogical(bean);
    }

    /**
     *
     * @param record record中的属性是要删除的条件,由传进来的实体动态生成example
     * @return 影响的行数
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteLogical(T record) {
        Example example = new Example(record.getClass());
        Example.Criteria criteria = example.createCriteria();
        Map<String, Object> properties = BeanUtil.beanToMap(record, false, true);
        for(Map.Entry<String, Object> entry : properties.entrySet()){
            criteria.andEqualTo(entry.getKey(),entry.getValue());
        }
        T entityBean = null;
        try {
            entityBean = (T)record.getClass().newInstance();
        } catch (Exception e) {
            logger.error("实例化更新对象失败",e);
            throw new AppException("实例化更新对象失败",e);
        }
        entityBean.setDeletedFlag(DeletedFlagEnum.DELETED.getValue());
        entityBean.setGmtModified(new Date());
        return mapper.updateByExampleSelective(entityBean,example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByIds(String ids) {
        return mapper.deleteByIds(ids);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByIds(String ids) {
        return mapper.selectByIds(ids);
    }

    /**
     * 单表分页查询
     *
     * @param pageNum
     * @param pageSize
     * @return Page
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Page<T> selectPage (T record,int pageNum,int pageSize) {
        Page<T> page = PageHelper.startPage(pageNum, pageSize);
        mapper.select(record);
        return page;
    }

    /**
     * 得到一个填充了主键的业务实体类
     * @param id 主键id
     * @param <K> 主键类型
     * @return
     */
    protected  <K extends Serializable> T getBean(K id) {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Class<T> clazz = (Class) params[0] ;
        T bean;
        try {
            bean = clazz.newInstance();
        } catch (Exception e) {
            throw new AppException("实例化对象失败",e);
        }
        bean.setId(id);
        return bean;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public <K extends Serializable> T selectById(K id){
        T bean = getBean(id);
        return mapper.selectOne(bean);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public <K extends Serializable> int deleteById(K id){
        T bean = getBean(id);
        return mapper.delete(bean);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByPrimaryKey(Object key){
        return mapper.deleteByPrimaryKey(key);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delete(T record) {
        return mapper.delete(record);
    }



    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insert(T record) {
        return mapper.insert(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insertSelective(T record) {
        return mapper.insertSelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean existsWithPrimaryKey(Object key) {
        return mapper.existsWithPrimaryKey(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T selectByPrimaryKey(Object key) {
        return  mapper.selectByPrimaryKey(key);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int selectCount(T record) {
        return mapper.selectCount(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> select(T record) {
        return mapper.select(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public T selectOne(T record) {
        return  mapper.selectOne(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByPrimaryKeySelective(T record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteByExample(Object example) {
        return mapper.deleteByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public int selectCountByExample(Object example) {
        return mapper.selectCountByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByExample(T record, Object example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateByExampleSelective(T record, Object example) {
        return mapper.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper.selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public List<T> selectByRowBounds(T record, RowBounds rowBounds) {
        return mapper.selectByRowBounds(record,rowBounds);
    }
}
