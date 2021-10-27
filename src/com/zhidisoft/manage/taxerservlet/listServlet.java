package com.zhidisoft.manage.taxerservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.entity.TaxOfficial;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/listServlet")
public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        String taxerName = req.getParameter("taxerName");
        TaxOfficialDao tf = new TaxOfficialDao();
        List<TaxOfficial> list = tf.list(page, rows, taxerName);
        int count = tf.count(taxerName);
        ObjectMapper ob = new ObjectMapper();
        Map<String,Object> mp = new HashMap<>();
        mp.put("rows",list);
        mp.put("total",count);
        ob.writeValue(resp.getWriter(),mp);

    }
}
