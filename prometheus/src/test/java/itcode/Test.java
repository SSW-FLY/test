package itcode;

import itcode.pojo.Person;
import itcode.pojo.Student;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        long millis = DateTime.now().withSecondOfMinute(0).withMillisOfSecond(0).getMillis();
        System.out.println(System.currentTimeMillis());
        System.out.println(millis);
    }

    @org.junit.Test
    public void test2() {
        File file = new File("message.txt");
        try {
            if (!file.exists()) {
                if (file.createNewFile()) {
                    System.out.println("new message file");
                }
            }
            FileOutputStream out = new FileOutputStream(file, true);
            String s = "test" + System.lineSeparator();
            out.write(s.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
