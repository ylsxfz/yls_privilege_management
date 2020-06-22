package com.authority.manager.web.controller;

import com.authority.manager.base.http.HttpConstants;
import com.authority.manager.base.http.HttpResult;
import com.authority.manager.base.page.MyPageRequest;
import com.authority.manager.base.page.MyPageResult;
import com.authority.manager.web.model.SysDict;
import com.authority.manager.web.service.SysDictService;
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
 * @Description 字典管理控制器
 * @Version 1.0
 **/
@RestController
@RequestMapping("sys_dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @PostMapping("/save")
    public HttpResult save(@RequestBody SysDict record){
        sysDictService.save(record);
        return HttpResult.ok(HttpConstants.SAVE_OK);
    }


    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysDict> records){
        sysDictService.deleteAll(records);
        return HttpResult.ok(HttpConstants.DELETE_OK);
    }

    @PostMapping("/findByPage")
    public HttpResult findPage(@RequestBody MyPageRequest myPageRequest){
        PageRequest pageRequest = PageRequest.of(myPageRequest.getPageNum(), myPageRequest.getPageSize());
        Page page = sysDictService.findByPage(pageRequest);
        return HttpResult.ok(page);
    }
}
