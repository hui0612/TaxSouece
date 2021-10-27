package com.zhidisoft.manage.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.TaxpayerDao;
import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.manage.entity.Taxpayer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/TaxUpDateServlet")
public class TaxUpDateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxpayerDao td = new TaxpayerDao();
        Taxpayer tax = td.Taxselect1(id);
        List<Industry> tax1 = td.indPullDown();
        List<Office> tax2 = td.orPullDown();
        List<Taxpayer> tax3 = td.inPullDown();

        req.setAttribute("tax",tax);//对象
        req.setAttribute("tax1",tax1);//行业
        req.setAttribute("tax2",tax2);// 所属税务机关
        req.setAttribute("tax3",tax3);//票种核定
        req.getRequestDispatcher("manage/jsp/editTaxPayer.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaxpayerDao td = new TaxpayerDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Taxpayer tax = td.Taxselect1(id);

        String payerCode = req.getParameter("payerCode") == "" ? tax.getPayerCode():req.getParameter("payerCode");
        String payerName = req.getParameter("payerName") == "" ?tax.getPayerName():req.getParameter("payerName");
        String bizAddress = req.getParameter("bizAddress")== "" ?tax.getBizAddress():req.getParameter("bizAddress");
        String bizAddressPhone = req.getParameter("bizAddressPhone")== "" ?tax.getBizAddressPhone(): req.getParameter("bizAddressPhone");
        int taxOrganid = Integer.parseInt(req.getParameter("taxOrganid")== "" ? String.valueOf(tax.getTaxOrganId()) :req.getParameter("taxOrganid"));
        int industryId = Integer.parseInt(req.getParameter("industryId")== "" ? String.valueOf(tax.getIndustryId()) :req.getParameter("industryId"));
        String bizScope = req.getParameter("bizScope")== "" ? tax.getBizScope():req.getParameter("bizScope");
        String invoiceType = req.getParameter("invoiceType")== "" ?tax.getInvoiceType():req.getParameter("invoiceType");
        String legalPerson = req.getParameter("legalPerson")== "" ?tax.getLegalPerson():req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard")== "" ? tax.getLegalIdCard():req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName")== "" ?tax.getFinaceName():req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard")== "" ?tax.getFinaceIdCard():req.getParameter("finaceIdCard");

        boolean b = td.TaxUpdate(payerCode, payerName, bizAddress, bizAddressPhone,
                taxOrganid, industryId, bizScope, invoiceType,
                legalPerson, legalIdCard, finaceName, finaceIdCard, id);
        Map<String ,Object> mp= new HashMap<>();
        if (b == true){
            mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }
        ObjectMapper mp1 = new ObjectMapper();
        mp1.writeValue(resp.getWriter(),mp);


    }
}
