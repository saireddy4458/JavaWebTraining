//package com.ibm.threads;
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		Thread mainthread = Thread.currentThread();
//		System.out.println(mainthread);
//		try {
//			mainthread.sleep(1000);
//		}catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Thread thread1 = new Thread();
//		System.out.println("New thread");
//		System.out.println(thread1);
//		System.out.println(thread1.getState());
//		
//		thread1.start();
//		System.out.println(thread1.getState());
//		
//		try {
//			Thread.sleep(1000);
//		}catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(thread1.getState());
//		System.out.println("End");
//	}
//}

//package com.ibm.threads;
//
//class Runner implements Runnable{
//
//	@Override
//	public void run() {
//		System.out.println("The current thread is "+Thread.currentThread());
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException ex) {
//			ex.printStackTrace();
//			
//		}
//	}	
//}

//public class Application
//{
//	public static void main( String[] args )
//	{
//		Thread mainthread = Thread.currentThread();
//		System.out.println(mainthread);
//		try {
//			mainthread.sleep(1000);
//		}catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Runner runner = new Runner();
//		Thread thread1 = new Thread(runner);
//		System.out.println("New thread");
//		System.out.println(thread1);
//		System.out.println(thread1.getState());
//		
//		thread1.start();
//		System.out.println(thread1.getState());
//		
//		try {
//			Thread.sleep(1000);
//		}catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(thread1.getState());
//		System.out.println("End");
//	}
//}

//package com.ibm.threads;
//
//class Runner implements Runnable{
//
//	@Override
//	public void run() {
//		System.out.println("The current thread is "+Thread.currentThread());
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException ex) {
//			ex.printStackTrace();	
//		}
//	}	
//}
//public class Application
//{
//	public static void main( String[] args )
//	{
//		
//		Runner runner = new Runner();
//		Thread producer = new Thread(runner,"producer");
//		Thread consumer = new Thread(runner,"consumer");
//		
//		
//		System.out.println(producer.getState());
//		System.out.println(consumer.getState());
//		
//		
//		producer.start();
//		consumer.start();
//		
//		try {
//			Thread.sleep(1000);
//		}catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(producer.getState());
//		System.out.println(consumer.getState());
//		System.out.println("End");
//	}
//}

//package com.ibm.threads;
//
//class Runner implements Runnable{
//
//	@Override
//	public void run() {
//		System.out.println("The current thread is "+Thread.currentThread());
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException ex) {
//			ex.printStackTrace();	
//		}
//	}	
//}
//public class Application
//{
//	public static void main( String[] args )
//	{
//		
//		Runner runner = new Runner();
//		Thread producer = new Thread(runner,"producer");
//		Thread consumer = new Thread(runner,"consumer");
//		
//		producer.start();
//		consumer.start();
//		
//		try {
//			producer.join();
//			consumer.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(producer.getState());
//		System.out.println(consumer.getState());
//		System.out.println("End");
//	}
//}

//package com.ibm.threads;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//class Tasks implements Runnable{
//	public int count;
//	
//	Tasks(int count){
//		this.count = count;
//	}
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread()+" -->  "+count);
//		System.out.println(new Date());
//	}
//	
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
////		ExecutorService service = Executors.newFixedThreadPool(4);
////		for(int counter =0; counter < 10; counter++) {
////			service.submit(new Tasks(counter));
////		}
////		service.shutdown();
//		
//		int vCPUs = Runtime.getRuntime().availableProcessors();
//		System.out.println("Threads of my CPU is: "+vCPUs);
//		
//		ScheduledExecutorService service = Executors.newScheduledThreadPool(vCPUs);
//		
//		System.out.println(new Date());
//	
//		service.schedule(new Tasks(1), 10, TimeUnit.SECONDS);
//		
//		System.out.println("The End");
//	}
//}
//package com.ibm.threads;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//class Tasks implements Runnable{
//	public int count;
//	
//	Tasks(int count){
//		this.count = count;
//	}
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread()+" -->  "+count);
//		System.out.println(new Date());
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException exception) {
//			exception.printStackTrace();
//		}
//	}
//	
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
////		ExecutorService service = Executors.newFixedThreadPool(4);
////		for(int counter =0; counter < 10; counter++) {
////			service.submit(new Tasks(counter));
////		}
////		service.shutdown();
//		
//		int vCPUs = Runtime.getRuntime().availableProcessors();
//		System.out.println("Threads of my CPU is: "+vCPUs);
//		
//		ScheduledExecutorService service = Executors.newScheduledThreadPool(vCPUs);
//		
//		System.out.println(new Date());
//	
////		service.schedule(new Tasks(1), 10, TimeUnit.SECONDS);
//		
////		service.scheduleAtFixedRate(new Tasks(2), 10, 5, TimeUnit.SECONDS);
//		
//		service.scheduleWithFixedDelay(new Tasks(3), 10, 5, TimeUnit.SECONDS);
//		service.shutdown();
//		System.out.println("The End");
//	}
//}

//package com.ibm.threads;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
//
//class Tasks implements Runnable{
//	public int count;
//	
//	Tasks(int count){
//		this.count = count;
//	}
//	@Override
//	public void run() {
//		System.out.println(Thread.currentThread()+" -->  "+count);
//		System.out.println(new Date());
//		try {
//			Thread.sleep(2000);
//		}catch(InterruptedException exception) {
//			exception.printStackTrace();
//		}
//	}
//	
//}
//
//public class Application
//{
//	public static void main( String[] args )
//	{
//		int vCPUs = Runtime.getRuntime().availableProcessors();
//		System.out.println("Threads of my CPU is: "+vCPUs);
//		
//		ExecutorService service = Executors.newCachedThreadPool();
//		
//		for(int counter= 0 ; counter < 10 ; counter++) {
//			service.submit(new Tasks(counter));
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
////		System.out.println(new Date());
//
//		service.shutdown();
//		System.out.println("The End");
//	}
//}

package com.ibm.threads;

import java.util.Date;


public class Application
{
	public static void main( String[] args )
	{
		Thread thread1 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println(Thread.currentThread());
			}
			
		});
		thread1.start();
		
		System.out.println("The End");
		
		}

		
	}
