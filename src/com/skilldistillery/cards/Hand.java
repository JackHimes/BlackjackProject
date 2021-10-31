package com.skilldistillery.cards;

import java.util.Iterator;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards;

	public Hand() {
		super();
	}

	public void addCard(Card card) {
		cards.add(card);

	}

	public void clear() {
		for (Card card : cards) {
			card = null;
		}

	}

	abstract public int getHandValue();

	@Override
	public String toString() {
		return "Hand [cards=" + cards + "]";
	}

	public void displayHand() {
		for (Card card : cards) {
			System.out.println(card.toString());

		}
	}

}
