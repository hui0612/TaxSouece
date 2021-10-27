package com.zhidisoft.manage.taxerservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxOfficialDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/InsertTaxerServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taxerCode = req.getParameter("taxerCode") ;
        String taxerName = req.getParameter("taxerName");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        int organId = Integer.parseInt(req.getParameter("organId"));
        TaxOfficialDao tf = new TaxOfficialDao();
        boolean b = tf.insertTaxer(taxerCode, taxerName, mobile, address, sex, birthday, email, organId);
        Map<String ,String> mp = new HashMap<>();
        if(b){
            mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }
        ObjectMapper ob = new ObjectMapper();
        ob.writeValue(resp.getWriter(),mp);
    }
}
