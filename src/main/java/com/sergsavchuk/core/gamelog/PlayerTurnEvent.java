package com.sergsavchuk.core.gamelog;

public class PlayerTurnEvent extends GameEvent {

  private final String playerName;

  public PlayerTurnEvent(String playerName) {
    this.playerName = playerName;
  }

  @Override
  public String toString() {
    return String.format("%s turn", playerName);
  }
}
