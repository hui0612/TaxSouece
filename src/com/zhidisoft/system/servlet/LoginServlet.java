package com.zhidisoft.system.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取表单数据
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");//账号
        String password = req.getParameter("password");//密码
        String code = req.getParameter("code");//验证码

        String ch = req.getParameter("ch1");//记住密码
        System.out.println(ch);
        //获取验证码数据
        HttpSession session = req.getSession();
        String att = (String) session.getAttribute("code");
        //获取免密登录数据
        String attribute = (String) session.getAttribute("ch");
        Map<String , Object> mp =new HashMap<>();
        //从数据库查数据
        UserDao u = new UserDao();
        User user = u.selectID(name, password);

        //判断是否免密登录
        if(attribute != null){
            if(name.equals(attribute)){
                mp.put("userExsitjian",true);
            }else {
                mp.put("userExsitjian",false);
                mp.put("msg","账号或密码不正确");
            }
        }else {
            //判断验证码是否为空
            if(code !=null){
                //判断验证码正确
                if(code.equals(att)){
                    //判断用户名和密码是否正确
                    if(name.equals(user.getUsername())&&password.equals(user.getPassword())){

                        //判断是否点击记住密码
                        if (ch != null){
                            session.setAttribute("ch",name);
                            session.setAttribute("username",name);
                            mp.put("userExsitjian",true);

                        }else {
                            session.setAttribute("username",name);
                            mp.put("userExsitjian",true);
                        }

                    }else {
                        mp.put("userExsitjian",false);
                        mp.put("msg","账号或密码不正确");
                    }

                }else {
                    mp.put("userExsitjian",false);
                    mp.put("msg","验证码不正确");
                }

            }else {
                mp.put("userExsitjian",false);
                mp.put("msg","验证码不正确");
            }
        }
        ObjectMapper ma = new ObjectMapper();
        ma.writeValue(resp.getWriter(),mp);

    }
}
