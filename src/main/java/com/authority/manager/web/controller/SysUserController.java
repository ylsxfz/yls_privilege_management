package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.security.utils.PasswordUtils;
import com.authority.manager.web.model.SysUser;
import com.authority.manager.web.service.SysUserService;
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
@RequestMapping("sys_user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysUser record){
        Optional optional  = sysUserService.findById(record.getId());

        if (record.getPassword()!=null){
            String salt = PasswordUtils.getSalt();
            System.err.println("判断用户为空："+optional.isPresent());
            if (optional.isPresent()){
                //新增用户
                if(sysUserService.findByName(record.getName()) != null){
                    return HttpResult.error("用户名已存在！");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            }else {

                //修改用户
                if(!record.getPassword().equals("")){
                    String password = PasswordUtils.encode(record.getPassword(),salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        sysUserService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysUser> records){
        sysUserService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @GetMapping(value="/findByName")
    public HttpResult findByUserName(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findByName(name));
    }

    @GetMapping(value="/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        return HttpResult.ok(sysUserService.findPermissions(name));
    }

    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(),myPageRequest.getPageSize());
        Page page = sysUserService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }
}
