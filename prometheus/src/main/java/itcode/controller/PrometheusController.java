package itcode.controller;

import itcode.service.TestServiceImpl;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imp
 * @date 2021/1/21
 */
@RestController
public class PrometheusController {

    @Autowired
    private TestServiceImpl testService;

    @GetMapping("/api/test/hello")
    public String hello() throws IOException {

        testService.getConsumer();
        return "ok";
    }


}
