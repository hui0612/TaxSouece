package com.zhidisoft.system.servlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
/**
* @<code>验证码</code>
* */
@WebServlet("/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(120, 45);
        //图形验证码写出，可以写出到文件，也可以写出到流
        lineCaptcha.write(resp.getOutputStream());
        //获取code;
        String code = lineCaptcha.getCode();
        //存到session里
        req.getSession().setAttribute("code",code);
    }
}
