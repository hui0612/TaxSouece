package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Source;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SourceDao {
    /**
     * 拼接查询
     *
     * */
    public List<Source> select( int page ,int size,
                                  String payerCode,
                                  String payerName,
                                  String organName,
                                  String industryName,
                                  String executeTime,
                                  String recordTaskDate){
        boolean pc = payerCode != null && payerCode.length() > 0;
        System.out.println(pc);
        boolean pn = payerName != null && payerName.length() > 0;
        System.out.println(pn);
        boolean in = industryName != null && industryName.length() > 0;
        boolean bi = organName != null && organName.length() > 0;
        boolean ex = executeTime != null && executeTime.length() > 0;
        boolean re = recordTaskDate != null && recordTaskDate.length() > 0;

        String sql = "select s.*,p.*,timestampdiff(day,executeTime,recordTaskDate) as timeOutfrom from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id WHERE  p.removeState=0 ";
        if(pc){
          sql = sql+" and payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and payerName like '%" + payerName +"%'";
        }
        if(in){
            sql = sql+" and i.industryName = '" + industryName + "'";
        }
        if(bi){
            sql = sql+" and o.organName = '" + organName + "'";
        }
        if(ex){
            sql = sql+" and s.executeTime = '" + executeTime + "'";
        }
        if(re){
            sql = sql+" and s.recordTaskDate = '" + recordTaskDate + "'";
        }
        sql = sql + " limit ?,?";
        System.out.println(sql);
        List<Map<String, String>> query = DBUtil.query(sql, (page - 1) * size, size);
        List<Source> l = new ArrayList<>();
        for (Map<String, String> mp:query) {
            Source so = new Source();
            BeanUtil.mapToBean(so,mp);
            l.add(so);
        }
        return l;
    }


    /*
    * 查询记录数
    * */

    public int count(
                    String payerCode,
                    String payerName,
                    String organName,
                    String industryName,
                    String executeTime,
                    String recordTaskDate){
        boolean pc = payerCode != null && payerCode.length() > 0;
        System.out.println(pc);
        boolean pn = payerName != null && payerName.length() > 0;
        System.out.println(pn);
        boolean in = industryName != null && industryName.length() > 0;
        boolean bi = organName != null && organName.length() > 0;
        boolean ex = executeTime != null && executeTime.length() > 0;
        boolean re = recordTaskDate != null && recordTaskDate.length() > 0;

        String sql = "select count(s.id)  from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id WHERE  p.removeState=0 ";
        if(pc){
            sql = sql+" and payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and payerName like '%" + payerName +"%'";
        }
        if(in){
            sql = sql+" and i.industryName = '" + industryName + "'";
        }
        if(bi){
            sql = sql+" and o.organName = '" + organName + "'";
        }
        if(ex){
            sql = sql+" and s.executeTime = '" + executeTime + "'";
        }
        if(re){
            sql = sql+" and s.recordTaskDate = '" + recordTaskDate + "'";
        }
        System.out.println(sql);
        List<Map<String, String>> query = DBUtil.query(sql);
        int s = Integer.parseInt(query.iterator().next().get("count(s.id)"));
        System.out.println(s);
        return s;
    }

    /*
    *
    * */

    public Source select1(int id){
        String sql = "select s.*,p.*,timestampdiff(day,executeTime,recordTaskDate) as timeOutfrom from tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id WHERE  p.removeState=0 and s.id = ?";
        System.out.println(sql);
        List<Map<String, String>> query = DBUtil.query(sql,id);
        Source so = new Source();
        for (Map<String, String> mp:query) {
            BeanUtil.mapToBean(so,mp);
        }
        return so;
    }

    public boolean delete(int id){
        String sql = "update tb_tax_source s join tb_tax_payer p join tb_tax_organ o join tb_industry i on s.payerId=p.id and s.subOrganId=o.id and p.industryId=i.id  set s.removeState=1 WHERE s.id = ? ";
        boolean update = DBUtil.update(sql, id);
        return update;
    }
}
