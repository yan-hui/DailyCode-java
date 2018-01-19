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

    private static Date currentdate;

    static {
        currentdate = new Date();//获取当前系统时间

    }

    /**
     * 时间类型yyyy-MM-dd HH:mm:ss
     */
    public final static String DATE_FULL_TIME = "yyyy-MM-dd HH:mm:ss";
    /**
     * 时间类型yyyy-MM-dd
     */
    public final static String DATE = "yyyy-MM-dd";


    /**
     * 获取当前系统时间的日期字符串yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateFullTime(String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String fullTime = sdf.format(currentdate);
        return fullTime;
    }

    /**
     * 获取时间的字符串yyyy-MM-dd HH:mm:ss
     *
     * @param date    需要转换的时间
     * @param pattern 转换的格式
     * @return
     */
    public static String getStringDate(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String stringDate = sdf.format(date);
        return stringDate;
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
     * @param renewalsData 多少月前使用负数，几个月后使用正数 例如，3 月前 -3，三月后
     * @param pattern      转换格式
     * @param CalendarType 特定于日历的值  Calendar.MONTH、Calendar.YEAR等
     * @return 指定时间前/后多久的时间
     */
    public static String MontgAgo(Date nowTime, int renewalsData, String pattern, int CalendarType) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String nowDate;
        if (nowTime != null) {
            nowDate = sdf.format(nowTime);
        } else {
            nowDate = sdf.format(currentdate);

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

    public static void main(String[] args) throws ParseException {
        String day = DateUtils.MontgAgo(null, -30, DateUtils.DATE, Calendar.DATE);
        String month = DateUtils.MontgAgo(null, 3, DateUtils.DATE, Calendar.MONTH);
        String year = DateUtils.MontgAgo(null, 3, DateUtils.DATE, Calendar.YEAR);
        String hour = DateUtils.MontgAgo(null, 3, DateUtils.DATE_FULL_TIME, Calendar.HOUR);
        String minute = DateUtils.MontgAgo(null, 3, DateUtils.DATE_FULL_TIME, Calendar.MINUTE);
        String second = DateUtils.MontgAgo(null, 3, DateUtils.DATE_FULL_TIME, Calendar.SECOND);
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
        System.out.println("========================================================");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = new Date();
        Date date2 = sdf.parse("2017-11-20 20:20:20");
        int last = getBetweenDay(date1, date2);
        int before = getBetweenDay(date2, date1);
        System.out.println("今天在 2017-11-20 20:20:20 " + last + "天之前");
        System.out.println("2017-11-20 20:20:20在" + Math.abs(before) + "天之后");
    }

    /**
     * 判断指定时间是星期几
     *
     * @param day     时间
     * @param pattern 转换格式
     */
    public static void dayOfWeek(String day, String pattern) {
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
        switch (currDay) {
            case 1:
                System.out.println(day + " 是星期日");
                break;
            case 2:
                System.out.println(day + " 是星期一");
                break;
            case 3:
                System.out.println(day + " 是星期二");
                break;
            case 4:
                System.out.println(day + " 是星期三");
                break;
            case 5:
                System.out.println(day + " 是星期四");
                break;
            case 6:
                System.out.println(day + " 是星期五");
                break;
            case 7:
                System.out.println(day + " 是星期六");
                break;

            default:
                break;
        }
    }

}
