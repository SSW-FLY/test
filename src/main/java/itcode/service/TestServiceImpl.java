package itcode.service;

import java.util.concurrent.locks.ReentrantLock;
import org.springframework.stereotype.Service;

/**
 * @author imp
 * @date 2020/9/15
 */
@Service
public class TestServiceImpl {

    private static volatile Long a = 2L;
    private static ReentrantLock lock = new ReentrantLock();

    public void d() {
        Runnable a = this::deal;
        new Thread(a,"a").start();
        new Thread(a,"b").start();
        new Thread(a,"c").start();
    }

    public void deal() {
        try {
            Thread.sleep(1000);
            a++;
            System.out.println("a=:" + Thread.currentThread().getName()+" - " + a);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
