package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackjackApp {
	private Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Deck deck = new Deck();
		List<Card> startingHand = new ArrayList<Card>();
		List<Card> startingHandUser = new ArrayList<Card>();
		BlackjackHand dealerHand = new BlackjackHand(startingHand);
		BlackjackHand userHand = new BlackjackHand(startingHandUser);

		User user = new User(userHand);
		Dealer dealer = new Dealer(dealerHand, deck);

		BlackjackApp bja = new BlackjackApp();
		bja.run(dealer, user);

	}

	public void run(Dealer dealer, User user) {
		initializeBlackjack(dealer, user);
		playBlackjack(dealer, user);
		System.out.println("\nThank you playing!");

	}

	public void initializeBlackjack(Dealer dealer, User user) {
		System.out.println("Dealer is shuffling the cards...with style");
		dealer.dealerShuffleDeck();
		System.out.println("Hands are being dealt...\n");

		System.out.println("First round of cards:");
		dealer.dealerDealCard(user);
		user.userDisplayHand();
		System.out.println("");

		dealer.dealerDealCard(dealer);
		dealer.dealerDisplayHand();
		System.out.println("");

		System.out.println("Second round of cards:");
		dealer.dealerDealCard(user);
		user.userDisplayHand();
		user.userGetValue();
		System.out.println("");

		dealer.dealerDisplayHand();
		System.out.println("Card faced down");
		dealer.dealerGetValue();
		dealer.dealerDealCard(dealer);

	}

	public void playBlackjack(Dealer dealer, User user) {
		boolean keepGameGoing = true;
		boolean playerTurn = true;
		boolean dealerTurn = true;
		boolean endGameSummary = true;
		while (keepGameGoing) {
			if (user.calcHandValue() == 21) {
				System.out.println("You got a Blackjack! Extra payout for you!");
				keepGameGoing = false;
				continue;
			}
			if (user.calcHandValue() > 21) {
				keepGameGoing = false;
				break;

			}

			while (playerTurn) {
				System.out.println("Would you like to do:\n1. Hit\n2. Stay?");
				int userInput = scanner.nextInt();
				scanner.nextLine();
				switch (userInput) {
				case 1:
					dealer.dealerDealCard(user);
					user.userDisplayHand();
					user.userGetValue();
					if (user.calcHandValue() > 21) {
						System.out.println("Your hand has gone bust! Dealer wins.");
						keepGameGoing = false;
						playerTurn = false;
						dealerTurn = false;
						endGameSummary = false;
						break;
					}
					if (user.calcHandValue() == 21) {
						System.out.println("You've got a Blackjack!");
						playerTurn = false;
						break;

					}
					continue;

				case 2:
					user.userDisplayHand();
					user.userGetValue();
					playerTurn = false;
					break;
				default:
					System.out.println("Please enter a valid input");
				}
				break;
			}
			while (dealerTurn) {
				System.out.println("\nDealers Turn!");
				dealer.dealerDisplayHand();
				dealer.dealerGetValue();
				if (dealer.calcHandValue() > 21) {
					System.out.println("Dealers hand has gone bust! You win!");
					dealerTurn = false;
					keepGameGoing = false;
					endGameSummary = false;
					break;
				}
				if (dealer.calcHandValue() == 21) {
					System.out.println("Dealer has a Blackjack!");
					if (user.calcHandValue() == 21) {
						System.out.println("You and the dealer tied. Your bet has been returned.");
						dealerTurn = false;
						break;
					} else {
						System.out.println("The dealer takes the pot!");
						dealerTurn = false;
						break;
					}
				}
				if (dealer.calcHandValue() < 17) {
					System.out.println("");
					System.out.println("Dealer hits");
					dealer.dealerDealCard(dealer);
					dealer.dealerDisplayHand();
					dealer.dealerGetValue();
					continue;
				}
				if (dealer.calcHandValue() > 16 && dealer.calcHandValue() < 21) {
					System.out.println("Dealer stays with " + dealer.calcHandValue());
					dealerTurn = false;
					break;
				}

			}
			if (endGameSummary) {
				if (user.calcHandValue() > dealer.calcHandValue()) {
					System.out.println("Your " + user.calcHandValue() + " beats the dealers " + dealer.calcHandValue()
							+ "\nYou take the winnings!");
					keepGameGoing = false;

				} else if (user.calcHandValue() == dealer.calcHandValue()) {
					System.out.println("There is a tie! Your bet has been returned");
				}
				else {
					System.out.println("The dealers " + dealer.calcHandValue() + " beats your " + user.calcHandValue()
							+ "\nHouse takes the winnings");
					keepGameGoing = false;
				}

			}
		}
	}
}