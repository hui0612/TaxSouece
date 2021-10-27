package com.zhidisoft.manage.sourceservlet;

import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.Office;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaxpayerDao td = new TaxpayerDao();
        List<Office> off = td.orPullDown();
        List<Industry> ind = td.indPullDown();
        req.setAttribute("off",off);
        req.setAttribute("ind",ind);
        req.getRequestDispatcher("/manage/jsp/searchTask.jsp").forward(req,resp);


    }
}
