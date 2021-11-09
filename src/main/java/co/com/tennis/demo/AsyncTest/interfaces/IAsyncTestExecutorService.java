package co.com.tennis.demo.AsyncTest.interfaces;

import java.util.concurrent.ExecutionException;

public interface IAsyncTestExecutorService {
    public String runAsync() throws InterruptedException, ExecutionException;
}
