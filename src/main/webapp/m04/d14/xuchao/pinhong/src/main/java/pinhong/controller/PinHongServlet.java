/**
 * Project Name:pinhong
 * File Name:PinHongServlet.java
 * Package Name:main.java.pinhong.controller
 * Date:2018年4月12日下午7:42:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.pinhong.dao.impl.BizDaoImpl;
import main.java.pinhong.entity.News;
import main.java.pinhong.entity.Product;
import main.java.pinhong.service.impl.BizServiceImpl;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:42:34 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class PinHongServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        List<News> listNews=bsi.getAllNews();
        List<Product> listPro=bsi.getAllProduct();
        HttpSession session=req.getSession();
        session.setAttribute("listNews", listNews);
        session.setAttribute("listPro", listPro);
        req.getRequestDispatcher("Jsp_Proscenium/M_Index.jsp").forward(req, resp);;
    }

}

