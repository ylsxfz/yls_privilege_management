package com.authority.manager.web.service.impl;

import com.authority.manager.repository.BaseDao;
import com.authority.manager.web.dao.SysUserRoleDao;
import com.authority.manager.web.model.SysUserRole;
import com.authority.manager.web.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:04
 * @Description
 * @Version 1.0
 **/
@Transactional
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Autowired
    private SysUserRoleDao sysUserRoleDao;
    @Override
    public BaseDao getDao() {
        return sysUserRoleDao;
    }


}
