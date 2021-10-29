package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		this.deck = createDeck();

	}

	public List<Card> createDeck() {
		List<Card> cards = new ArrayList<>(52);
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));

			}

		}

		return cards;
	}

	public void checkDeckSize() {
		int remainingAmount = deck.size();
		System.out.println("There are " + remainingAmount + " cards remaining in the deck");
	}

	public Card dealCard() {
		return deck.remove(0);
	}

	public void shuffleDeck() {
		Collections.shuffle(deck);
	}

}
