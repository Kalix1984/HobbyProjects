package hu.ak_akademia.primeswithmultithreads;

import java.util.List;
import java.util.Set;

public class Task implements Runnable {
	private int lowerBound;
	private int upperBound;
	private Set<Integer> primes;
	private List<Long> durations;

	public Task(int lowerBound, int upperBound, Set<Integer> primes, List<Long> durations) {
		this.durations = durations;
		this.primes = primes;
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void run() {
		Timer timer = new Timer();
		
		timer.start();
		primes.addAll(new PrimeGenerator().getPrimes(lowerBound, upperBound));
		timer.stop();
		durations.add(timer.getElapsedNanoTime());
	}
}
