package com.authority.manager.web.controller;

import com.authority.manager.base.SysContants;
import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.base.utils.StringFormatUtils;
import com.authority.manager.web.model.SysRole;
import com.authority.manager.web.model.SysRoleMenu;
import com.authority.manager.web.service.SysRoleSerivce;
import com.authority.manager.web.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_role")
public class SysRoleController {

    @Autowired
    private SysRoleServiceImpl sysRoleSerivce;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record){

        SysRole sysRole = sysRoleSerivce.findByName(record.getName());
        if (sysRole!=null){
            //新增用户
            if (StringFormatUtils.isNull(record.getId()) || "0".equals(record.getId())){
                return  HttpResult.error("角色名已存在！");
            }

            //如果是修改用户角色名
            else if (!sysRole.getId().equals(record.getId())){
                return  HttpResult.error("角色名已存在！");
            }
        }
        sysRoleSerivce.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysRole> records){
        sysRoleSerivce.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysRoleSerivce.findByPage(pageRequest);
        return HttpResult.ok(page);
    }

    @GetMapping(value="/findAll")
    public HttpResult findAll()  {
        try {
            return HttpResult.ok(sysRoleSerivce.findAll());
        }catch (Exception e){
            return HttpResult.error("查询失败！"+e.getMessage());
        }
    }

    @GetMapping(value="/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam String roleId) {
        return HttpResult.ok(sysRoleSerivce.findRoleMenus(roleId));
    }

    @PostMapping(value = "/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records){
        if (records!=null && !records.isEmpty()){
            SysRoleMenu sysRoleMenu = records.get(0);
            Optional optional = sysRoleSerivce.findById(sysRoleMenu.getRoleId());
            if (optional.isPresent()){
                SysRole sysRole = (SysRole) optional.get();
                if (SysContants.ADMIN.equals(sysRole.getName())){
                    return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
                }else {
                    sysRoleSerivce.saveRoleMenus(records);
                }
            }
        }
        return  HttpResult.ok("保存成功!");
    }
}
