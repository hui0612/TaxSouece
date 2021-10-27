package com.zhidisoft.system.dao;

import com.zhidisoft.system.entity.User;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.List;
import java.util.Map;

public class UserDao {

    /**
     * @<code>查询账号密码</code>
     * */
    public User selectID(String username,String passowrd){
        String sql = "select username,password from tb_user where username = ? and password = ?";
        User us = new User();
        List<Map<String, String>> query = DBUtil.query(sql,username,passowrd);
        for (Map<String ,String> mp: query) {
            us = new User(mp.get("username"),mp.get("password"));
        }
        return us;
    }

    /**
     * @<code>查询账号是否可用</code>
     * */
    public User selectName(String username){
        String sql = "select * from tb_user where username = ? ";
        User us = new User();
        List<Map<String, String>> query = DBUtil.query(sql,username);
        for (Map<String ,String> mp: query) {
           BeanUtil.mapToBean(us,mp);
        }
        return us;
    }
    /**按id*/
    public User select(int id){
        String sql = "select * from tb_user where id = ?";
        User us = new User();
        List<Map<String, String>> query = DBUtil.query(sql,id);
        for (Map<String ,String> mp: query) {
            BeanUtil.mapToBean(us,mp);
        }
        return us;
    }
    /**修改密码*/
    public boolean update(String password,int id){
        String sql = "update tb_user set password = ? where id = ?";
        boolean update = DBUtil.update(sql,password, id);
        return update;
    }

}
