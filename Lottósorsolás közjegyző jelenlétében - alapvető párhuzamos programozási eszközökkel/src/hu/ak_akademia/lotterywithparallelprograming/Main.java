package hu.ak_akademia.lotterywithparallelprograming;

import java.util.Random;

public class Main {

	public static void main(String[] args) {

		Hand hand = new Hand();
		Random random = new Random();

		Lottotron lottotron = new Lottotron(hand, random);
		Notary notary = new Notary(hand);
		
		Thread producerThread = new Thread(lottotron);
		Thread consumerThread = new Thread(notary);

		producerThread.start();
		consumerThread.start();
	}
}