package main.java.pinhong.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.pinhong.dao.impl.BizDaoImpl;
import main.java.pinhong.entity.Message;
import main.java.pinhong.service.impl.BizServiceImpl;

/**
 * Servlet implementation class MessageServlet
 */
public class MessageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        BizDaoImpl bdi = new BizDaoImpl();
        BizServiceImpl bsi = new BizServiceImpl();
        bsi.setBizDao(bdi);
        List<Message> listMessage = bsi.getAllMessage();
        HttpSession session = request.getSession();
        session.setAttribute("listMessage", listMessage);
        request.getRequestDispatcher("Jsp_Proscenium/S_MessageBoard.jsp").forward(request, response);
    }
}
