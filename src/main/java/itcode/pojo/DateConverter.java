package itcode.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换相关工具
 * @author unkown
 */
public class DateConverter {





  public static int getDateCount(Date begin, Date end) {
    long m = end.getTime() - begin.getTime();
    double r = (double) m / (1000 * 60 * 60 * 24);
    return (int) (Math.ceil(r));
  }

  public static int getHourCount(Date begin, Date end) {
    long m = end.getTime() - begin.getTime();
    double r = (double) m / (1000 * 60 * 60);
    return (int) (Math.ceil(r));
  }



  /**********************交叉分析********************/
  /**
   * Date类型转String类型
   */
  public static String dateToString(Date date, String format) {
    if (date == null) {
      return null;
    }
    String newDate = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      newDate = sdf.format(date);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return newDate;
  }


  /***
   * String 转日期类型
   * @param date
   * @return
   */
  public static Date StringToDate(String date, String format) {

    Date newDate = null;
    try {
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      newDate = sdf.parse(date);

    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return newDate;
  }



  //是否是月一
  public static boolean isMonth(Date now) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(now);
    int month = cal.get(Calendar.DAY_OF_MONTH);
    if (month == 1) {
      return true;
    }

    return false;
  }

  /**
   * 获取指定日期前n天 Date---Date
   */
  public static Date getBeforeNDay(Date date, int n) {

    Calendar cl = Calendar.getInstance();
    cl.setTime(date);
    cl.add(Calendar.DAY_OF_YEAR, -n);
    Date dateFrom = cl.getTime();
    return dateFrom;
  }





}
