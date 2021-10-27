package com.zhidisoft.manage.sourceservlet;

import com.zhidisoft.manage.dao.*;
import com.zhidisoft.manage.entity.*;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/DetailsServlet")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SourceDao sd = new SourceDao();
        TaxpayerDao tax = new TaxpayerDao();
        UserDao us = new UserDao();
        TaxOfficialDao tf = new TaxOfficialDao();
        TaxFundDao tu = new TaxFundDao();
        OfficeDao of = new OfficeDao();
        IndustryDao in  = new IndustryDao() ;

        TaxFund s = tu.select(id);
        Taxpayer payer = tax.select(s.getPayerId()); // p
        User user = us.select(payer.getUserId());//u1 批准人
        TaxOfficial taxOfficial1 = tf.select1(s.getApproverId());//u1 批准人
        TaxOfficial taxOfficial2 = tf.select1(s.getExecuteId());//u1  执行人员
        Office office1 = of.selectId(s.getSubOrganId());//下达部门
        Office office2 = of.selectId(payer.getTaxOrganId());//所属税务机关
        Industry industry = in.select(payer.getIndustryId());//行业


        req.setAttribute("payer",payer);
        req.setAttribute("user" ,user);
        req.setAttribute("taxer1",taxOfficial1);
        req.setAttribute("taxer2",taxOfficial2);
        req.setAttribute("or1",office1);
        req.setAttribute("or2",office2);
        req.setAttribute("in",industry);
        req.setAttribute("s",s);


        req.getRequestDispatcher("/manage/jsp/taskInfo.jsp").forward(req,resp);



    }
}
