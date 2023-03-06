package com.sergsavchuk.core.gamelog;

public class UnitMoveEvent extends GameEvent {

  private final String unitName;
  private final int fromX;
  private final int fromY;
  private final int toX;
  private final int toY;

  public UnitMoveEvent(String unitName, int fromX, int fromY, int toX, int toY) {
    this.unitName = unitName;
    this.fromX = fromX;
    this.fromY = fromY;
    this.toX = toX;
    this.toY = toY;
  }

  @Override
  public String toString() {
    return String.format("Unit %s moved from %d:%d to %d:%d", unitName, fromX, fromY, toX, toY);
  }
}
