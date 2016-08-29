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
				System.out.println("MyList.size():" + MyList.size());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				MyList.add(String.valueOf(i + 1));
				if (MyList.size() == 5) {
					lock.notifyAll();
					System.out.println("发出通知");
				}
			}
		}
	}

}
