package com.hiyond.common.threadNotify;

public class Main {

	public static void main(String[] args) {
		Object lock = new Object();
		ThreadA threadA = new ThreadA(lock);
		threadA.start();
		ThreadB threadB = new ThreadB(lock);
		threadB.start();
	}
	
}
