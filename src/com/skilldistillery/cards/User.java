package com.skilldistillery.cards;

public class User extends Player {

	public User(BlackjackHand handOfCards) {
		super(handOfCards);
	}
	public void userDisplayHand() {
		System.out.println("Your hand:");
		displayPlayerHand();
	}
	public void userGetValue() {
		System.out.println("Your total is: " + calcHandValue());
	}
	
	

}
