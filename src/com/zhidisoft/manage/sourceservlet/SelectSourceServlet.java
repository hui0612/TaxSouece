package com.zhidisoft.manage.sourceservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.SourceDao;
import com.zhidisoft.manage.entity.Source;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/SelectSourceServlet")
public class SelectSourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        SourceDao sd = new SourceDao();
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String industryName = req.getParameter("industryName");
        String organName = req.getParameter("organName");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        List<Source> select = sd.select(page, rows, payerCode, payerName, organName, industryName, startDate, endDate);
        int count = sd.count(payerCode, payerName, organName, industryName, startDate, endDate);

        Map<String,Object> mp = new HashMap<>();
        ObjectMapper ob = new ObjectMapper();
        mp.put("rows",select);
        mp.put("total",count);
        ob.writeValue(resp.getWriter(),mp);





    }
}
