package Java.Game;

import javafx.scene.input.KeyCode;

/**
 * This class is used to create key objects
 *
 * @author Christian Romar Paul Serad
 */
public class KeyPressed {

    private final KeyCode code;
    private boolean pressed;

    /**
     * Initialize the keycode of this key
     *
     * @param code
     */
    public KeyPressed(KeyCode code) {
        this.code = code;
    }

    /**
     * gets the keycode of this key
     *
     * @return the keycode
     */
    public KeyCode getCode() {
        return code;
    }

    /**
     * Determine if the key is pressed
     *
     * @return true if pressed, otherwise false
     */
    public boolean isPressed() {
        return pressed;
    }

    /**
     * Set the key to pressed
     *
     * @param pressed
     */
    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

}
