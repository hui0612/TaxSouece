package com.zhidisoft.manage.taxerservlet;

import com.zhidisoft.manage.dao.OfficeDao;
import com.zhidisoft.manage.entity.Office;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ToInsertServlet")
public class ToInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OfficeDao of = new OfficeDao();
        List<Office> offices = of.orPullDown();
        req.setAttribute("offs",offices);
        req.getRequestDispatcher("/manage/jsp/addTaxer.jsp").forward(req,resp);
    }
}
