package co.com.tennis.demo.AsyncTest.interfaces;

import co.com.tennis.demo.AsyncTest.AsyncTestObject;
import org.springframework.scheduling.annotation.Async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public interface IAsyncTestService {

    public CompletableFuture<AsyncTestObject> executeAsyncCall(int indexFac) throws InterruptedException;

}
