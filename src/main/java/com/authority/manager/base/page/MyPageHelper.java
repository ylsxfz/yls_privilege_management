package com.authority.manager.base.page;

import com.authority.manager.base.utils.ReflectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;



/**
 * @Author yls
 * @Description 分页查询助手
 * @Date 2020/4/5 9:39
 **/
public class MyPageHelper {

	public static final String findPage = "findPage";
	
	/**
	 * @Description 分页查询, 约定查询方法名为 “findPage”
	 * @param pageRequest 分页请求
	 * @param mapper Dao对象，MyBatis的 Mapper	
	 * @return
	 */
	public static MyPageResult findPage(MyPageRequest pageRequest, Object mapper) {
		return findPage(pageRequest, mapper, findPage);
	}
	
	/**
	 * @Description 调用分页插件进行分页查询
	 * @param pageRequest 分页请求
	 * @param mapper Dao对象，MyBatis的 Mapper	
	 * @param queryMethodName 要分页的查询方法名
	 * @param args 方法参数
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static MyPageResult findPage(MyPageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
		// 设置分页参数
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		PageHelper.startPage(pageNum, pageSize);
		// 利用反射调用查询方法
		Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
		return getPageResult(pageRequest, new PageInfo((List) result));
	}

	/**
	 * @Description 将分页信息封装到统一的接口
	 * @param pageRequest 分页请求
	 * @param pageInfo
	 * @return
	 */
	private static MyPageResult getPageResult(MyPageRequest pageRequest, PageInfo<?> pageInfo) {
		MyPageResult myPageResult = new MyPageResult();
        myPageResult.setPageNum(pageInfo.getPageNum());
        myPageResult.setPageSize(pageInfo.getPageSize());
        myPageResult.setTotalSize(pageInfo.getTotal());
        myPageResult.setTotalPages(pageInfo.getPages());
        myPageResult.setContent(pageInfo.getList());
		return myPageResult;
	}

}
