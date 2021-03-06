package com.skilldistillery.cards;

import java.util.Objects;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Rank cardsRank, Suit cardsSuit) {
		this.rank = cardsRank;
		this.suit = cardsSuit;

	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && Objects.equals(suit, other.suit);
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	public int getValue() {
		return rank.getValue();
	}

}
