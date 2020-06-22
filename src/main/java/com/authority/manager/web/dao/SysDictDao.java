package com.authority.manager.web.dao;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.model.SysDict;
import org.springframework.stereotype.Repository;

/**
 * @Author yls
 * @Date 2020/4/5 11:50
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysDictDao extends BaseDao<SysDict,String> {
}
