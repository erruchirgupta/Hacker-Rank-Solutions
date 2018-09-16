package com.project.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

enum StageType {

	STAGE_ONE(1L),
	STAGE_TWO(2L);
	
	private Long stageTypeId;
	
	private StageType(Long stageTypeId) {
		this.stageTypeId = stageTypeId;
	}
	
	public Long getStageTypeId() {
		return stageTypeId;
	}

	public static StageType from(Long stageTypeId) {
		for(StageType type : values()) {
			if(type.stageTypeId == stageTypeId) {
				return type;
			}
		}
		return null;
	}
}

public class WorkerSynchronizedThreadPool implements Runnable {

	private Random random = new Random();

	private final Object lock1 = new Object();
	private final Object lock2 = new Object();

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	@Override
	public void run() {
		GenericProcess();
	}
	
	public void GenericStage(StageType stageTypeId) {
		
		try {
			switch (stageTypeId) {
			case STAGE_ONE:
				synchronized (lock1) {
					Thread.sleep(1);
					list1.add(random.nextInt(100));
				}
				break;

			case STAGE_TWO:
				synchronized (lock2) {
					Thread.sleep(1);
					list2.add(random.nextInt(100));
				}
				break;
			}
		} catch(Exception ex) {
			throw new RuntimeException(ex);	
		}		
	}

	public void GenericProcess() {
		for (int i = 0; i < 1000; i++) {
			GenericStage(StageType.STAGE_ONE);
			GenericStage(StageType.STAGE_TWO);
		}
	}

	public static void main(String ... args) throws Exception {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		System.out.println("Starting ...");
		long start = System.currentTimeMillis();
		
		WorkerSynchronizedThreadPool worker = new WorkerSynchronizedThreadPool();
		
		for(int i=0; i<2; i++)
			executor.submit(worker);
		
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();

		System.out.println("Time taken: " + (end - start));
		System.out.println("List1: " + worker.list1.size() + "; List2: " + worker.list2.size());
	}

	
}
