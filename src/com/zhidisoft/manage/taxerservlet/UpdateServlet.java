package com.zhidisoft.manage.taxerservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.OfficeDao;
import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.manage.entity.TaxOfficial;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxOfficialDao tf = new TaxOfficialDao();
        OfficeDao of = new OfficeDao();

        TaxOfficial tff = tf.select1(id);
        Office off = of.selectId(tff.getOrganId());
        List<Office> offices = of.orPullDown();

        req.setAttribute("tff",tff);
        req.setAttribute("off",off);
        req.setAttribute("offs",offices);

        req.getRequestDispatcher("/manage/jsp/editTaxer.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        TaxOfficialDao tf = new TaxOfficialDao();
        TaxOfficial tax = tf.select1(id);

        String taxerCode = req.getParameter("taxerCode") == null ? tax.getTaxerCode():req.getParameter("taxerCode");
        String taxerName = req.getParameter("taxerName")== null ?tax.getTaxerName() :req.getParameter("taxerName");
        String mobile = req.getParameter("mobile")== null ? tax.getMobile():req.getParameter("mobile");
        String address = req.getParameter("address")== null ? tax.getAddress():req.getParameter("address");
        String sex = req.getParameter("sex")== null ? tax.getSex():req.getParameter("sex");
        String birthday = req.getParameter("birthday")== null ? tax.getBirthday():req.getParameter("birthday");
        String email = req.getParameter("email")== null ? tax.getEmail():req.getParameter("email");
        int organId = Integer.parseInt(req.getParameter("organId")== null ? String.valueOf(tax.getOrganId()) :req.getParameter("organId"));
        boolean b = tf.updateTaxer(taxerCode, taxerName, mobile, address, sex, birthday, email, organId, id);
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
