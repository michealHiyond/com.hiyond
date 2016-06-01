package com.hiyond.common.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadMain {

	private static final Integer NTHREADS = 5;

	public static void main(String[] args) {
		ThreadRunnable threadRunnable = new ThreadRunnable(Synchronized.concurrentLinkedQueue,"A");
		threadRunnable.execute();
		
	}

	public static void testRunnable() {
		ExecutorService executorSer = Executors.newFixedThreadPool(NTHREADS);
		for (int i = 0; i < 10; i++) {
//			executorSer.execute(new Thread(new ThreadRunnable(), String.valueOf(i + 1)));
			Runnable task = new Runnable() {
				@Override
				public void run() {
					System.out.println("123456");
				}
			};
			executorSer.execute(task);
		}
		executorSer.shutdown();
	}
	
	public static void testCallable() {
		ExecutorService executorSer = Executors.newFixedThreadPool(NTHREADS);
		List<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
		for (int i = 0; i < 10; i++) {
			Future<Integer> future = executorSer.submit(new ThreadCallable<Integer>());
			futureList.add(future);
		}
		executorSer.shutdown();
		try {
			for (Future<Integer> future : futureList) {
				System.out.println(future.get());
			}
		} catch (Exception e) {
		}
	}

}
