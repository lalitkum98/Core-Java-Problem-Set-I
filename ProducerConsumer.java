package RePracticeJava;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object sharedObject = new Object();
		List<Integer> queue = new ArrayList<Integer>();
		Producer producer = new Producer(sharedObject, queue);
		Consumer consumer = new Consumer(sharedObject, queue);
		Thread cons = new Thread(consumer);
		Thread prod = new Thread(producer);
		cons.start();
		prod.start();

	}

}
