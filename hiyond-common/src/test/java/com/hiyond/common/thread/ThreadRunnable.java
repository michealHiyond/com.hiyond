package com.hiyond.common.thread;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * @author hiyond
 *
 */
@SuppressWarnings("unused")
public class ThreadRunnable {

	private ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = null;

	private String name;

	private ExecutorService executorService;

	private int nthreads;

	private AtomicLong count = new AtomicLong(10);

	public ThreadRunnable(ConcurrentLinkedQueue<Integer> concurrentLinkedQueue, String name) {
		this.concurrentLinkedQueue = concurrentLinkedQueue;
		this.name = name;
		int size = concurrentLinkedQueue.size();
		nthreads = (size / 2 == 0) ? 1 : (size / 2);
		System.out.println(this.name + "创建线程数：" + nthreads);
		executorService = Executors.newFixedThreadPool(nthreads);
	}

	public ThreadRunnable(int count, String name) {
		this.nthreads = count;
		this.name = name;
		this.count = new AtomicLong(count);
		executorService = Executors.newFixedThreadPool(nthreads);
	}

	public void execute() {
		for (int i = 0; i < nthreads; i++) {
			Runnable task = new Runnable() {
				@Override
				public void run() {
					// while (!concurrentLinkedQueue.isEmpty()) {
					// test(new Random().nextInt(concurrentLinkedQueue.poll()));
					// }
					synchronized (count) {
						if (count.longValue() > 0) {
							count.decrementAndGet();
							System.out.println(Thread.currentThread().getName() + "--" + count);
						}
					}
				}
			};
			executorService.execute(task);
		}
		stop();
	}

	public void stop() {
		executorService.shutdown();
	}

	public void test(int num) {
		int a = new Random().nextInt(10);
		int sum = (a + num);
		System.out.println(name + ": num:" + num + " a:" + a + " a+num:" + sum);
	}

	public static void main(String[] args) {
		ConcurrentLinkedQueue<Integer> queue = ThreadRunnable.getQueue(10, 20);
		// ThreadRunnable threadRunnable = new ThreadRunnable(queue, "A");
		ThreadRunnable threadRunnable = new ThreadRunnable(10, "A");
		threadRunnable.execute();

	}

	/**
	 * 
	 * @param queueSize
	 * @param queueValue
	 * @return
	 */
	public static ConcurrentLinkedQueue<Integer> getQueue(int queueSize, int queueValue) {
		queueSize = queueSize < 0 ? 0 : queueSize;
		queueValue = queueValue < 0 ? 0 : queueValue;
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.add(10);
		}
		return queue;
	}

}
