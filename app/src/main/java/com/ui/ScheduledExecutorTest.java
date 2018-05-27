package com.ui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.os.Handler;
import android.os.Message;

public class ScheduledExecutorTest {
	// 线程池能按时间计划来执行任务，允许用户设定计划执行任务的时间，int类型的参数是设定
		// 线程池中线程的最小数目。当任务较多时，线程池可能会自动创建更多的工作线程来执行任务
	public ScheduledExecutorService scheduExec = Executors
			.newScheduledThreadPool(1);

	// 启动计时器
	public void lanuchTimer(final Handler handler) {
		Runnable task = new Runnable() {
			public void run() {
//				throw new RuntimeException();
				Message message = new Message();
		        message.what = 1;
		        handler.sendMessage(message);
			}
		};
		scheduExec.scheduleWithFixedDelay(task, 1000 , 1000,
				TimeUnit.MILLISECONDS);
	}
	
	public void stopTimer(){
		scheduExec.shutdown();
	}

	// 娣诲????颁换???
	public void addOneTimerTask() {
		Runnable task = new Runnable() {
			public void run() {
				System.out.println("welcome to china");
			}
		};
		scheduExec.scheduleWithFixedDelay(task, 1000 * 1, 1000,
				TimeUnit.MILLISECONDS);
	}
}