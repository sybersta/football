package com.example.football.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public Date getLastDate(String firstDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
// 定义当前期间的1号的date对象
        Date date = null;
        try {
            date = dateFormat.parse(firstDay);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH,1);//月增加1天
        calendar.add(Calendar.DAY_OF_MONTH,-1);//日期倒数一日,既得到本月最后一天
        Date voucherDate = calendar.getTime();
        return voucherDate;
    }
    public  static void main(String [] args)throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateUtil d=new DateUtil();
        Date date=d.getLastDate("20210201");
        System.out.println(dateFormat.format(date));
    }
}
