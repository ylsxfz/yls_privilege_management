package com.authority.manager.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author yls
 * @Date 2020/3/30 10:01
 * @Description druid监控信息：有多种方式配置，这里采用第二种
 *             1、使用原生的Servlet、Filter方式，然后通过@ServletComponentScan启动扫描包进行处理
 *             2、使用代码注册Servlet和Filter的方式处理。
 * @Version 1.0
 **/
@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServle(){
        //ServletRegistrationBean 提供类进行注册
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean
                = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //添加初始化参数
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //IP黑名单（存在共同时，deny优先于allow）
        //如果满足deny，就提示：sorry，you are not permitted to view this page。
        servletRegistrationBean.addInitParameter("deny","192.168.1.73");
        //登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername","admin");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否能够重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean
                = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
