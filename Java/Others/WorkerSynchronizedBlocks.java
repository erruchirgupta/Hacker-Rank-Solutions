package com.project.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkerSynchronizedBlocks {

	private Random random = new Random();

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public void stageOne() throws InterruptedException {
		synchronized (lock1) {
			Thread.sleep(1);
			list1.add(random.nextInt(100));
		}
	}

	public void stageTwo() throws InterruptedException {
		synchronized (lock2) {
			Thread.sleep(1);
			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			try {
				stageOne();
				stageTwo();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String ... args) throws Exception {
		WorkerSynchronizedBlocks worker = new WorkerSynchronizedBlocks();
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				worker.process();
			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {
				worker.process();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + worker.list1.size() + "; List2: " + worker.list2.size());
	}
}
