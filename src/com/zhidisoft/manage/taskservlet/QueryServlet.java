package com.zhidisoft.manage.taskservlet;

import com.mysql.cj.util.StringUtils;
import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id") == null ? "0" : req.getParameter("id");
        String payerCode = req.getParameter("payerCode") == null ? "0" : req.getParameter("payerCode");
        TaxPayer1 tax = null;
        TaxpayerDao td = new TaxpayerDao();
        TaxOfficialDao tf = new TaxOfficialDao();
        if(id != "0"){
            tax = td.Taxselect(Integer.parseInt(id));
        }
        if(payerCode != "0"){
            tax = td.getpayerCode(payerCode);
        }
        List<Office> offices = td.orPullDown();
        List<TaxOfficial> select = tf.select();
        List<Industry> industries = td.indPullDown();
        req.setAttribute("tax",tax);
        req.setAttribute("off",offices);
        req.setAttribute("se",select);
        req.setAttribute("in",industries);
        req.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(req,resp);

    }
}
