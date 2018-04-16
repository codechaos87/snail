package main.java.pinhong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.pinhong.dao.impl.BizDaoImpl;
import main.java.pinhong.entity.LimitPage;
import main.java.pinhong.entity.Product;
import main.java.pinhong.service.impl.BizServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        LimitPage limitPage = new LimitPage();
        int totalPageSize = bsi.getTotalPageSize();
        int pageSize = limitPage.getPageSize();
        int lastPage = totalPageSize % pageSize == 0 ? totalPageSize / pageSize : totalPageSize / pageSize + 1;
        // 要先将尾页的值传进去 不然无法做比较
        limitPage.setLastPage(lastPage);
        limitPage.setCurrentPage(1);
        List<Product> listLimitPro = bsi.limitPageProduct(limitPage);
        HttpSession session = request.getSession();
        session.setAttribute("listLimitPro", listLimitPro);
        session.setAttribute("limitPage", limitPage);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
    }
}
