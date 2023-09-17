package com.dylan.rbac.common.service;

import com.dylan.rbac.common.exception.ServiceException;
import com.dylan.rbac.common.log.Loggable;

public interface BaseService<E, PK> extends Loggable {
    E get(PK pk);

    E insert(E obj) throws ServiceException;

    E update(E obj) throws ServiceException;

    E delete(PK pk) throws ServiceException;
}
