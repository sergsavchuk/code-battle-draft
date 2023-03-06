package com.sergsavchuk.render;

import com.sergsavchuk.core.gameobject.GameObject;
import com.sergsavchuk.core.gameobject.Warrior;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JavaFXRenderer implements Renderer {

  private Scene scene;

  public void start(Stage stage) {
    scene = new Scene(new StackPane(new Label("Loading...")), 640, 640);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void render(List<GameObject> firstPlayerUnits, List<GameObject> secondPlayerUnits) {
    if (scene == null) {
      return;
    }

    List<Node> renderObjects = new ArrayList<>();

    for (GameObject unit : firstPlayerUnits) {
      if (unit instanceof Warrior) {
        renderObjects.add(warriorLabel(Color.BLUE, unit));
      }
    }

    for (GameObject unit : secondPlayerUnits) {
      if (unit instanceof Warrior) {
        renderObjects.add(warriorLabel(Color.RED, unit));
      }
    }

    scene.setRoot(new StackPane(renderObjects.toArray(new Node[0])));
  }

  private static Label warriorLabel(Color blue, GameObject unit) {
    Label label = new Label("Warrior");
    label.setTextFill(blue);
    label.setTranslateX(unit.getX() * 16);
    label.setTranslateY(unit.getY() * 16);
    return label;
  }
}
