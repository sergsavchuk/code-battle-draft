package com.sergsavchuk.core.gamelog;

public class NextRoundEvent extends GameEvent {

  private final int roundNumber;

  public NextRoundEvent(int roundNumber) {
    this.roundNumber = roundNumber;
  }

  @Override
  public String toString() {
    return String.format("ROUND %d", roundNumber);
  }
}
