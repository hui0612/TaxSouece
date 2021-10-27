package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @<code>税务机关表工具类</code>
 * **/
public class OfficeDao {

    public List<Office> orPullDown(){
        String sql = "select organName ,id from tb_tax_organ GROUP BY organName ";
        List<Map<String, String>> list = DBUtil.query(sql);
        List<Office> l = new ArrayList();
        for (Map<String,String> o:list) {
            Office ta = new Office();
            BeanUtil.mapToBean(ta,o);
            l.add(ta);
        }
        return  l;
    }

    public Office selectId(int id){
        String sql = "select * from tb_tax_organ where id = ?";
        List<Map<String, String>> query = DBUtil.query(sql, id);
        Office of = new Office();
        for (Map<String, String> mp:query) {
            BeanUtil.mapToBean(of,mp);
        }
        return of;
    }
}
