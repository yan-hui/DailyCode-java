package lone.wolf.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description:日期工具类，不同格式的日期之间 的转换、处理
 * @author: hechunhui
 * @CreateTime: 2017/9/25 11:37
 * @ModifyBy:
 */
public class DateUtils {

    /**
     * 时间类型yyyy-MM-dd HH:mm:ss
     */
    public final static String DATE_FULL_TIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间类型yyyy-MM-dd
     */
    public final static String DATE = "yyyy-MM-dd";
    /**
     * 时间格式yyyyMMdd
     */
    public final static String DATE_YYYYMMDD = "yyyyMMdd";
    /**
     * 年月，时间格式yyyy-MM
     */
    public final static String DATE_YYYY_MM = "yyyy-MMM";
    /**
     * 年月，时间格式yyyyMM
     */
    public final static String DATE_FOR_YEARMONTH = "yyyyMM";
    /**
     * 月日，时间格式MM-dd
     */
    public final static String DATE_FOR_MONTH_DAY = "MM-dd";
    /**
     * 月日，时间格式MMdd
     */
    public final static String DATE_FOR_MONTHDAY = "MMdd";
    /**
     * 日，时间格式dd
     */
    public final static String DATE_FOR_DAY = "dd";


    /**
     * 获取当前系统时间的日期字符串
     *
     * @return
     */
    public static String getNow(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date currentDate = new Date();
        String fullTime = sdf.format(currentDate);
        return fullTime;
    }

