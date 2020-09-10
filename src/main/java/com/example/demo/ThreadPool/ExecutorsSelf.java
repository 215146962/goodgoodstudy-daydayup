package com.example.demo.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//作用：仅仅是重新封装新建线程池的类
public class ExecutorsSelf {
	
	public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolSelf(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
}
