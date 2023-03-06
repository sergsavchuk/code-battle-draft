package com.sergsavchuk.app;

import com.sergsavchuk.core.Game;
import com.sergsavchuk.core.gamelog.ConsoleGameLog;
import com.sergsavchuk.core.player.TestPlayer;
import com.sergsavchuk.render.JavaFXRenderer;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.stage.Stage;

public class TestApp extends Application {

  private static final Timer timer = new Timer();
  private static long prevTime;

  private static final JavaFXRenderer renderer = new JavaFXRenderer();


  public static void main(String[] args) throws IOException {
//    connectRemotePlayers();

    Game game = new Game(new ConsoleGameLog(), new TestPlayer(), new TestPlayer());

    prevTime = System.currentTimeMillis();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        long currTime = System.currentTimeMillis();
        game.update(currTime - prevTime);
        prevTime = currTime;

        renderer.render(game.getFirstPlayerUnits(), game.getSecondPlayerUnits());
      }
    }, 0, 3000);

    launch();
  }

  @Override
  public void start(Stage stage) {
    renderer.start(stage);
  }

  @Override
  public void stop() throws Exception {
    super.stop();

    timer.cancel();
  }

//  public static class MyService {
//
//    public void move(String dir) {
//      System.out.println("MOVE");
//    }
//  }

  static void connectRemotePlayers() {
    //    JsonRpcServer firstPlayerServer = new JsonRpcServer(new JsonRpcPlayer("player1"),
//        RemotePlayerInterface.class);
//    JsonRpcServer secondPlayerServer = new JsonRpcServer(new JsonRpcPlayer("player2"),
//        RemotePlayerInterface.class);
//    JsonRpcServer jsonRpcServer = new JsonRpcServer(new MyService(), MyService.class) {
//      @Override
//      public int handleRequest(InputStream input, OutputStream output) throws IOException {
//        return super.handleRequest(input, output);
//      }
//
//      @Override
//      protected JsonResponse handleJsonNodeRequest(JsonNode node)
//          throws JsonParseException, JsonMappingException {
//        System.out.println("HANDLE");
//        System.out.println(node.toString());
//
//        String playerId = node.get("playerId").asText();
//        if (Objects.equals(playerId, "player1")) {
//          firstPlayerServer.handleJsonNodeRequest(node);
//        }
//
//        return super.handleJsonNodeRequest(node);
//      }
//    };
////    jsonRpcServer.setRequestInterceptor(request -> {
////
////    });
////    jsonRpcServer.setInterceptorList();
////    jsonRpcServer.setInvocationListener();
//
//    // create the stream server
//    int maxThreads = 2;
//    int port = 5555;
//    int backlog = 0;
//    InetAddress bindAddress = InetAddress.getByName("localhost");
//    ServerSocket serverSocket = new ServerSocket(port, backlog, bindAddress);
//    StreamServer streamServer = new StreamServer(jsonRpcServer, maxThreads, serverSocket);
//
//// start it, this method doesn't block
//    streamServer.start();
  }
}