package Java.Game;

import Java.Game.GameObject;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * This class is used to create stage
 * @author Christian Romar Paul Serad
 */
public class GameStage extends Parent {

    private static ArrayList<GameObject> objectList = new ArrayList<GameObject>();

    /**
     * Add game objects into the stage
     *
     * @param object
     */
    public void addObject(GameObject... object) {
        for (int i = 0; i < object.length; i++) {
            objectList.add(object[i]);
            getChildren().add(object[i]);
        }
    }

    /**
     * Gets the object from the stage
     *
     * @param name
     * @return the game object
     */
    public static GameObject getObject(String name) {
        for (int i = 0; i < objectList.size(); i++) {
            if (objectList.get(i).getName().equals(name)) {
                return objectList.get(i);
            }
        }
        return null;
    }

    /**
     * get all the objects from the stage
     *
     * @return the objects from the stage
     */
    public static ArrayList<GameObject> getObjects() {
        return objectList;
    }

}
