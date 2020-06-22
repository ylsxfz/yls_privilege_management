package com.authority.manager.web.service;

import com.authority.manager.repository.BaseService;
import com.authority.manager.web.model.SysDept;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 11:49
 * @Description
 * @Version 1.0
 **/
public interface SysDeptService extends BaseService<SysDept,String> {
    List<SysDept> findDeptTree();
}
