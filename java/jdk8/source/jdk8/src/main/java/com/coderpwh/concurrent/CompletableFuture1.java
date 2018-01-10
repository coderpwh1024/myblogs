package com.coderpwh.concurrent;

import java.util.concurrent.CompletableFuture;

/**
 * Created by coderpwh on 2018/1/10.
 */
public class CompletableFuture1 {
    public static void main(String[] args) {

        CompletableFuture<String> future = new  CompletableFuture();
            future.complete("42");

            future.thenAccept(System.out::println)
                    .thenAccept(v-> System.out.println("done"));

    }
}
