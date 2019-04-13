package com.gaurav.practice.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Getter;

public class GameBoard {

	private List<SnakeBox> snakesList;
	private GameSettings gameSettings;
	@Getter
	private List<Box> boxList;
	private int activePlayerPointer = 0;
	private Dice dice = new Dice();
	
	public GameBoard(GameSettings settings) {
		this.gameSettings = settings;
		init();
	}
	
	public void init() {
		generateBoxes();
	}
	
	public List<SnakeBox> getAllSnakes() {
		
		return snakesList;
	}

	public static int generateRandomNumber(int lowerLimit, int upperLimit) {
		Random r = new Random();
		return r.ints(lowerLimit, (upperLimit + 1)).findFirst().getAsInt();
	}

	public List<Box> generateBoxes() {
		boxList = new ArrayList<Box>();
		for (int i = 0; i < gameSettings.getBoxCount(); i++) {
			boxList.add(new NormalBox());
		}
		return boxList;
	}

	public List<Box> assignSnakesToBoxes() {
		for (int i=0; i < gameSettings.getSnakeCount(); i++) {
			int randNumber = generateRandomNumber(2, 98);
			if (boxList.get(randNumber) instanceof SnakeBox) {
				i--;
			} else {
				boxList.set(randNumber, new SnakeBox());
			}
		}
		return boxList;
	}

	public List<Box> assignLadderToBoxes() {
		for (int i=0; i < gameSettings.getLadderCount(); i++) {
			int randNumber = generateRandomNumber(2, 98);
			if (boxList.get(randNumber) instanceof LadderBox) {
				i--;
			} else {
				boxList.set(randNumber, new LadderBox());
			}
		}
		return boxList;
	}

	public Player getActivePlayer() {
		
		return gameSettings.getPlayers().get(activePlayerPointer);
	}

	public Player rollDice() {
		Player activePlayer = getActivePlayer().rollDice(dice);
		return activePlayer;
	}



}
