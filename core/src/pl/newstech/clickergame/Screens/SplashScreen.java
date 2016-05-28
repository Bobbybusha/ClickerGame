package pl.newstech.clickergame.Screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;

import pl.newstech.clickergame.ClickerGame;

/**
 * Created by bartek on 27.05.16.
 */
public class SplashScreen extends AbstractScreen {
    private Texture splashImg;

    protected void init() {
        //TODO assets advanced load
        splashImg = new Texture("badlogic.jpg");
    }

    public SplashScreen(final ClickerGame game) {
        super(game);

        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                //System.out.println("test");//debug
                game.setScreen(new GamePlayScreen(game));
            }
        }, 1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();
        spriteBatch.draw(splashImg, 0,0);
        spriteBatch.end();
    }
}