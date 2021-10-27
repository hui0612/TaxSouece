package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.Office;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.manage.entity.Taxpayer;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaxpayerDao {

    public List<TaxPayer1> fenye(int page, int size){
        String sql = "select p.id,p.payerCode,p.payerName,o.organName ,i.industryName ,p.legalPerson ,p.legalIdCard ,p.finaceName ,p.finaceIdCard ,p.recordDate from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id where removeState=0  limit ?,?";
        List<Map<String, String>> query = DBUtil.query(sql,(page-1)*size,size);
        List l = new ArrayList<>();

        for (Map<String ,String> mp:query) {
            TaxPayer1 ta = new TaxPayer1();
            BeanUtil.mapToBean(ta,mp);
            l.add(ta);
        }
        return l;
    }



    public int count(){
        String sql = "select count(p.id) from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id where removeState=0 ";
        List<Map<String, String>> list = DBUtil.query(sql);
        int a = Integer.parseInt(list.iterator().next().get("count(p.id)"));
        return  a;
    }
    /**
     * 查询详细信息*/
    public TaxPayer1 Taxselect(int id){
        String sql = "select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id where p.id = ? ";
        List<Map<String, String>> list = DBUtil.query(sql,id);
        TaxPayer1 ta = new TaxPayer1();
        for (Map<String,String> o:list) {
            BeanUtil.mapToBean(ta,o);
        }
        return  ta;
    }

    /**
     * 查询详细信息*/
    public TaxPayer1 getpayerCode(String payerCode){
        String sql = "select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id where p.payerCode = ? ";
        List<Map<String, String>> list = DBUtil.query(sql,payerCode);
        TaxPayer1 ta = new TaxPayer1();
        for (Map<String,String> o:list) {
            BeanUtil.mapToBean(ta,o);
        }
        return  ta;
    }

    /**
     * 查询详细信息*/
    public Taxpayer Taxselect1(int id){
        String sql = "select * from tb_tax_payer where id = ? ";
        List<Map<String, String>> list = DBUtil.query(sql,id);
        Taxpayer ta = new Taxpayer();
        for (Map<String,String> o:list) {
            BeanUtil.mapToBean(ta,o);
        }
        return  ta;
    }
/**
 * 删除*/
    public boolean  TaxDelete(int id){
        String sql = "update tb_tax_payer set removeState=1 where id = ? ";
        boolean update = DBUtil.update(sql, id);
        return  update;
    }
/**
 * 修改*/
    public boolean TaxUpdate(
            String payerCode,
            String payerName,
            String bizAddress,
            String bizAddressPhone,
            int taxOrganid,
            int industryId,
            String bizScope,
            String invoiceType,
            String legalPerson,
            String legalIdCard,
            String finaceName,
            String finaceIdCard,
            int id ){
        String sql = "update tb_tax_payer set payerCode = ?, payerName = ? ,bizAddress=?," +
                " bizAddressPhone= ?,taxOrganid= ?,industryId= ?,bizScope= ?,invoiceType=" +
                " ?,legalPerson= ?,legalIdCard= ?," +
                "finaceName= ?,finaceIdCard= ? where id = ? ";

        boolean update = DBUtil.update(sql,payerCode,payerName,bizAddress,bizAddressPhone,taxOrganid,industryId,
                bizScope,invoiceType,legalPerson,legalIdCard,finaceName,finaceIdCard,id);
        return update;
    }


    /**
     * 查询票种核定 */
    public List<Taxpayer> inPullDown(){
        String sql = "select invoiceType ,id from tb_tax_payer GROUP BY invoiceType ";
        List<Map<String, String>> list = DBUtil.query(sql);
        List<Taxpayer> l = new ArrayList();
        for (Map<String,String> o:list) {
            Taxpayer ta = new Taxpayer();
            BeanUtil.mapToBean(ta,o);
            l.add(ta);
        }
        return  l;
    }
    /**
     * 查询所属税务机关 */
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

    /**
     * 查询行业 */
    public List<Industry> indPullDown(){
        String sql = "select industryName,id from tb_industry GROUP BY industryName";
        List<Map<String, String>> list = DBUtil.query(sql);
        List<Industry> l =new ArrayList<>();
        for (Map<String,String> o:list) {
            Industry ta = new Industry();
            BeanUtil.mapToBean(ta,o);
            l.add(ta);
        }
        return  l;
    }

    /**
     * 模糊分页 payerName*/
    public List<TaxPayer1> dimFenye(String payerName){
        String sql = "select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE  removeState = 0 and payerName like ? ";
        String payername = "%" + payerName + "%";
        List<Map<String, String>> query = DBUtil.query(sql,payername);
        List l = new ArrayList<>();
        for (Map<String ,String> mp:query) {
            TaxPayer1 ta = new TaxPayer1();
            BeanUtil.mapToBean(ta,mp);
            l.add(ta);
        }
        return l;
    }

    public int dimFenyeCount(String payerName){
       String sql =  "select count(p.id) from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE  removeState = 0 and payerName like ? ";
        String payername = "%" + payerName + "%";

        List<Map<String, String>> list = DBUtil.query(sql,payername);
        int a = Integer.parseInt(list.iterator().next().get("count(p.id)"));
        return  a;
    }

    /**
     * 模糊分页 payerCode*/
    public List<TaxPayer1> dimFenye1(String payerCode ){
        String sql = "select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE removeState = 0 and payerCode = ? ";
        List<Map<String, String>> query = DBUtil.query(sql,payerCode);
        List l = new ArrayList<>();
        for (Map<String ,String> mp:query) {
            TaxPayer1 ta = new TaxPayer1();
            BeanUtil.mapToBean(ta,mp);
            l.add(ta);
        }
        return l;
    }

    public int dimFenyeCount1(String payerCode){
        String sql =  "select count(p.id) from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE  removeState = 0 and payerCode = ?  ";
        List<Map<String, String>> list = DBUtil.query(sql,payerCode);
        int a = Integer.parseInt(list.iterator().next().get("count(p.id)"));
        return  a;
    }

    /**
     * 模糊分页 payerCode payerName */
    public List<TaxPayer1> dimFenye2(String payerCode,String payerName ){
        String sql = "select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE  removeState = 0 and payerCode = ? and payerName like ? ";
        String payername = "%" + payerName + "%";
        List<Map<String, String>> query = DBUtil.query(sql,payerCode,payername);
        List l = new ArrayList<>();
        for (Map<String ,String> mp:query) {
            TaxPayer1 ta = new TaxPayer1();
            BeanUtil.mapToBean(ta,mp);
            l.add(ta);
        }
        return l;
    }

    public int dimFenyeCount2(String payerCode,String payerName){
        String sql =  "select count(p.id) from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and" +
                " p.industryId=i.id and p.userId=u.id WHERE  removeState = 0 and payerCode = ? and payerName like ? ";
        String payername = "%" + payerName + "%";
        List<Map<String, String>> list = DBUtil.query(sql,payerCode,payername);
        int a = Integer.parseInt(list.iterator().next().get("count(p.id)"));
        return  a;
    }

    public boolean add(String payerCode,
                       String payerName,
                       String bizAddress,
                       String bizAddressPhone,
                       int taxOrganid,
                       int industryId,
                       String bizScope,
                       String invoiceType,
                       String legalPerson,
                       String legalIdCard,
                       String finaceName,
                       String finaceIdCard,
                       int userId,
                       String recordDate){
        String sql = "insert into tb_tax_payer " +
                "(payerCode,payerName,bizAddress,bizAddressPhone," +
                "taxOrganid,industryId,bizScope,invoiceType,legalPerson," +
                "legalIdCard,finaceName,finaceIdCard,userId ,recordDate) values " +
                "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        boolean update = DBUtil.update(sql,payerCode, payerName, bizAddress, bizAddressPhone,
                taxOrganid, industryId, bizScope, invoiceType
                , legalPerson, legalIdCard, finaceName, finaceIdCard, userId, recordDate);
        return update;
    }
    public Taxpayer select(int payerCode){
        String sql = "select * from tb_tax_payer where id= ?";
        List<Map<String, String>> query = DBUtil.query(sql, payerCode);
        Taxpayer ta = new Taxpayer();
        for (Map<String, String> mp:query) {
            BeanUtil.mapToBean(ta,mp);
        }
        return ta;
    }
