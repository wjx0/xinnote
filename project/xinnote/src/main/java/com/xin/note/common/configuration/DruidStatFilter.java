package com.xin.note.common.configuration;


import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(filterName="DruidStatFilter",urlPatterns="/*",
        initParams={
                @WebInitParam(name="principalSessionName",value = "username"),
                @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*,/login")// 忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter      {

}
