package com.sergsavchuk.render;

import com.sergsavchuk.core.gameobject.GameObject;
import java.util.List;

public interface Renderer {

  void render(List<GameObject> firstPlayerUnits, List<GameObject> secondPlayerUnits);

}
