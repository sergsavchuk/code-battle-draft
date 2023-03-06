package com.sergsavchuk.core.gameobject;

import com.sergsavchuk.core.gamelog.GameLog;
import java.util.Objects;

public abstract class GameObject {


  protected int x;
  protected int y;

  protected final GameLog gameLog;

  protected GameObject(int x, int y, GameLog gameLog) {
    this.x = x;
    this.y = y;
    this.gameLog = Objects.requireNonNull(gameLog);
  }

  public abstract void nextRound();

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
