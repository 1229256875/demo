package com.kx.demo.util;


import io.netty.util.concurrent.DefaultThreadFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

/**
 * @author kaixuan
 * @version 1.0
 * @date 2020/8/4 11:54 上午
 */
public class Main implements Callable<String> {


    public static void main(String[] args) throws IOException, InterruptedException {


//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
////                .uri(URI.create("http://112.17.106.97/"))
//                .uri(URI.create("http://127.0.0.1:8091/api/test"))
//                .setHeader("Cookie", "q=q")
//                .build();


//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenAccept(System.out::println)
//                .join();

//        HttpResponse<String> send = client.send(request, HttpResponse.BodyHandlers.ofString());


        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        Integer[] integers1 = integers.toArray(new Integer[0]);
        System.out.println();



    }

    public class A {
        public void as() {
            System.out.println("123");
        }
    }


    private String content;

    public Main(String content) {
        this.content = content;
    }

    public static void main1(String[] args) throws ExecutionException, InterruptedException {


        /**
         * 队列分为三种， 有界,无界,同步移交队列
         *
         * ArrayBlockingQueue 有界队列 FIFO原则
         *
         * LinkedBlockingQueue 无界队列 (可有界)
         *
         * SynchronousQueue 阻塞队列 同步移交队列
         *
         * PriorityBlockingQueue  有界 按照优先级进行执行
         *
         */

        /**
         * jdk 提供四种拒绝策略
         *
         * AbortPolicy中止策略
         *
         *
         * DiscardPolicy抛弃策略
         *
         * DiscardOldestPolicy抛弃旧任务策略
         *
         * CallerRunsPolicy调用者运行
         */

        ExecutorService executorService2 = Executors.newFixedThreadPool(10);

        ExecutorService executorService = Executors.newCachedThreadPool();

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        BlockingQueue<Runnable> objects = new ArrayBlockingQueue<>(1);

        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(
                        1,
                        2,
                        60,
                        TimeUnit.SECONDS,
                        objects,
                        new DefaultThreadFactory("asd"),
                        new AbortPolicy());


        threadPoolExecutor.submit(new Main("1"));
        threadPoolExecutor.submit(new Main("2"));
        threadPoolExecutor.submit(new Main("3"));
        threadPoolExecutor.submit(new Main("4"));


    }

    /**
     * public static <T> T parseObject(String text, Class<T> clazz) {
     * return parseObject(text, clazz, new Feature[0]);
     * }
     */

    // 泛型方法 printArray
    public static <W> W printArray(String inputArray, Class<W> wClass) {
        // 输出数组元素

        return null;
    }


    @Override
    public String call() throws Exception {
        System.out.println("执行 任务 " + content + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        Thread.sleep(3000);
        System.out.println("执行 结束 " + content + " " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

        return "跳用成功";
    }

    public static class AbortPolicy implements RejectedExecutionHandler {
        public AbortPolicy() {
        }

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                System.out.println("执行拒绝策略");
                r.run();
            }
        }
    }
}
