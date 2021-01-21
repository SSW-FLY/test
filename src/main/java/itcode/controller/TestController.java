package itcode.controller;

import itcode.service.TestServiceImpl;
import itcode.service.Tut6Client;
import java.io.IOException;
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
    public String hana() throws IOException {
        testService.getConsumer();
        return "hana";
    }
}
