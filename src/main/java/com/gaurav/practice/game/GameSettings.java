package com.gaurav.practice.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.Data;

@Data
public class GameSettings {

	public static GameSettings newInstance() {
		return new GameSettings();
	}

	private int snakeCount;
	private int ladderCount;
	private int boxCount;
	private List<Player> players;

	public GameSettings snakeCount(int snakeCount) {
		this.snakeCount = snakeCount;
		return this;
	}

	public GameSettings ladderCount(int ladderCount) {
		this.ladderCount = ladderCount;
		return this;
	}

	public GameSettings boxCount(int boxCount) {
		this.boxCount = boxCount;
		return this;
	}

	public GameSettings addPlayer(Player player) {
		if (Objects.isNull(players))
			players = new ArrayList<>();
		players.add(player);
		return this;
	}

}
