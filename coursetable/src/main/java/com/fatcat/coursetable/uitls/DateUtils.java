package com.fatcat.coursetable.uitls;

import android.util.Log;

import java.util.Calendar;

/**
 * Created by EsauL on 2016-10-06.
 */

public class DateUtils {

    public static final int dayMills=24*60*60*1000;

    /**
     * 根据当前周计算课表开始的时间截
     * @param calendar
     * @param currWeek
     * @return
     */
    public static final long countBeginTime(Calendar calendar,int currWeek){

        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        long time=calendar.getTime().getTime()-(long)((calendar.get(Calendar.DAY_OF_WEEK)+7*currWeek))*dayMills;
        return time;

    }

    /**
     * 计算两个时间截的周数差
     * @param beginTime 开始时间截
     * @param endTime 结束时间截
     * @return 返回一个代表周数差的整数
     */
    public static final int countCurrWeek(long beginTime,long endTime){
        Log.i("时间截：","》》》》》》》》》"+beginTime+" , "+endTime);
        long diff=endTime-beginTime;
        int week=(int)(diff/(7*dayMills));
        return week;
    }

    /**
     * 计算两个时间截的差模7（一个星期）求余后的天数，用于求星期几
     * @param beginTime 开始时间截
     * @param endTime 结束时间截
     * @return 返回一个代表一个星期的第几天的整数
     */
    public static final int countCurrWeekDay(long beginTime,long endTime){
        Log.i("时间截：","》》》》》》》》》"+beginTime+" , "+endTime);
        long diff=endTime-beginTime;
        long week=diff%(7*dayMills);
        int day=(int)(week/(dayMills));
        return day;
    }

}
