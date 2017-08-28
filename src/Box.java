
import Java.Game.GameObject;
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christian Serad
 */
public class Box extends GameObject{
    
    public Box(String name){
        super(name, new Rectangle(50,50));
    }

    @Override
    public void run() {
        
    }
    
}
