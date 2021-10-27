package com.zhidisoft.manage.servlet;

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

@WebServlet("/TaxpayerServlet")
public class TaxpayerServlet extends HttpServlet {
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
        System.out.println(payerCode);
        System.out.println(payerName);
        TaxpayerDao td = new TaxpayerDao();
        Map<String , Object> mp = new HashMap<>();
        List<TaxPayer1> tax = null;
        int i = 0;
        if((payerCode != ""  && payerCode != null) || (payerName != "" && payerName != null)){
            if((payerCode != ""  && payerCode != null) && (payerName != "" && payerName != null)){
                tax = td.dimFenye2(payerCode, payerName);
                i = td.dimFenyeCount2(payerCode, payerName);
            }else {
                if(payerName != "" && payerName != null){
                    tax = td.dimFenye(payerName);
                    i = td.dimFenyeCount(payerName);
                }
                if(payerCode != ""  && payerCode != null){
                    tax = td.dimFenye1(payerCode);
                    i = td.dimFenyeCount1(payerCode);

                }
            }
        }else {
            tax = td.fenye(page, rows);
            i = td.count();
        }
        mp.put("rows",tax);
        mp.put("total",i);
        ObjectMapper ma = new ObjectMapper();
        ma.writeValue(resp.getWriter(),mp);

    }
}
