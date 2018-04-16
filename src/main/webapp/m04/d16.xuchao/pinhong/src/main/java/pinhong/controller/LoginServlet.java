package main.java.pinhong.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.pinhong.dao.impl.BizDaoImpl;
import main.java.pinhong.entity.Users;
import main.java.pinhong.service.impl.BizServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // TODO Auto-generated method stub
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Users user = new Users();
        user.setuName(userName);
        user.setuPWD(password);
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        List<Users> listUser = bsi.getAllUser();
        boolean flag = bsi.validateUser(user);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if (flag) {
            session.setAttribute("listUser", listUser);
            session.setAttribute("userName", userName);
            request.getRequestDispatcher("admin/index.jsp").forward(request, response);
        } else {
            out.print("<Script>");
            out.print("alert('用户名或密码错误');");
            out.print("location.href='Jsp_Proscenium/Login.jsp';");
            out.print("</Script>");
            out.flush();
            out.close();
        }
    }

}
