package com.zhidisoft.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*" ,initParams = {@WebInitParam(name = "encoding",value = "UTF-8")})
public class EncodingFilter implements Filter {
    private String encoding="UTF-8";
    public void init(FilterConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        if(encoding != null){
            this.encoding = encoding;
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        req.setCharacterEncoding(encoding);
        resp.setContentType(encoding);
        resp.setCharacterEncoding(encoding);
        chain.doFilter(req,resp);
    }
}
