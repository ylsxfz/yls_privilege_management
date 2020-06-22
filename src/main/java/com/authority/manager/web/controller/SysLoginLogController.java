package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.web.model.SysLoginLog;
import com.authority.manager.web.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_login_log")
public class SysLoginLogController {
    @Autowired
    private SysLoginLogService sysLoginLogService;

    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLoginLog> records){
        sysLoginLogService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysLoginLogService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }
}
