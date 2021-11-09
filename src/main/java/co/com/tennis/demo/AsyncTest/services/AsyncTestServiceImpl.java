package co.com.tennis.demo.AsyncTest.services;

import co.com.tennis.demo.AsyncTest.AsyncTestObject;
import co.com.tennis.demo.AsyncTest.interfaces.IAsyncTestService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;


@Service
public class AsyncTestServiceImpl implements IAsyncTestService {

    private final RestTemplate restTemplate;

    public AsyncTestServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    @Async
    public CompletableFuture<AsyncTestObject> executeAsyncCall(int indexFac) {
        String url = String.format("http://localhost:3000");
        AsyncTestObject results = restTemplate.getForObject(url, AsyncTestObject.class);
        // Artificial delay of 1s for demonstration purposes
        System.out.println("call fact: "+indexFac+ " with result: " + results.toString());
        //Thread.sleep(1000);
        return CompletableFuture.completedFuture(results);
    }


}
