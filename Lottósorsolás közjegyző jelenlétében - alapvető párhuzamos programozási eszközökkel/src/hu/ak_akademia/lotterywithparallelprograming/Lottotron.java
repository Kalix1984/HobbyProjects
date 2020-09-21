package hu.ak_akademia.lotterywithparallelprograming;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lottotron implements Runnable {
	private Hand hand;
	private Random random;

	public Lottotron(Hand hand, Random random) {
		this.hand = hand;
		this.random = random;
	}

	@Override
	public void run() {
		try {
			Set<Integer> lotteryNumbers = new HashSet<>();

			while (lotteryNumbers.size() < 5) {
				int lotteryNumber = random.nextInt(90) + 1;
				boolean isAdded = lotteryNumbers.add(lotteryNumber);
				
				if(isAdded){
					hand.put(lotteryNumber);
					Thread.sleep(3_000);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("The Lottotron has been interrupted.");
		}
	}
}
