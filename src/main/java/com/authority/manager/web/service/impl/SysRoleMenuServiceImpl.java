package com.authority.manager.web.service.impl;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.dao.SysRoleMenuDao;
import com.authority.manager.web.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Autowired
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public BaseDao getDao() {
        return sysRoleMenuDao;
    }
}
