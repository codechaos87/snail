/**
 * Project Name:pinhong
 * File Name:SetCharUtil.java
 * Package Name:main.java.pinhong.utils
 * Date:2018年4月16日下午2:16:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午2:16:48 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class SetCharUtil implements Filter {

    @Override
    public void destroy() {

        // Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
            ServletException {
        // Auto-generated method stub
        arg0.setCharacterEncoding("utf-8");
        arg1.setCharacterEncoding("utf-8");
        arg1.setContentType("text/html;charset=utf-8");
        arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

        // Auto-generated method stub

    }

}
