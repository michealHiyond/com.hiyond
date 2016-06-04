package com.hiyond.common.threadA;

@SuppressWarnings("unused")
public class ThreadA extends Thread {

	private int count = 5;
	private String threadName;

	public ThreadA(String threadName) {
		this.threadName = threadName;
	}

	@Override
	synchronized public void run() {
		if(count > 0){
			count--;
			System.out.println("thread"+Thread.currentThread().getName()+":"+count);
		}
	}

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA("A");
		new Thread(threadA,"A").start();
		new Thread(threadA,"B").start();
		new Thread(threadA,"C").start();
		new Thread(threadA,"D").start();
		new Thread(threadA,"E").start();
	}
	
}
