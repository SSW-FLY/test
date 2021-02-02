package itcode;

import org.joda.time.DateTime;

/**
 * @author imp
 * @date 2021/1/27
 */
public class Test {

    @org.junit.Test
    public void test1() {
        DateTime now = DateTime.now();
        DateTime dateTime = now.withSecondOfMinute(0);
        DateTime dateTime1 = now.withTimeAtStartOfDay();
        DateTime dateTime2 = now.withHourOfDay(0);
        DateTime dateTime3 = now.withMinuteOfHour(0);
        System.out.println(now);
        System.out.println(dateTime);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime3);
        System.out.println(now.getHourOfDay());
    }
}
