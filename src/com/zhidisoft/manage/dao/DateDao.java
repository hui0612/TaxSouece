package com.zhidisoft.manage.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDao {
    public static  String form(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
