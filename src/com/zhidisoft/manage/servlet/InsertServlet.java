package com.zhidisoft.manage.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.DateDao;
import com.zhidisoft.manage.dao.TaxpayerDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaxpayerDao td = new TaxpayerDao();
        String payerCode = req.getParameter("payerCode") ;
        String payerName = req.getParameter("payerName") ;
        String bizAddress = req.getParameter("bizAddress");
        String bizAddressPhone = req.getParameter("bizAddressPhone");
        int taxOrganid = Integer.parseInt(req.getParameter("taxOrganid"));
        int industryId = Integer.parseInt(req.getParameter("industryId"));
        String bizScope = req.getParameter("bizScope");
        String invoiceType = req.getParameter("invoiceType");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");
        int userId = Integer.parseInt(req.getParameter("userId"));
        String recordDate = DateDao.form(new Date());


        boolean add= td.add(payerCode, payerName, bizAddress, bizAddressPhone, taxOrganid, industryId, bizScope, invoiceType
                , legalPerson, legalIdCard, finaceName, finaceIdCard, userId, recordDate);
        Map<String ,Object> mp= new HashMap<>();
        if (add == true){
            mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }
        ObjectMapper mp1 = new ObjectMapper();
        mp1.writeValue(resp.getWriter(),mp);
    }
}
