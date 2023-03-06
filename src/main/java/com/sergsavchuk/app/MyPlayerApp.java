//package com.sergsavchuk.app;
//
//import com.googlecode.jsonrpc4j.JsonRpcClient;
//import com.googlecode.jsonrpc4j.JsonRpcServer;
//import com.googlecode.jsonrpc4j.ProxyUtil;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//import java.net.SocketAddress;
//
//public class MyPlayerApp {
//
//  public static void main(String[] args) throws IOException {
//    String host = "localhost";
//    int port = 5555;
//    Socket socket = new Socket();
//    InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", port);
//    socket.connect(inetSocketAddress);
//
//    JsonRpcClient jsonRpcClient = new JsonRpcClient();
//
//    GameInterface gameInterface = ProxyUtil.createClientProxy(
//        jsonRpcClient.getClass().getClassLoader(), GameInterface.class,
//        jsonRpcClient, socket);
//
//    gameInterface.move("left");
//
//    socket.close();
//  }
//
//  public interface GameInterface {
//
//    public void move(String direction);
//  }
//}
