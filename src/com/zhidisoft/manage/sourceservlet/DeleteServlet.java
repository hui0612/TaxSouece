package com.zhidisoft.manage.sourceservlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.SourceDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  id = Integer.parseInt(req.getParameter("id"));
        SourceDao so = new SourceDao();
        boolean delete = so.delete(id);
        ObjectMapper ob = new ObjectMapper();
        Map<String,Object> mp= new HashMap<>();
        if(delete){
           mp.put("msg","成功");
        }else {
            mp.put("msg","失败");
        }
        ob.writeValue(resp.getWriter(),mp);

    }
}
