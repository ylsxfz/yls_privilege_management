package com.authority.manager.web.dao;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.model.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:57
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysUserRoleDao extends BaseDao<SysUserRole,String> {
    //根据userid查询
    List<SysUserRole> findByUserId(String userId);
}
