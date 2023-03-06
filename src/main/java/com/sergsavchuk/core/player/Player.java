package com.sergsavchuk.core.player;

import com.sergsavchuk.core.gameobject.GameObject;

import java.util.List;
import java.util.concurrent.Future;

public interface Player {

  Future<Void> play(List<GameObject> units);

  void stopPlay();
}
