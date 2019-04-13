package com.gaurav.practice.game;

import lombok.Data;

@Data
public class Player {

	public static Player newInstance() {
		return new Player();
	}

	private String name;
	private int markerPosition;
	private int currDiceResult;

	public Player name(String name) {
		this.name = name;
		return this;
	}

	public Player rollDice(Dice dice) {
		int result = dice.roll();
		markerPosition += result;
		currDiceResult = result;
		return this;
	}
	

}
