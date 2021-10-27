package com.zhidisoft.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhidisoft.manage.dao.*;
import com.zhidisoft.manage.entity.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
      TaxOfficialDao tf = new TaxOfficialDao();
        List<TaxOfficial> list = tf.list(1, 3, null);
        for (TaxOfficial l:list) {
            System.out.println(l);

        }
    }
}
