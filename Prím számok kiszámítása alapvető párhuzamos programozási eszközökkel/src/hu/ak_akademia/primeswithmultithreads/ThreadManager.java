package hu.ak_akademia.primeswithmultithreads;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreadManager {
	private List<Thread> threads;
	private Set<Integer> primes;

	private List<Long> durations;

	public ThreadManager(int numberOfThreads, int largestNumber) {
		this.threads = new ArrayList<>();
		this.primes = new HashSet<>();
		this.durations = new ArrayList<>();

		createThreads(numberOfThreads, largestNumber);
	}

	public Set<Integer> getPrimes() {
		return primes;
	}

	public List<Long> getDurations() {
		return durations;
	}

	private void createThreads(int numberOfThreads, int largestNumber) {

		int province = largestNumber / numberOfThreads;
		int lowerBound = 0;
		int upperBound = 0;

		for (int i = 0; i < numberOfThreads; i++) {
			lowerBound = i * province;
			upperBound = (i + 1) * province;

			boolean lastThread = i == numberOfThreads - 1;

			if (lastThread) {
				upperBound += largestNumber % numberOfThreads;
			}

			threads.add(new Thread(new Task(lowerBound, upperBound, primes, durations)));
		}
	}

	public void runAll() {
		for (Thread thread : threads) {
			thread.start();
		}
	}

	public void joinAll() {
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				System.out.println("megszakítva");
			}
		}
	}
}
