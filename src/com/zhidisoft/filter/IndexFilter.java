package com.zhidisoft.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/manage/*")
public class IndexFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession();
        String uri = req.getRequestURI();
        String s = (String) session.getAttribute("username");

       if(uri.contains("login.jsp") || uri.contains("loginServlet") || uri.contains("codeServlet")){
           chain.doFilter(req,resp);
       }else {
           if(s == null ){
               resp.sendRedirect(req.getContextPath()+"/login.jsp");
           }else {
               chain.doFilter(req,resp);
           }
       }
    }
    @Override
    public void destroy() {

    }
}
