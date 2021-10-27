package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.manage.entity.TaxOfficial;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaxOfficialDao {

    public List<TaxOfficial> select(){
        String sql = "select * from tb_taxer";
        List<Map<String, String>> query = DBUtil.query(sql);
        List<TaxOfficial> l = new ArrayList<>();
        for (Map<String,String> mp:query) {
            TaxOfficial tf = new TaxOfficial();
            BeanUtil.mapToBean(tf,mp);
            l.add(tf);
        }
        return l;
    }
    public TaxOfficial select1(int id){
        String sql = "select * from tb_taxer where id = ?";
        List<Map<String, String>> query = DBUtil.query(sql,id);
        TaxOfficial tf = new TaxOfficial();
        for (Map<String,String> mp:query) {
            BeanUtil.mapToBean(tf,mp);
        }
        return tf;
    }
    public List<TaxOfficial> list(int page,int size,String taxerName){
        String sql = "select * from tb_taxer where removeState = 0";
        boolean b = taxerName != null && taxerName.length() > 0;
        if(b){
            sql = sql + " and taxerName like '%" + taxerName +"%'";
        }
        sql = sql + " limit ?,?";
        System.out.println(sql);
        List<Map<String, String>> query = DBUtil.query(sql, (page - 1) * size, size);
        List<TaxOfficial> l = new ArrayList<>();
        for (Map<String, String> mp:query) {
            TaxOfficial tf= new TaxOfficial();
            BeanUtil.mapToBean(tf,mp);
            l.add(tf);
        }

        return l;
    }

    public int count(String taxerName){
        String sql = "select count(id) from tb_taxer where removeState = 0 ";
        boolean b = taxerName != null && taxerName.length() > 0;
        if(b){
            sql = sql + " and taxerName like '%" + taxerName +"%'";
        }
        List<Map<String, String>> query = DBUtil.query(sql);
        int s = Integer.parseInt(query.iterator().next().get("count(id)"));
        return s;
    }

    public boolean updateTaxer(String taxerCode,
                               String taxerName,
                               String mobile,
                               String address,
                               String sex,
                               String birthday,
                               String email,
                               int organId,
                               int id){
        String sql = "update tb_taxer set taxerCode = ? ,taxerName=?,mobile = ? ,address = ? ,sex=?, birthday = ?,email= ?,organId=? where id = ?";
        boolean update = DBUtil.update(sql, taxerCode, taxerName, mobile, address, sex, birthday, email, organId, id);
        return update;
    }

    public boolean deleteTaxer(int id){
        String sql = "update tb_taxer  set removeState=1 where id=?";
        boolean update = DBUtil.update(sql, id);
        return update;
    }

    public boolean insertTaxer(String taxerCode,
                               String taxerName,
                               String mobile,
                               String address,
                               String sex,
                               String birthday,
                               String email,
                               int organId
                               ){
        String sql = "insert into tb_taxer (taxerCode ,taxerName,mobile,address ,sex, birthday,email,organId) value (?,?,?,?,?,?,?,?)";
        boolean update = DBUtil.update(sql, taxerCode, taxerName, mobile, address, sex, birthday, email, organId);
        return update;
    }
}
