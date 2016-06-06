package com.hiyond.common.threadNotify;

public class ThreadB extends Thread {

	private Object lock;

	public ThreadB(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		super.run();
		synchronized (lock) {
			for (int i = 0; i < 10; i++) {
				MyList.add(String.valueOf(i + 1));
				if (MyList.size() == 5) {
					lock.notify();
					System.out.println("发出通知");
				}
			}
		}
	}

}
