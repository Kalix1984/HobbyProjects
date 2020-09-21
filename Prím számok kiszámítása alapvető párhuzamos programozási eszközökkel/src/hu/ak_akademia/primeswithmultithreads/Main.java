package hu.ak_akademia.primeswithmultithreads;

import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
		Set<Integer> primes;
		int largestNumber = 2_000_000;
		
		System.out.println("Prím számok " + largestNumber + "-ig 1 szálon kiszámítva");
		ThreadManager oneThread = new ThreadManager(1, largestNumber);
		oneThread.runAll();
		oneThread.joinAll();
		
		primes = oneThread.getPrimes();
		System.out.println("prímek száma: " + primes.size());
		
		printDurations(oneThread.getDurations());
		
		System.out.println();
		
		System.out.println("Prím számok " + largestNumber + "-ig 2 szálon kiszámítva");
		ThreadManager twoThread = new ThreadManager(2, largestNumber);
		twoThread.runAll();
		twoThread.joinAll();
		
		printDurations(twoThread.getDurations());
	}

	private static void printDurations(List<Long> durations) {
		for (Long duration : durations) {
			System.out.format("%,d%s%n", duration, " nanoszekundum");
		}
	}
}
