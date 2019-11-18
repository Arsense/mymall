package com.macro.mymall.shop.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author tangwei
 * @date 2019/11/18 11:10
 */
public class DateUtil {

    /**
     * 从Date类型的时间中提取 时分秒
     */
    public static Date getDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MINUTE, 0);
        return calendar.getTime();
    }


    /**
     * 从Date类型的时间中提取 时分秒
     */
    public static Date getTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, 0);
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 0);
        return calendar.getTime();
    }

}
