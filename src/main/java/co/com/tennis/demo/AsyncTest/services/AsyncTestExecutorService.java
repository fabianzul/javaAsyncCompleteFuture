package co.com.tennis.demo.AsyncTest.services;

import co.com.tennis.demo.AsyncTest.AsyncTestObject;
import co.com.tennis.demo.AsyncTest.interfaces.IAsyncTestExecutorService;
import co.com.tennis.demo.AsyncTest.interfaces.IAsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AsyncTestExecutorService implements IAsyncTestExecutorService {
    @Autowired
    private IAsyncTestService asyncTestService;

    @Override
    public String runAsync() throws InterruptedException, ExecutionException {
        int facQuantity = 40000;
        long start = System.currentTimeMillis();
        List<CompletableFuture<AsyncTestObject>> calls = new ArrayList<>();
        for(int i=0;i<facQuantity;i++){
                CompletableFuture<AsyncTestObject> t = asyncTestService.executeAsyncCall(i);
                calls.add(t);
        }
        CompletableFuture.allOf(calls.toArray(new CompletableFuture[0])).join();
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
        return "Tarea terminada en " + (System.currentTimeMillis() - start);
    }
}
