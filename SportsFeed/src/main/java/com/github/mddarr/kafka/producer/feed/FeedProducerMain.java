package com.github.mddarr.kafka.producer.feed;

import com.github.mddarr.kafka.producer.feed.runnable.FeedApiThread;
import com.github.mddarr.kafka.producer.feed.runnable.FeedAvroProducer;
import com.typesafe.config.ConfigFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeedProducerMain {
    private ExecutorService executor;
    private CountDownLatch latch;
    private FeedApiThread feedThread;
    private FeedAvroProducer feedProducer;
    public static void main(String[] args) {
        FeedProducerMain app = new FeedProducerMain(args);
        app.start();
    }
    private FeedProducerMain(String[] arguments) {
        System.out.println("Woohoo");
        AppConfig appConfig = new AppConfig(ConfigFactory.load(), arguments);
        latch = new CountDownLatch(2);
        executor = Executors.newFixedThreadPool(2);
        ArrayBlockingQueue<String> statusQueue = new ArrayBlockingQueue<String>(appConfig.getQueuCapacity());
        feedThread = new FeedApiThread(appConfig, statusQueue, latch);
        feedProducer = new FeedAvroProducer(appConfig,statusQueue,latch);
    }
    public void start() {

    }

    private void shutdown() {

    }

}
