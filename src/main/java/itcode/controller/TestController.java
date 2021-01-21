package itcode.controller;

import itcode.service.TestServiceImpl;
import itcode.service.Tut6Client;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 */
@RestController
public class TestController {

    @Autowired
    private Tut6Client tut6Client;

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/api/test/{n}")
    public String test(@PathVariable int n) {
        Integer send = tut6Client.send(n);
        return String.valueOf(send);
    }

    @GetMapping("/api/test/hana")
    public String hana() {
        testService.d();
        return "hana";
    }
}
