package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.web.model.SysLog;
import com.authority.manager.web.service.SysLogService;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author yls
 * @Date 2020/4/5 12:21
 * @Description 系统配置控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @PreAuthorize("hasAuthority('sys:dict:delete')")
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysLog> records){
        sysLogService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysLogService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }

}
