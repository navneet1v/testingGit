/*
	This program goes in the deadlock state. To make this prog not to go in the deadlock state make the lock1 and lock2 sequence in any of the thread as reverse. 
	Cheers
	LiveFree
*/
import java.io.*;
import java.util.*;
public class TestThread{
	public static Object lock1 = new Object();
	public static Object lock2 = new Object();
	public static void main(String args[]){
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		t2.start();
	}
	
	private static class Thread1 extends Thread{
		public void run(){
			System.out.println("Thread 1 has started");
			synchronized(lock1){
				System.out.println("Thread 1 has accuired lock1");
				try{Thread.sleep(10);}
				catch(InterruptedException e){System.out.println("Thread is interrupted ");}
				synchronized(lock2){System.out.println("lock 2 is accuired by thread 2");}
			}
		}
	}
	
	private static class Thread2 extends Thread{
		public void run(){
			System.out.println("Thread 2 has been started");
			synchronized(lock2){				
				System.out.println("Lock 2 is accutred by the thread 2");
				try{Thread.sleep(10);}
				catch(InterruptedException e){System.out.println("Thread is interrupted ");}
				synchronized(lock1){
					System.out.println("lock1 is accuried by thread 2");
				}
			}
		}
	}
}