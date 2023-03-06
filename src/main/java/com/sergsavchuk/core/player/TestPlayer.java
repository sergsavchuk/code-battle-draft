package com.sergsavchuk.core.player;

import com.sergsavchuk.core.gameobject.GameObject;
import com.sergsavchuk.core.gameobject.Warrior;
import com.sergsavchuk.core.util.Direction;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class TestPlayer implements Player {

  private final Random random = new Random();

  @Override
  public Future<Void> play(List<GameObject> units) {
    CompletableFuture<Void> future = new CompletableFuture<>();
    future.completeAsync(() -> {
      for (GameObject unit : units) {
        if (unit instanceof Warrior) {
          for (int i = 0; i < Warrior.movesPerRound; i++) {
            ((Warrior) unit).move(Direction.values()[random.nextInt(Direction.values().length)]);
          }
        }
      }
      return null;
    });
    return future;
  }

  @Override
  public void stopPlay() {
  }
}
