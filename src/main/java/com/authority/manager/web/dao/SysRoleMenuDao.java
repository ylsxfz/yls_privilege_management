package com.authority.manager.web.dao;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.model.SysRole;
import com.authority.manager.web.model.SysRoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:54
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu,String> {
    List<SysRoleMenu> findByRoleId(String roleId);
}
