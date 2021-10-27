package com.zhidisoft.manage.servlet;

import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.TaxPayer1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
 * @<code>查询详情</code>*/
@WebServlet("/SelectIDServlet")
public class SelectIDServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        TaxpayerDao td = new TaxpayerDao();
        TaxPayer1 select = td.Taxselect(id);
        req.getSession().setAttribute("tp",select);
        resp.sendRedirect("/manage/jsp/details.jsp");

    }
}
