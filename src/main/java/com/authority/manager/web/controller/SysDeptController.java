package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.web.model.SysDept;
import com.authority.manager.web.service.SysDeptService;
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
@RequestMapping("sys_dept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDept record){
        sysDeptService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDept> records){
        sysDeptService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @GetMapping("/findTree")
    public HttpResult findPage(){
        return HttpResult.ok(sysDeptService.findDeptTree());
    }


}
