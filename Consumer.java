package RePracticeJava;

import java.util.ArrayList;
import java.util.List;

public class Consumer implements Runnable {
	Object sharedObject;
	List<Integer> queue;

	Consumer(Object sharedObject, List<Integer> queue) {
		this.sharedObject = sharedObject;
		this.queue = queue;
	}

	public void run() {
		while (true) {
			synchronized (sharedObject) {
				try {
					while (queue.size() == 0) {
						sharedObject.wait();
					}
					Thread.sleep(5000);
					int consume = queue.remove(0);
					System.out.println("consumed : " + consume);
					sharedObject.notifyAll();

				} catch (Exception e) {
					System.out.println(e.toString());
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
