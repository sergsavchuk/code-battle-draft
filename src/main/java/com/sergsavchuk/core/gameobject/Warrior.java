package com.sergsavchuk.core.gameobject;

import com.sergsavchuk.core.gamelog.GameLog;
import com.sergsavchuk.core.gamelog.UnitMoveEvent;
import com.sergsavchuk.core.util.Direction;

public class Warrior extends GameObject {

  public static final int movesPerRound = 2;

  private int currentMoves = 0;

  public Warrior(int x, int y, GameLog gameLog) {
    super(x, y, gameLog);
  }

  public void move(Direction dir) {
    if (currentMoves < movesPerRound) {
      gameLog.logGameEvent(new UnitMoveEvent("Warrior", x, y, x + dir.x, y + dir.y));

      x += dir.x;
      y += dir.y;
    } else {
      // maybe throw smth ?
    }

    currentMoves += 1;
  }

  @Override
  public void nextRound() {
    currentMoves = 0;
  }
}
