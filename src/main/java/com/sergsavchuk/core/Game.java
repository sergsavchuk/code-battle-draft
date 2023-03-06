package com.sergsavchuk.core;

import com.sergsavchuk.core.gamelog.GameLog;
import com.sergsavchuk.core.gamelog.NextRoundEvent;
import com.sergsavchuk.core.gamelog.PlayerTurnEvent;
import com.sergsavchuk.core.gameobject.GameObject;
import com.sergsavchuk.core.gameobject.Warrior;
import com.sergsavchuk.core.player.Player;

import com.sergsavchuk.core.util.Updatable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Game implements Updatable {

  private static final long playerTurnTimeout = 30;

  private final GameLog gameLog;
  private final Player firstPlayer;
  private final Player secondPlayer;

  private final List<GameObject> firstPlayerUnits = new ArrayList<>();
  private final List<GameObject> secondPlayerUnits = new ArrayList<>();

  private int roundCounter = 0;

  public Game(GameLog gameLog, Player firstPlayer, Player secondPlayer) {
    this.gameLog = Objects.requireNonNull(gameLog);
    this.firstPlayer = Objects.requireNonNull(firstPlayer);
    this.secondPlayer = Objects.requireNonNull(secondPlayer);

    firstPlayerUnits.add(new Warrior(-5, 0, gameLog));
    secondPlayerUnits.add(new Warrior(5, 0, gameLog));
  }

  @Override
  public void update(float dt) {
    gameLog.logGameEvent(new NextRoundEvent(roundCounter++));

    firstPlayerUnits.forEach(GameObject::nextRound);
    secondPlayerUnits.forEach(GameObject::nextRound);

    gameLog.logGameEvent(new PlayerTurnEvent("Player1"));
    playerTurn(firstPlayer, firstPlayerUnits);

    gameLog.logGameEvent(new PlayerTurnEvent("Player2"));
    playerTurn(secondPlayer, secondPlayerUnits);
  }

  private void playerTurn(Player player, List<GameObject> units) {
    try {
      player.play(units).get(playerTurnTimeout, TimeUnit.MILLISECONDS);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    } catch (TimeoutException e) {
      // player turn time is out
      player.stopPlay();
    }
  }

  public List<GameObject> getFirstPlayerUnits() {
    return Collections.unmodifiableList(firstPlayerUnits);
  }

  public List<GameObject> getSecondPlayerUnits() {
    return Collections.unmodifiableList(secondPlayerUnits);
  }
}
