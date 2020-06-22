package com.authority.manager.web.dao;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.model.SysMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:52
 * @Description
 * @Version 1.0
 **/
@Repository
public interface SysMenuDao extends BaseDao<SysMenu,String> {

    List<SysMenu> findByTypeNot(int menuType);
}
