package com.gaurav.practice.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

public class GameBoardTest {
	GameBoard gameBoard;
	GameSettings settings;

	@Before
	public void init() {
		gameBoard = new GameBoard(GameSettings.newInstance().snakeCount(10).ladderCount(10).boxCount(100)
				.addPlayer(Player.newInstance().name("Abhishek")).addPlayer(Player.newInstance().name("Gaurav"))
				.addPlayer(Player.newInstance().name("Varun")));
	}

	@Test
	public void itShouldInitializeTheBoard() {
		gameBoard.init();
		Assert.assertNotNull(gameBoard.getBoxList());
	}

	@Test
	public void itShouldGenerateRandomValues() {
		int randomNumber = gameBoard.generateRandomNumber(2, 99);
		Assert.assertTrue(randomNumber < 100 && randomNumber > 1);
	}

	@Test
	public void itShouldGenerateBoxes() {
		List<Box> boxes = gameBoard.generateBoxes();
		Assert.assertEquals(100, boxes.size());
	}

	@Test
	public void itShouldAssignSnakesToBoxes() {
		List<Box> boxes = gameBoard.assignSnakesToBoxes();
		Assert.assertNotNull(boxes);
		Assert.assertEquals(100, boxes.size());
		Assert.assertEquals(10,
				boxes.stream().filter(box -> box instanceof SnakeBox).collect(Collectors.toList()).size());
	}

	@Test
	public void itShouldAssignLadderToBoxes() {
		List<Box> boxes = gameBoard.assignLadderToBoxes();
		Assert.assertNotNull(boxes);
		Assert.assertEquals(100, boxes.size());
		Assert.assertEquals(10,
				boxes.stream().filter(box -> box instanceof LadderBox).collect(Collectors.toList()).size());
	}

	@Test
	public void itShouldSelectActivePlayer() {
		Player activePlayer = gameBoard.getActivePlayer();
		Assert.assertNotNull(activePlayer);
	}
	
	@Test
	public void activePlayerShouldRollDiceAndUpdateHisMarkerPosition() {
		int markerPosition = gameBoard.getActivePlayer().getMarkerPosition();
		Player activePlayerAfterRollDice = gameBoard.rollDice();
		Assert.assertTrue(markerPosition != activePlayerAfterRollDice.getMarkerPosition());
	}
	
	@Test
	public void playerShouldReThrowDiceIfDicePositionIsSix() {
		int markerPosition = gameBoard.getActivePlayer().getMarkerPosition();
		int markerPosition2 = gameBoard.rollDice().getMarkerPosition();
		
	}

}
