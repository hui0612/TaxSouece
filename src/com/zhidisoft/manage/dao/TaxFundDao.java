package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.TaxFund;
import com.zhidisoft.manage.entity.TaxOfficial;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaxFundDao {

    public boolean  add(int payerId,
                        String taskName,
                        int subOrganId,
                        int approverId,
                        int executeId,
                        String executeTime,
                        String taskState){
        String sql = "insert into tb_tax_source (payerId,taskName,subOrganId,approverId,executeId,executeTime," +
                "taskState) values (?,?,?,?,?,?,?)";
        boolean update = DBUtil.update(sql, payerId, taskName, subOrganId, approverId,
                executeId, executeTime, taskState);
        return update;
    }

   public TaxFund select(int id){
       String sql = "select * from tb_tax_source where id = ?";
       List<Map<String, String>> query = DBUtil.query(sql,id);
        TaxFund tf = new TaxFund();
       for (Map<String,String> mp:query) {
           BeanUtil.mapToBean(tf,mp);
       }
        return tf;
   }

   public boolean taxUpdate(int id,int payerId,String taskName,int  subOrganId,
                            int approverId,int executeId,String executeTime,
                            String taskState){
        String sql = "update tb_tax_source set payerId = ?,taskName = ?,subOrganId = ?,approverId = ?," +
                "executeId = ?,executeTime = ?,taskState = ? where id = ?";
       boolean update = DBUtil.update(sql, payerId, taskName, subOrganId,
               approverId, executeId, executeTime,
               taskState, id);
       return update;
   }
}
