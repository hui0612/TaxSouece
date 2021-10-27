package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @<code>行业代码表工具类</code>
 * **/
public class IndustryDao {

    public List<TaxPayer1> add(
            String payerCode,
            String payerName,
            String organName,
            String industryName,
            String legalPerson,
            String legalIdCard,
            String finaceName,
            String finaceIdCard,
            String bizAddress,
            String bizScope,
            String bizAddressPhone,
            String invoiceType){
        String sql = "insert into  tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id (payerCode,payerName,organName,industryName,legalPerson,legalIdCard,finaceName,finaceIdCard" +
                "bizAddress,bizScope,bizAddressPhone,invoiceType) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
        List<Map<String, String>> query = DBUtil.query(sql, payerCode,payerName,organName,industryName,
                legalPerson,legalIdCard,finaceName,finaceIdCard,bizAddress,bizScope,
                bizAddressPhone,invoiceType);
        List l = new ArrayList<>();
        for (Map<String ,String> mp:query) {
            TaxPayer1 ta = new TaxPayer1();
            BeanUtil.mapToBean(ta,mp);
            l.add(ta);
        }
        return l;
    }
    public Industry select(int id){
        String sql = "select * from tb_industry where id = ?";
        Industry in = new Industry();
        List<Map<String, String>> query = DBUtil.query(sql, id);
        for (Map<String, String> mp:query) {
            BeanUtil.mapToBean(in,mp);
        }
        return in;
    }
}
