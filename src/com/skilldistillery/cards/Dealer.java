package com.skilldistillery.cards;

import java.util.Collections;

public class Dealer extends Player {
	Deck playingDeck = new Deck();

	public Dealer(BlackjackHand hand, Deck playingDeck) {
		super(hand);
	}

	public void dealerDealCard(Player player) {
		Card playingCard = playingDeck.dealCard();
		player.addCardToHand(playingCard);
		
		
	}

	public void dealerShuffleDeck() {
		playingDeck.shuffleDeck();
	}

	public Deck getPlayingDeck() {
		return playingDeck;
	}

	public void setPlayingDeck(Deck playingDeck) {
		this.playingDeck = playingDeck;
	}
	public void dealerDisplayHand() {
		System.out.println("Dealers hand:");
		displayPlayerHand();
	}
	public void dealerGetValue() {
		System.out.println("Dealers shown is: " + calcHandValue());
	}
	

}
