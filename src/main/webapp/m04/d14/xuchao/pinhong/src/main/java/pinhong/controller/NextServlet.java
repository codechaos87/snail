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
 * Servlet implementation class NextServlet
 */
public class NextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        LimitPage limitPage = (LimitPage) session.getAttribute("limitPage");
        List<Product> listLimitPro = (List<Product>) session.getAttribute("listLimitPro");
        int currentPage = limitPage.getCurrentPage();
        currentPage++;
        limitPage.setCurrentPage(currentPage);
        listLimitPro = bsi.limitPageProduct(limitPage);
        session.setAttribute("listLimitPro", listLimitPro);
        session.setAttribute("limitPage", limitPage);
        request.getRequestDispatcher("Jsp_Proscenium/M_ShowProduct.jsp").forward(request, response);
    }
}
