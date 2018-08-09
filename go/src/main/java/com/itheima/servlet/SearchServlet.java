package com.itheima.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.model.Product;
import com.itheima.service.SearchService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    private SearchService searchService = new SearchService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得浏览器提交过来的action
        String action = request.getParameter("action");
        //这是多条件搜索方法
        if ("search".equals(action)) {
            search(request, response);
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //创建一个空的json字符串
        String jsonData = null;

        try {
            //获得浏览器提交过来的参数
            String pname = request.getParameter("pname");
            String minPrice = request.getParameter("minPrice");
            String maxPrice = request.getParameter("maxPrice");
            String category = request.getParameter("category");
            //通过这4个参数调用业务层返回商品集合
            List<Product> products = searchService.sreach(pname, minPrice, maxPrice, category);
            jsonData = new ObjectMapper().writeValueAsString(products);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(jsonData);
        }

        response.getWriter().print(jsonData);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
