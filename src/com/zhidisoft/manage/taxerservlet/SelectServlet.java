package com.zhidisoft.manage.taxerservlet;

import com.zhidisoft.manage.dao.OfficeDao;
import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.manage.entity.TaxOfficial;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxOfficialDao tf = new TaxOfficialDao();
        OfficeDao of = new OfficeDao();
        TaxOfficial tff = tf.select1(id);
        Office off = of.selectId(tff.getOrganId());
        req.setAttribute("tff",tff);
        req.setAttribute("off",off);
        req.getRequestDispatcher("/manage/jsp/taxerInfo.jsp").forward(req,resp);


    }
}
