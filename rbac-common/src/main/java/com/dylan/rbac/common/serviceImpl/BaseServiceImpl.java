package com.dylan.rbac.common.serviceImpl;


import com.dylan.rbac.common.exception.ServiceException;
import com.dylan.rbac.common.mapper.BaseMapper;
import com.dylan.rbac.common.model.ModelBean;
import com.dylan.rbac.common.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseServiceImpl<E extends ModelBean, M extends BaseMapper, PK> implements BaseService<E, PK> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public abstract M getMapper();

    public abstract PK getPrimaryKey(E obj);

    @Override
    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public E get(PK pk) {
        return (E) this.getMapper().selectByPrimaryKey(pk);
    }

    @Override
    public E insert(E obj) throws ServiceException {
        // 插入公共字段
        if(this.getMapper().insert(obj) == 1){
            return obj;
        }
        return null;
    }

    @Override
    public E update(E obj) throws ServiceException {
        if( this.getMapper().updateByPrimaryKeySelective(obj) == 1){
            PK pk = this.getPrimaryKey(obj);
            return this.get(pk);
        }
        return null;
    }

    @Override
    public E delete(PK pk) throws ServiceException {
        E obj = this.get(pk);
        if(this.getMapper().deleteByPrimaryKey(pk) == 1){
            return obj;
        }
        return null;
    }
}
