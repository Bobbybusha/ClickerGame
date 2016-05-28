package pl.newstech.clickergame.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by bartek on 28.05.16.
 */
public class Player extends Image {
    public final static int WIDTH = 77;
    public final static int WEIGHT = 152;

    public final static int STARTING_X = 200;
    public final static int STARTING_Y = 320;

    public Player() {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(WIDTH / 2, WEIGHT / 2);//orientation from image half
        this.setSize(WIDTH, WEIGHT);//size

        //starting position
        this.setPosition(STARTING_X, STARTING_Y);//positiob
    }
}