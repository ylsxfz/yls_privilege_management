package com.authority.manager.web.dao;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.model.SysRole;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleDao extends BaseDao<SysRole,String> {
    SysRole findByName(String name);
}
