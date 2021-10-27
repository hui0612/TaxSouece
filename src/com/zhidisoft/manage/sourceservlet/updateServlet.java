package com.zhidisoft.manage.sourceservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.*;
import com.zhidisoft.manage.entity.*;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        SourceDao sd = new SourceDao();
        TaxpayerDao tax = new TaxpayerDao();
        UserDao us = new UserDao();
        TaxOfficialDao tf = new TaxOfficialDao();
        TaxFundDao tu = new TaxFundDao();
        OfficeDao of = new OfficeDao();
        IndustryDao in  = new IndustryDao() ;
        TaxpayerDao td = new TaxpayerDao();
        TaxOfficialDao tff = new TaxOfficialDao();
        List<TaxOfficial> select = tff.select();

        List<Office> offices = td.orPullDown();
        TaxFund s = tu.select(id);
        Taxpayer payer = tax.select(s.getPayerId()); // p
        User user = us.select(payer.getUserId());//
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
        req.setAttribute("organs",offices);
        req.setAttribute("taxers",select);



        req.getRequestDispatcher("/manage/jsp/editTask.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxFundDao tf = new TaxFundDao();
        TaxFund select = tf.select(id);
        int payerId = Integer.parseInt(req.getParameter("payerId"));
        String taskName = req.getParameter("taskName") == null ?select.getTaskName():req.getParameter("taskName");
        int subOrganId = Integer.parseInt(req.getParameter("subOrganId") == null ? String.valueOf(select.getSubOrganId()) :req.getParameter("subOrganId"));
        int approverId = Integer.parseInt(req.getParameter("approverId")== null ? String.valueOf(select.getApproverId()) :req.getParameter("approverId"));
        int executeId = Integer.parseInt(req.getParameter("executeId")== null ? String.valueOf(select.getExecuteId()) :req.getParameter("executeId"));
        String executeTime = req.getParameter("executeTime") == null ? select.getExecuteTime() : req.getParameter("executeTime");
        String taskState = req.getParameter("taskState") == null ? select.getTaskState() : req.getParameter("taskState");
        boolean b = tf.taxUpdate(id, payerId, taskName, subOrganId, approverId, executeId, executeTime, taskState);
        Map<String,String> mp = new HashMap<>();
        if(b){
            mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }
        ObjectMapper ob = new ObjectMapper();
        ob.writeValue(resp.getWriter(),mp);

    }
}
