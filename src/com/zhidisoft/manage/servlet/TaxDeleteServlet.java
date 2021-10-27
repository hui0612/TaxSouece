package com.zhidisoft.manage.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxpayerDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/TaxDeleteServlet")
public class TaxDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxpayerDao td = new TaxpayerDao();
        boolean b = td.TaxDelete(id);
        Map<String , Object> mp = new HashMap<>();
        if(b == true){
            mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }

        ObjectMapper ma = new ObjectMapper();
        ma.writeValue(resp.getWriter(),mp);
    }
}
