package hu.ak_akademia.lotterywithparallelprograming;

public class Hand {
	private int lotteryNumber;
	private boolean empty = true;

	public synchronized int take() throws InterruptedException {
		while (empty) {
			wait();
		}
		empty = true;
		notifyAll();
		return lotteryNumber;
	}

	public synchronized void put(int lotteryNumber) throws InterruptedException {
		while (!empty) {
			wait();
		}
		empty = false;
		this.lotteryNumber = lotteryNumber;
		notifyAll();
	}
}
