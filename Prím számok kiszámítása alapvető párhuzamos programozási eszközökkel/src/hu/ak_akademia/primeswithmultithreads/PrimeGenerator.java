package hu.ak_akademia.primeswithmultithreads;

import java.util.HashSet;
import java.util.Set;

public class PrimeGenerator {

	private boolean isPrime(int number) {
		if (number < 2)
			return false;
						
		for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}

		return true;
	}

	public Set<Integer> getPrimes(int lowerBound, int upperBound) {
		Set<Integer> primes = new HashSet<>();

		for (int number = lowerBound; number <= upperBound; number++) {
			if (isPrime(number)) {
				primes.add(number);
			}
		}

		return primes;
	}
}
