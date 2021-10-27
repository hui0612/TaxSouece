package com.zhidisoft.manage.servlet;

import com.zhidisoft.manage.dao.DateDao;
import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/ToAddServlet")
public class ToAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaxpayerDao td = new TaxpayerDao();
        TaxOfficialDao tf = new TaxOfficialDao();
        List<Industry> tax1 = td.indPullDown();
        List<Office> tax2 = td.orPullDown();
        List<Taxpayer> tax3 = td.inPullDown();
        List<TaxOfficial> select = tf.select();
        String form = DateDao.form(new Date());


        req.setAttribute("tax1",tax1);//行业
        req.setAttribute("tax2",tax2);// 所属税务机关
        req.setAttribute("tax3",tax3);//票种核定
        req.setAttribute("off",select);//票种核定
        req.setAttribute("date",form);//票种核定
        req.getRequestDispatcher("/manage/jsp/addTaxPayer.jsp").forward(req,resp);

    }
}
