package com.javacore.inout;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * desc
 *
 * @Author: qianqian.sun
 * @Date: 2016/4/19
 */
public class BubbleSort {

    public static void main(String[] args) throws ParseException {
        Date date1 = DateUtils.parseDate("2016-05-23 16:39:02", "yyyy-MM-dd hh:mm:ss");
        Date date2 = DateUtils.parseDate("2016-05-23 16:39:03", "yyyy-MM-dd hh:mm:ss");

        System.out.println(DateUtils.truncatedCompareTo(date1, date2, Calendar.SECOND));
        System.out.println(new Date());

    }
}
