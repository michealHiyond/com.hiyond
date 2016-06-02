package com.hiyond.common.threadA;

@SuppressWarnings("all")
public class ThreadB extends Thread {

	private int count = 50;

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			doRun();
		}
	}

	public void doRun() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				System.out.println("thread" + Thread.currentThread().getName() + ":" + count);
			}
		}
		// while(count > 0){
		// if(this.interrupted()){
		// break;
		// }else{
		// count--;
		// }
		// }
	}

	public static void main(String[] args) {
		try {
			ThreadB threadA = new ThreadB();
			Thread thread = new Thread(threadA, "A");
			thread.start();
			Thread thread1 = new Thread(threadA, "B");
			thread1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
