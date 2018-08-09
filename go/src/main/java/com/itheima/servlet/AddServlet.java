package com.itheima.servlet;

import com.itheima.service.AddService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    private AddService addService = new AddService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pname = request.getParameter("pname");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String desc = request.getParameter("desc");
        try {
            boolean flag = addService.add(pname, price, category, desc);
            if (flag) {
                response.sendRedirect("success.html");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print("服务器忙");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
