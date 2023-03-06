package com.sergsavchuk.core.gamelog;

public class ConsoleGameLog implements GameLog {

  @Override
  public void logGameEvent(GameEvent event) {
    System.out.println(event.toString());
  }
}
