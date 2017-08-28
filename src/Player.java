
import Java.Game.GameObject;
import Java.Game.GameStage;
import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;

/**
 * A player object with a platformer game behavior
 *
 * @author Christian Romar Paul Serad
 */
public class Player extends GameObject {
    
    public Player(String name, Node node) {
        super(name, node);
        requestFocus();
        setFocused(true);
        setFocusTraversable(true);
    }

    /**
     * A method that activates the object and has the behavioral code that runs
     * every frame
     */
    @Override
    public void run() {

        AnimationTimer timer = new AnimationTimer() {
            double hspeed = 0; //horizontal speed
            double vspeed = 0; //vertical speed
            boolean ground = false;

            @Override
            public void handle(long now) {

                //left movement
                if (pressed(KeyCode.LEFT)) {
                    if (hspeed > -3) {
                        hspeed = hspeed - 0.1;
                    }
                }

                //right movement
                if (pressed(KeyCode.RIGHT)) {
                    if (hspeed < 3) {
                        hspeed = hspeed + 0.1;
                    }
                }

                //friction effect
                if (!pressed(KeyCode.LEFT) && !pressed(KeyCode.RIGHT)) {
                    if (hspeed > 0) {
                        if (hspeed < 0.2) {
                            hspeed = 0;
                        } else {
                            hspeed = hspeed - 0.1;
                        }
                    }

                    if (hspeed < 0) {
                        if (hspeed > -0.2) {
                            hspeed = 0;
                        } else {
                            hspeed = hspeed + 0.1;
                        }
                    }
                }

                //movemen limt
                if (pressed(KeyCode.LEFT) && getX() < 5) {
                    hspeed = 0;
                }
                if (pressed(KeyCode.RIGHT) && getX() + getWidth() > 995) {
                    hspeed = 0;
                }

                //left object collision
                double left = leftMeet(4);
                if (hspeed < 0 && left != -1) {
                    if (left + 2 < getX()) {
                        hspeed = -0.5;
                    } else {
                        hspeed = 0;
                        setX(left);
                    }
                }

                //right object collision
                double right = rightMeet(4);
                if (hspeed > 0 && right != -1) {
                    if (right - 2 > getX()) {
                        hspeed = 0.5;
                    } else {
                        hspeed = 0;
                        setX(right);
                    }

                }

                //moves the object horizontally
                moveX(hspeed);

                //jump
                if (pressed(KeyCode.UP) && bottomMeet(4) != -1) {
                    if (vspeed > -35) {
                        vspeed = vspeed - 13;
                    }
                }

                //gravity
                if (vspeed < 3 && bottomMeet(4) == -1) {
                    vspeed += 1;
                }

                //top object collision
                if (pressed(KeyCode.UP) && topMeet(4)) {
                    vspeed = 0;
                }

                //bottom object collsion
                double bottom = bottomMeet(4);
                if (!pressed(KeyCode.UP) && bottom != -1) {
                    if (bottom - 2 > getY()) {
                        vspeed = 0.5;
                    } else {
                        vspeed = 0;
                        setY(bottom);
                        ground = true;
                    }
                } else {
                    ground = false;
                }

                //moves the object vertically
                moveY(vspeed);
            }
        };
        timer.start();
    }

}
