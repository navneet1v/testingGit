public class ProducerConsumerTest{
   	private int contents;
   	private boolean available = false;
   	public synchronized int get() {
      		while (available == false) {
         		try {
            			wait();
         		}catch (InterruptedException e) {
         		}
      		}
      		available = false;
      		notifyAll();
      		return contents;
	}
   	public synchronized void put(int value) {
      		while (available == true) {
         		try {
            			wait();
         		}catch (InterruptedException e) { 
         		} 
      		}
      		contents = value;
      		available = true;
      		notifyAll();
   	}	
   	public static void main(String[] args) {
      		ProducerConsumerTest pct = new ProducerConsumerTest();
      		Producer p1 = new Producer(pct, 1);
      		Consumer c1 = new Consumer(pct, 1);
      		p1.start(); 
      		c1.start();
   	}
}

class Consumer extends Thread {
   	private ProducerConsumerTest pct;
   	private int number;
   	public Consumer(ProducerConsumerTest c, int number) {
      		pct = c;
      		this.number = number;
   	}
   	public void run() {
      		int value = 0;
         	for (int i = 0; i < 5; i++) {
            		value = pct.get();
            		System.out.println("Consumer " + this.number + " got: " + value);
		}
	}
}

class Producer extends Thread {
	private ProducerConsumerTest pct;
	private int number;

	public Producer(ProducerConsumerTest c, int number) {
		pct = c;
		this.number = number;
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			pct.put(i+1);
			System.out.println("Producer " + this.number + " put: " + (i+1));
			try {
				sleep(1000);
			}catch (InterruptedException e) { }
		}
	}
}
