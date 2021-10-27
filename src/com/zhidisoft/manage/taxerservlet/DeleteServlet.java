package com.zhidisoft.manage.taxerservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxOfficialDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/DeleteTaxerServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxOfficialDao tf= new TaxOfficialDao();
        boolean b = tf.deleteTaxer(id);
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
