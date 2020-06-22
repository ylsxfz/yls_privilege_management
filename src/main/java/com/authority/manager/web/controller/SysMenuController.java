package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.web.model.SysMenu;
import com.authority.manager.web.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_menu")
public class SysMenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysMenu record){
        sysMenuService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysMenu> records){
        sysMenuService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }


    @GetMapping(value="/findNavTree")
    public HttpResult findNavTree(@RequestParam String userName) {
        return HttpResult.ok(sysMenuService.findTree(userName, 1));
    }

    @GetMapping("/findMenuTree")
    public HttpResult delete(){
        return HttpResult.ok(sysMenuService.findTree(null,0));
    }
}
