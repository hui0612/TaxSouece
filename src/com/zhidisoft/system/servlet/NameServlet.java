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
/**
 * @<code>验证用户名是否可用</code>
 * */
@WebServlet("/nameServlet")
public class NameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        System.out.println(username);
        UserDao ub = new UserDao();
        User user = ub.selectName(username);
        Map<String , Object> mp =new HashMap<>();
        if(username.equals(user.getUsername())){
            mp.put("userExsitjian",true);
            mp.put("msg","用户名不可用");
        }else {
            mp.put("userExsitjian",false);
            mp.put("msg","用户名可用");
        }
        System.out.println(mp);
        ObjectMapper ma = new ObjectMapper();
        ma.writeValue(resp.getWriter(),mp);


    }
}
