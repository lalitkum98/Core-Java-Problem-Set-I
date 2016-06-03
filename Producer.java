package RePracticeJava;

import java.util.ArrayList;
import java.util.List;

public class Producer implements Runnable {
	int count;
	Object sharedObject;
	List<Integer> queue;

	Producer(Object sharedObject, List<Integer> queue) {
		this.sharedObject = sharedObject;
		this.queue = queue;
	}

	public void run() {
		while (queue.size() < 10) {
			count = 0;
			while (count < 10) {
				synchronized (sharedObject) {
					try {
						while (queue.size() == 10) {
							sharedObject.wait();
						}
						Thread.sleep(2000);
						count++;
						queue.add(count);
						System.out.println("produced :" + count);
						sharedObject.notifyAll();
					} catch (Exception e) {
						System.out.println(e.toString());
					}
				}
			}
		}
	}

}