/**
 * 未被调查
 */

    public List<TaxPayer1> noSurvey(int page ,int size,String payerCode,String payerName){
        String sql = "select * from tb_tax_payer p LEFT join tb_tax_source s on p.id=s.payerId JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id  where s.id is null and p.removeState=0";
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        if(pc){
            sql = sql+" and p.payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and p.payerName like '%" + payerName +"%'";
        }
        sql = sql + " limit ?,?";
        List<Map<String, String>> query = DBUtil.query(sql, (page-1)*size, size);
        List<TaxPayer1> l = new ArrayList<>();
        for (Map<String, String> mp:query) {
            TaxPayer1 tp = new TaxPayer1();
            BeanUtil.mapToBean(tp,mp);
            l.add(tp);
        }
        return l;
    }


    public int noCount(int page ,int size,String payerCode,String payerName){
        String sql = "select count(p.id) from tb_tax_payer p LEFT join tb_tax_source s on p.id=s.payerId JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id  where s.id is null and p.removeState=0";
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        if(pc){
            sql = sql+" and p.payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and p.payerName like '%" + payerName +"%'";
        }
        List<Map<String, String>> query = DBUtil.query(sql);
        int s = Integer.parseInt(query.iterator().next().get("count(p.id)"));
        return s;
    }
}
