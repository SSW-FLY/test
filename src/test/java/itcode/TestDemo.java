package itcode;

import itcode.pojo.User;
import itcode.util.HashAlgorithms;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestDemo {

    private final String Y = "yes";

    private final String YES = "yes";


    @Test
    public void test01() throws Exception {
        user01();
        user2();
    }

    public void user01() {
        long start = System.currentTimeMillis();
        User user = new User();
        for (int i = 0; i < 10000; i++) {
            String s = user.toString();
        }
        System.out.println(user.toString());
        System.out.println(System.currentTimeMillis() - start);
    }

    public void user2() throws Exception {
        long start = System.currentTimeMillis();
        Class<?> clazz = Class.forName("itcode.pojo.User");

        Object o = clazz.newInstance();
        Method method = clazz.getMethod("toString");
        for (int i = 0; i < 10000; i++) {
            method.invoke(o);
        }
        Object invoke = method.invoke(o);
        if (invoke instanceof String) {
            System.out.println((String) invoke);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void test011() throws Exception {

        String a = "hello world,hi demo";
        File file = new File("1.txt");
        FileOutputStream out = new FileOutputStream(file);
        FileChannel channel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(a.getBytes());
        buffer.flip();
        channel.write(buffer);
        channel.close();
        out.close();
        String path = file.getAbsolutePath();
    }

    @Test
    public void test11() {
        String file = "2";
        File f = new File(file);
        boolean mkdir = f.mkdir();
        if (mkdir) {
            System.out.println("ok");
        } else {
            System.out.println("false");
        }
    }


    public static long mixHash(String str) {
        long hash = str.hashCode();
//    hash <<= 32;
        hash <<= 22;
        hash |= DEKHash(str);
        return hash;
    }

    public static int DEKHash(String str) {
        int hash = str.length();
        for (int i = 0; i < str.length(); i++) {
            hash = ((hash << 5) ^ (hash >> 27)) ^ str.charAt(i);
        }
        return (hash & 0x7FFFFFFF);
    }

    @Test
    public void test12() throws IOException {
        String GREATER_SPLIET = "<\u0001>";

        String a = "com.youku.fragment.webview.activity.com.cn.layout.";
        String c = "pages/mobileAuthentication/mobileAuthentication";
        String b = "com.youku.fragment.webview.activity.com.cn.layout.";

        String d = "com.youku.fragment.webview.activity.com.cn.layout.test.cn";

        System.out.println(d.length());

        String e = "TrendofHMA";

        StringBuffer unique = new StringBuffer();
        unique.append(d).append(GREATER_SPLIET);
        long l = HashAlgorithms.mixHash(unique.toString().toLowerCase());
        System.out.println(l == -7685296371877659L);

    }

    @Test
    public void test13() {
        File file = new File("J:\\aa");
        delete(file);
    }

    public void delete(File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            boolean delete = file.delete();
            if (delete) {
                log.info("文件删除成功：{}", file.getAbsolutePath());
            } else {
                log.info("文件删除失败：{}", file.getAbsolutePath());
            }
        }
        File[] files = file.listFiles();
        if (files == null || files.length == 0) {
            return;
        }
        for (File child : files) {
            delete(child);
        }
        boolean delete = file.delete();
        if (delete){
            log.info("文件删除成功：{}",file.getName());
        }
    }

    public void delete(String path) {
        File file = new File(path);
        delete(file);
    }


    public int t111(){

        try{
            int i = 1/0;
        }catch (Exception e){
//            e.printStackTrace();
        }
        System.out.println("wo zai1zuihou");
        return 0;
    }
    @Test
    public void t1111(){
        int i = t111();
        System.out.println(i);
    }

}
