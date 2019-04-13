package com.gaurav.practice.game;

public class Dice {

	public int roll() {
		return GameBoard.generateRandomNumber(1, 7);
	}

}
