package com.hiyond.common.threadNotify;

public class ThreadA extends Thread {

	private Object lock;

	public ThreadA(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			try {
				if (MyList.size() != 5) {
					System.out.println("ThreadA start wait");
					lock.wait();
					System.out.println("ThreadA end wait "+MyList.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
