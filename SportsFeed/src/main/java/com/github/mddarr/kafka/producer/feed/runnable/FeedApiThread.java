package com.github.mddarr.kafka.producer.feed.runnable;

import com.github.mddarr.kafka.producer.feed.AppConfig;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class FeedApiThread {
    private final AppConfig appConfig;
    private  final ArrayBlockingQueue<String> statusQueue;
    private final CountDownLatch latch;

    public FeedApiThread(AppConfig appConfig, ArrayBlockingQueue<String> statusQueue, CountDownLatch latch){
        this.appConfig = appConfig;
        this.statusQueue = statusQueue;
        this.latch = latch;
    }
    private void getListener(){

    }

}
