package com.github.mddarr.kafka.producer.feed;

import com.github.mddarr.kafka.producer.feed.runnable.FeedApiThread;
import com.github.mddarr.kafka.producer.feed.runnable.FeedAvroProducerThread;
import com.typesafe.config.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FeedProducerMain {
    private Logger log = LoggerFactory.getLogger(FeedProducerMain.class.getSimpleName());
    private ExecutorService executor;
    private CountDownLatch latch;
    private FeedApiThread feedThread;
    private FeedAvroProducerThread feedProducerThread;
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
        feedProducerThread = new FeedAvroProducerThread(appConfig,statusQueue,latch);
    }
    public void start() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (!executor.isShutdown()) {
                log.info("Shutdown requested");
                shutdown();
            }
        }));

        log.info("Application started!");
        executor.submit(feedThread);
        executor.submit(feedProducerThread);
        log.info("Stuff submit");
        try {
            log.info("Latch await");
            latch.await();
            log.info("Threads completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            shutdown();
            log.info("Application closed succesfully");
        }

    }

    private void shutdown() {

    }

}