    /**
     * 格式化制定时间
     *
     * @param date    日期时间
     * @param pattren 格式化规则
     * @return
     */
    public static String getDate(Date date, String pattren) {
        if (null == pattren) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattren);
        String dateStr = format.format(date);
        return dateStr;
    }

    /**
     * 将字符串转换成时间
     *
     * @param dateStr 时间字符串
     * @param pattren 格式化规则
     * @return
     */
    public static Date getDateStr(String dateStr, String pattren) throws ParseException {
        if (null == pattren) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(pattren);
        Date date = format.parse(dateStr);
        return date;
    }


    /**
     * Long的时间转String
     *
     * @param date    需要转换的时间的Long类型
     * @param pattern 转换的格式
     * @return
     */
    public static String longToString(long date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date nowTime = new Date(date);
        String stringDate = sdf.format(nowTime);
        return stringDate;
    }


    /**
     * 距离多少个时间的日期，传正整数3,表示3年/月/日 后的日期，负数则表示多久之前的日期
     *
     * @param nowTime      传入的时间,当前系统时间传null
     * @param renewalsData 多少年/月/日前使用负数，几年/月/日后使用正数 例如，3 月前 -3，三月后
     * @param pattern      转换格式
     * @param CalendarType 特定于日历的值，分为年月日时分秒  Calendar.MONTH、Calendar.YEAR等
     * @return 指定时间前/后多久的时间
     */
    public static String getDateAfterAddDays(Date nowTime, int renewalsData, String pattern, int CalendarType) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String nowDate;
        if (nowTime != null) {
            nowDate = sdf.format(nowTime);
        } else {
            Date currentDate = new Date();
            nowDate = sdf.format(currentDate);

        }
        Date now = null;
        try {
            now = sdf.parse(nowDate);
        } catch (ParseException e) {
            throw new RuntimeException("转换错误!");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(CalendarType, renewalsData);
        String time = sdf.format(calendar.getTime());
        return time;
    }


    /**
     * 获取当前日历年份
     *
     * @return
     */
    public int getCalendarYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前日历月份
     *
     * @return
     */
    public int getCalendarMonth() {
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        return month;
    }

    /**
     * 获取当前日历日期
     *
     * @return
     */
    public int getCalendarDay() {
        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DATE);
        return today;
    }

    /**
     * 比较两个时间相差几天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getBetweenDay(Date date1, Date date2) {
        Calendar calendar = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        calendar.setTime(date1);
        calendar2.setTime(date2);
        int days = calendar2.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR);
        int year = calendar2.get(Calendar.YEAR);
        if (calendar.get(Calendar.YEAR) != year) {
            do {
                days += calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
                calendar.add(Calendar.YEAR, 1);
            } while (calendar.get(Calendar.YEAR) != year);
        }
        return days;
    }

    /**
     * 获取输入日期到日期月份月底所剩的天数
     *
     * @param date
     * @return 输入日期里所在月份月底剩余的天数
     */
    public static int getNumForDateToLastDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int daysNum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dateOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("这个月天数" + daysNum);
        System.out.println("日期所在的天数" + dateOfMonth);
        return daysNum - dateOfMonth;
    }

    /**
     * 输入日期到月头的天数
     *
     * @param date
     * @return 输入日期是这个月的第几天
     */
    public static int getNumDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int num = calendar.get(Calendar.DAY_OF_MONTH);
        return num;
    }

    /**
     * 指定日期所在月份有几天
     *
     * @param date
     * @return 天数
     */
    public static int getDayNumForDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int daysNum = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return daysNum;
    }

    /**
     * 判断指定时间是星期几
     *
     * @param day     时间
     * @param pattern 转换格式
     */
    public static String getDayOfWeek(String day, String pattern) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try {
            date = dateFormat.parse(day);
        } catch (ParseException e) {
            throw new RuntimeException("输入的时间 " + day + "格式错误");
        }
        calendar.setTime(date);
        int currDay = calendar.get(Calendar.DAY_OF_WEEK);
        String week =null;
        switch (currDay) {
            case 1:
                System.out.println(day + " 是星期日");
                week="星期日";
                break;
            case 2:
                System.out.println(day + " 是星期一");
                week="星期一";
                break;
            case 3:
                System.out.println(day + " 是星期二");
                week="星期二";
                break;
            case 4:
                System.out.println(day + " 是星期三");
                week="星期三";
                break;
            case 5:
                System.out.println(day + " 是星期四");
                week="星期四";
                break;
            case 6:
                week="星期五";
                System.out.println(day + " 是星期五");
                break;
            case 7:
                week="星期六";
                System.out.println(day + " 是星期六");
                break;

            default:
                break;
        }
        return week;
    }


    public static void main(String[] args) throws ParseException {

        String now = getNow(DATE_YYYYMMDD);
        System.out.println("getNow(): " + now);
        String str1 = "20160201";
        String str2 = "20160501";

        Date date1 = getDateStr(str1, DATE_YYYYMMDD);
        Date date2 = getDateStr(str2, DATE_YYYYMMDD);
        System.out.println("getDateStr(): " + date1);
        System.out.println("getDateStr(): " + date2);

        String dateStr1 = getDate(date1, DATE_YYYYMMDD);
        String dateStr2 = getDate(date2, DATE_YYYYMMDD);
        System.out.println("getDate(): " + dateStr1);
        System.out.println("getDate(): " + dateStr2);

        String longToString = longToString(new Date().getTime(), DATE_YYYYMMDD);
        System.out.println("longToString(): " + longToString);

        String after3Year = DateUtils.getDateAfterAddDays(date1, 3, DateUtils.DATE, Calendar.YEAR);
        String after3Month = DateUtils.getDateAfterAddDays(date1, 3, DateUtils.DATE, Calendar.MONTH);
        String after3Day = DateUtils.getDateAfterAddDays(date1, -3, DateUtils.DATE, Calendar.DATE);
        String after3Hour = DateUtils.getDateAfterAddDays(date1, 3, DateUtils.DATE_FULL_TIME, Calendar.HOUR);
        String after3Minute = DateUtils.getDateAfterAddDays(date1, 3, DateUtils.DATE_FULL_TIME, Calendar.MINUTE);
        String after3Second = DateUtils.getDateAfterAddDays(date1, 3, DateUtils.DATE_FULL_TIME, Calendar.SECOND);
        System.out.println("3年后" +after3Year);
        System.out.println("3月后" +after3Month);
        System.out.println("3日后" +after3Day);
        System.out.println("3小时后" +after3Hour);
        System.out.println("3分钟后" +after3Minute);
        System.out.println("3秒后" +after3Second);

        int betweenDay = getBetweenDay(date1, date2);
        System.out.println("相差："+betweenDay);


        int numForDateToLastDay = getNumForDateToLastDay(date1);
        System.out.println("指定时间离指定时间所在月份的月底还剩："+numForDateToLastDay);

        int numDayOfMonth = getNumDayOfMonth(date1);
        System.out.println("指定时间是指定时间月份的第 "+numDayOfMonth+"天");


        int dayNumForDate = getDayNumForDate(date1);
        System.out.println("指定时间所在月份的天数 "+dayNumForDate);


        String dayOfWeek = getDayOfWeek(dateStr1, DATE_YYYYMMDD);
        System.out.println(dayOfWeek);


    }


}
