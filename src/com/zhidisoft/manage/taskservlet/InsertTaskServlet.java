package com.zhidisoft.manage.taskservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxFundDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/inSelevt.do")
public class InsertTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1);
        int payerId  = Integer.valueOf(req.getParameter("payerId"));
        System.out.println(payerId);
        System.out.println(123);
        String taskName = req.getParameter("taskName")  == null ? "": req.getParameter("taskName");
        System.out.println(1234);
        int subOrganId = Integer.valueOf(req.getParameter("subOrganId")== null ? "0": req.getParameter("subOrganId"));
        System.out.println(12345);
        int approverId = Integer.valueOf(req.getParameter("approverId") == null ? "0":req.getParameter("approverId"));
        System.out.println(123456);
        int executeId = Integer.valueOf(req.getParameter("executeId") == null ? "0": req.getParameter("executeId"));
        System.out.println(1234567);
        String executeTime = req.getParameter("executeTime") == null ? "": req.getParameter("executeTime") ;
        System.out.println(executeTime);
        System.out.println(12345678);
        String taskState = req.getParameter("taskState") == null ? "":  req.getParameter("taskState");
        System.out.println(123456789);
        System.out.println(payerId);
        TaxFundDao tf = new TaxFundDao();
        boolean add = tf.add(payerId, taskName, subOrganId, approverId, executeId, executeTime, taskState);
        Map<String,String> mp = new HashMap<>();
        if(add == true ){
          mp.put("msg","成功") ;
            System.out.println(123);
        }else {
            mp.put("msg","失败") ;
            System.out.println(1234);
        }
        ObjectMapper mp1 = new ObjectMapper();
        mp1.writeValue(resp.getWriter(),mp);

    }
}
