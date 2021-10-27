package com.zhidisoft.manage.sourceservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.TaxPayer1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/NoServlet")
public class NoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        TaxpayerDao tp  = new TaxpayerDao();
        List<TaxPayer1> taxPayer1s = tp.noSurvey(page, rows, payerCode, payerName);
        int i = tp.noCount(page, rows, payerCode, payerName);
        ObjectMapper ob = new ObjectMapper();
        Map<String,Object> mp = new HashMap<>();
        mp.put("rows",taxPayer1s);
        mp.put("total",i);
        ob.writeValue(resp.getWriter(),mp);

    }
}
