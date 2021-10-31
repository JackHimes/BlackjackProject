package com.skilldistillery.cards;

import java.util.List;

public class BlackjackHand extends Hand {

	public BlackjackHand(List<Card> startingHand) {
		super();
		this.cards = startingHand;
	}

	@Override
	public int getHandValue() {
		int cardValueTotal = 0;
		for (Card card : cards) {
			cardValueTotal += card.getValue();
		}

		return cardValueTotal;
	}

	public boolean isBlackJack() {
		if (getHandValue() == 21 && cards.size() == 2) { // Maybe this.getHandValue() ==.....????
			return true;
		} else {
			return false;

		}
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
