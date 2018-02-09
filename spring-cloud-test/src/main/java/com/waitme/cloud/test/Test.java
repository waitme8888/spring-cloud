package com.waitme.cloud.test;

import java.util.concurrent.*;

/**
 * Created by weiwang207 on 2016/12/30.
 */
public class Test {



    public static void main(String[] args) throws Exception {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("wwww");
            }
        }, 1000, TimeUnit.MILLISECONDS);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("ssss");
            }
        }, 100000, TimeUnit.MILLISECONDS);
    }


}

