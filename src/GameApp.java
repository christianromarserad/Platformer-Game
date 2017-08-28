
import Java.Game.GameObject;
import Java.Game.GameStage;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * The main class of the game, which initializes game object positions
 *
 * @author Christian Romar Paul Serad
 */
public class GameApp extends Application {

    public static GameStage stage = new GameStage();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(stage, 1000, 500);
        stage(stage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * initialize the position of game objects within the stage
     *
     * @param stage
     */
    public void stage(GameStage stage) {
        //Put all the initialized game objects here
        Rectangle rec = new Rectangle(50, 50);
        rec.setFill(Color.BLUE);
        Player object = new Player("rectangle", rec);
        object.setX(100);
        object.setY(0);
        object.run();
        
        

//        Box object2 = new Box("rectangle2");
//        object2.setX(0);
//        object2.setY(400);
//        Box object3 = new Box("rectangle2");
//        object3.setX(50);
//        object3.setY(400);
//        Box object4 = new Box("rectangle2");
//        object4.setX(100);
//        object4.setY(400);
//        Box object5 = new Box("rectangle2");
//        object5.setX(150);
//        object5.setY(400);
//        Box object6 = new Box("rectangle2");
//        object6.setX(200);
//        object6.setY(400);
//        Box object7 = new Box("rectangle2");
//        object7.setX(250);
//        object7.setY(400);
//        Box object8 = new Box("rectangle2");
//        object8.setX(300);
//        object8.setY(400);
//        Box object9 = new Box("rectangle2");
//        object9.setX(350);
//        object9.setY(400);
//        Box object10 = new Box("rectangle2");
//        object10.setX(400);
//        object10.setY(400);
//        Box object11 = new Box("rectangle2");
//        object11.setX(450);
//        object11.setY(400);
//        Box object12 = new Box("rectangle2");
//        object12.setX(300);
//        object12.setY(350);
//        Box object13 = new Box("rectangle2");
//        object13.setX(200);
//        object13.setY(350);
//        
//        stage.addObject(object,object2,object3, object4, object5, object6, object7, object8, object9, object10, object11, object12, object13);
        stage.addObject(randomGeneration());
        stage.addObject(object);
    }

    /**
     * Creates a random terrain
     *
     * @return the game objects for terrain
     */
    public GameObject[] randomGeneration() {
        ArrayList<GameObject> objectList = new ArrayList<GameObject>();

        Box boxSample = new Box("land");

        int size = 0;
        int coordinateX = 0;
        while (coordinateX < stage.getScene().getWidth()) {
            coordinateX += (int) boxSample.getWidth();
            size++;
        }

        boolean[] coordinates = new boolean[size];

        int layer = 300;

        for (int x = layer; x < (int) stage.getScene().getHeight(); x = x + (int) boxSample.getHeight()) {
            int position = 0;
            for (int i = 0; i < (int) stage.getScene().getWidth(); i = i + (int) boxSample.getWidth()) {
                if (coordinates[position]) {
                    System.out.println(layer);
                    Box box = new Box("land" + i);
                    box.setX(i);
                    box.setY(x);
                    objectList.add(box);
                } else if ((int) (Math.random() * 2) == 1) {
                    System.out.println(layer);
                    Box box = new Box("land" + i);
                    box.setX(i);
                    box.setY(x);
                    objectList.add(box);
                    coordinates[position] = true;
                }
                position++;
            }
        }
        GameObject[] object = objectList.toArray(new GameObject[objectList.size()]);
        return object;
    }

}
