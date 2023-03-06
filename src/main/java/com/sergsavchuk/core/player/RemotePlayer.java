//package com.sergsavchuk.core.player;
//
//import com.sergsavchuk.core.gameobject.GameObject;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.Future;
//
//public class RemotePlayer implements Player {
//
//  private CompletableFuture<Void> playFuture = null;
//
//  @Override
//  public Future<Void> play(List<GameObject> units) {
//    playFuture = new CompletableFuture<>();
//    return playFuture;
//  }
//
//  @Override
//  public void stopPlay() {
//    playFuture.complete(null);
//    playFuture = null;
//  }
//}
