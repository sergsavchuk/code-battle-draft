package com.sergsavchuk.core.util;

public enum Direction {

  left(-1, 0),
  right(1, 0),
  top(0, -1),
  bottom(0, 1);

  public final int x;
  public final int y;

  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
