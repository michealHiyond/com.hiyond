package com.hiyond.common.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Synchronized {

	public static ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<Integer>();

	static {
		for (int i = 0; i < 10; i++) {
			concurrentLinkedQueue.offer(10);
		}
	}

	public static void main(String[] args) {
		System.out.println(concurrentLinkedQueue.toString());
		while(!concurrentLinkedQueue.isEmpty()){
			System.out.println(concurrentLinkedQueue.poll());
		}
	}
	
}
