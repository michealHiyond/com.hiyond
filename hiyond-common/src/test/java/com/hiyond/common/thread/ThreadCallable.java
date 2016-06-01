package com.hiyond.common.thread;

import java.util.Random;
import java.util.concurrent.Callable;

public class ThreadCallable<T> implements Callable<T>{

	@SuppressWarnings("unchecked")
	@Override
	public T call() throws Exception {
		while (!Synchronized.concurrentLinkedQueue.isEmpty()) {
			int num = Synchronized.concurrentLinkedQueue.poll();
			return (T) test(new Random().nextInt(num));
		}
		return null;
	}

	public Integer test(int num) {
		int a = new Random().nextInt(10);
		int sum = (a + num);
		System.out.println(" num:" + num+" a:" + a+" a+num:" + sum);
		return sum;
	}
	
}
