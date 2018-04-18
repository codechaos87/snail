/**
 * Project Name:Demo_dt59_pinHong2
 * File Name:SessionAttributeAccessListener.java
 * Package Name:com.dt59.lister
 * Date:2018年4月17日下午4:45:25
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.lister;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Description:   <br/>
 * Date:     2018年4月17日 下午4:45:25 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class SessionAttributeAccessListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {

        // Auto-generated method stub
        // Logger.info("-------->变量 " + arg0.getName() + " 被添加到session中，其类型为 " +
        // arg0.getValue().getClass().getName());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {

        // Auto-generated method stub
        // logger.info("-------->变量 " + arg0.getName() + " 被从session中移除 ");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {

        // Auto-generated method stub
        // logger.info("---------------->变量 " + arg0.getName() +
        // " 被从session 替换！");
    }

}

