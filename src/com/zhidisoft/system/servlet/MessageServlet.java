package com.zhidisoft.system.servlet;

import com.zhidisoft.manage.dao.TaxOfficialDao;
import com.zhidisoft.manage.entity.TaxOfficial;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        UserDao us = new UserDao();
        TaxOfficialDao td = new TaxOfficialDao();
        User user = us.selectName(username);
        System.out.println(user);
        TaxOfficial taxOfficial = td.select1(user.getTaxerId());
        System.out.println(taxOfficial);

        session.setAttribute("taxer",taxOfficial);
        session.setAttribute("user",user);
        resp.sendRedirect("/manage/jsp/userInfo.jsp");



    }
}
