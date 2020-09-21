package hu.ak_akademia.primeswithmultithreads;

public class Timer {
	private long start;
	private long stop;
	
	public void start() {
		start = System.nanoTime();
	}
	
	public void stop() {
		stop = System.nanoTime();
	}
	
	public long getElapsedNanoTime() {
		return stop - start; 
	}
}
