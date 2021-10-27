package com.zhidisoft.system.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/NewPasswordServlet")
public class NewPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");
        String oldPassword = req.getParameter("oldPassword");
        String newPassword = req.getParameter("newPassword");
        UserDao us = new UserDao();
        User user = us.selectName(username);
        Map<String ,String> mp = new HashMap<>();
        if(oldPassword.equals(user.getPassword())){
            boolean update = us.update(newPassword, user.getId());
            if(update){
                mp.put("msg","成功");
            }else {
                mp.put("msg","失败");
            }

        }else {
            mp.put("msg","密码不正确");
        }
        ObjectMapper ob = new ObjectMapper();
        ob.writeValue(resp.getWriter(),mp);

    }
}
