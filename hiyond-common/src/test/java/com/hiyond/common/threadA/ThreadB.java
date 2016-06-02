package com.hiyond.common.threadA;

public class ThreadB extends Thread {

	private int count = 50;

	@SuppressWarnings("static-access")
	@Override
	synchronized public void run() {
		while(count > 0){
			if(this.interrupted()){
				break;
			}else{
				count--;
				System.out.println("thread"+Thread.currentThread().getName()+":"+count);
			}
		}
	}

	public static void main(String[] args) {
		try {
			ThreadB threadA = new ThreadB();
			Thread thread = new Thread(threadA,"A");
			thread.start();
			thread.sleep(1);
			thread.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
