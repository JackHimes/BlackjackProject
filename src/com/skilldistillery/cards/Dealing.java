package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dealing {

	public static void main(String[] args) {
		Dealing d = new Dealing();
		d.deal();

	}

	public void deal() {
		Deck deck = new Deck();
		deck.shuffleDeck();

		Scanner scanner = new Scanner(System.in);
		System.out.print("How many cards would you like dealt?: ");

		try {
			int userInput = scanner.nextInt();
			scanner.nextLine();
			if (userInput > 52) {
				throw new InputMismatchException();
			}
			List<Card> cardsDealt = new ArrayList<>(userInput);
			int sumOfCards = 0;

			for (int i = 0; i < userInput; i++) {
				Card cardToBeDealt = deck.dealCard();
				sumOfCards += cardToBeDealt.getValue();
				cardsDealt.add(cardToBeDealt);
			}
			printHandAndTotal(cardsDealt, sumOfCards);

		} catch (InputMismatchException e) {
			System.out.println("Invalid number of cards");

		} finally {
			scanner.close();
		}

	}

	public void printHandAndTotal(List<Card> HandOfCards, int handValue) {
		for (Card card : HandOfCards) {
			System.out.println(card);
		}
		System.out.println("Value of your hand: " + handValue);
	}

}
