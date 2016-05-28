package pl.newstech.clickergame.Entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

/**
 * Created by bartek on 28.05.16.
 */
public class Player extends Image {
    public final static int WIDTH = 77;
    public final static int WEIGHT = 152;

    public final static int STARTING_X = 100;
    public final static int STARTING_Y = 100;

    public Player() {
        super(new Texture("badlogic.jpg"));

        this.setOrigin(WIDTH / 2, WEIGHT / 2);//orientation from image half
        this.setSize(WIDTH, WEIGHT);//size

        //starting position
        this.setPosition(STARTING_X, STARTING_Y);//positiob
    }

    public void reactOnClick() {
        //Action testAction = Actions.moveBy(10, 15);//sizeBy, moveBy and other action :D

        int moveAmount = MathUtils.random(-130, 130);

        Action moveAction = Actions.sequence(
                Actions.moveBy(moveAmount, 10, 0.30f, Interpolation.circleOut),
                Actions.moveBy(-moveAmount, -10, 0.30f, Interpolation.circle)
        );

        int growAmount = MathUtils.random(-30, 100);

        Action growAction = Actions.sequence(
                Actions.sizeBy(growAmount, 20, 0.2f, Interpolation.circleOut),
                Actions.sizeBy(-growAmount, -20, 0.2f, Interpolation.circle)
        );

        this.addAction(moveAction);
        this.addAction(growAction);

        if(this.getHeight() > 170) {
            this.addAction(Actions.rotateBy(MathUtils.randomSign() * 360, 0.4f));
        }
    }
}