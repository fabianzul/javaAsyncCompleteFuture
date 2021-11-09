package co.com.tennis.demo.AsyncTest.controller;

import co.com.tennis.demo.AsyncTest.interfaces.IAsyncTestExecutorService;
import co.com.tennis.demo.AsyncTest.interfaces.IAsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class AsyncTestController {

    @Autowired
    private IAsyncTestExecutorService asyncTestExecutorService;

    @RequestMapping("/")
    public String main() throws ExecutionException, InterruptedException {
        return asyncTestExecutorService.runAsync();
    }
}
