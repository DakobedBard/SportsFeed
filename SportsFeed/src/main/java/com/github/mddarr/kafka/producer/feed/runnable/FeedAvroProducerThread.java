package com.github.mddarr.kafka.producer.feed.runnable;

import com.github.mddarr.kafka.producer.feed.AppConfig;
import com.github.mddarr.kafka.producer.feed.FeedProducerMain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class FeedAvroProducerThread implements Runnable{
    private final AppConfig appConfig;
    private  final ArrayBlockingQueue<String> statusQueue;
    private final CountDownLatch latch;
    public FeedAvroProducerThread(AppConfig appConfig, ArrayBlockingQueue<String> statusQueue, CountDownLatch latch){
        this.appConfig = appConfig;
        this.statusQueue = statusQueue;
        this.latch = latch;
    }

    @Override
    public void run() {

    }
}
