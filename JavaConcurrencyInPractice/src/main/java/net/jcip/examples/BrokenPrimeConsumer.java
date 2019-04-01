package net.jcip.examples;

import java.math.BigInteger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BrokenPrimeConsumer {

	private int iCount = 0;

	void consumePrimes() throws InterruptedException {
		BlockingQueue<BigInteger> primes = new ArrayBlockingQueue<>(10);
		BrokenPrimeProducer producer = new BrokenPrimeProducer(primes);
		producer.start();
		try {
			while (needMorePrimes()) {
				consume(primes.take());
			}
		} finally {
			producer.cancel();
		}
	}

	void consume(BigInteger bigInteger) {
		iCount++;
		System.out.println(iCount + " " + bigInteger);
	}

	boolean needMorePrimes() {
		return iCount < 100;
	}

	public static void main(String[] args) {
		BrokenPrimeConsumer c = new BrokenPrimeConsumer();
		try {
			c.consumePrimes();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
