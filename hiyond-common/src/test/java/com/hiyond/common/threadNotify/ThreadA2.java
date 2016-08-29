package com.hiyond.common.threadNotify;

public class ThreadA2 extends Thread {

	private Object lock;

	public ThreadA2(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			try {
				if (MyList.size() != 5) {
					System.out.println("ThreadA2 start wait");
					lock.wait();
					System.out.println("ThreadA2 end wait "+MyList.size());
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
