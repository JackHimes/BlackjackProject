package com.skilldistillery.cards;

import java.util.List;

public class Player {
	private BlackjackHand hand;

	public Player(Hand handOfCards) {
		super();
		this.hand = (BlackjackHand) handOfCards;
	}
	public int calcHandValue () {
		int valueOfHand = 0;
		for (Card card : hand.cards) {
			valueOfHand += card.getValue();
		}
		
		return valueOfHand;
	}
	public void displayPlayerHand () {
		hand.displayHand();
		hand.getHandValue();
		
	}
	public void addCardToHand(Card cardToAdd) {
		hand.addCard(cardToAdd);
		hand.getHandValue();
	}
	
	

}
