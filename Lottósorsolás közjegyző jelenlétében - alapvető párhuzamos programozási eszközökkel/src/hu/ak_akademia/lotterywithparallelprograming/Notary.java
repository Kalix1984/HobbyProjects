package hu.ak_akademia.lotterywithparallelprograming;

public class Notary implements Runnable{
	private Hand hand;

	public Notary(Hand hand) {
		this.hand = hand;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				System.out.println(hand.take());
				Thread.sleep(3_000);
			} catch (InterruptedException e) {
				System.out.println("The Notary has been interrupted.");
			}
		}
	}
}
