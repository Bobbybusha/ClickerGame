package pl.newstech.clickergame.Screens;

import com.badlogic.gdx.graphics.Texture;

import pl.newstech.clickergame.ClickerGame;

/**
 * Created by bartek on 27.05.16.
 */
public class SplashScreen extends AbstractScreen {

    private Texture splashImg;

    public SplashScreen(ClickerGame game) {
        super(game);
        init();
    }

    private void init() {
        //TODO assets advanced load
        splashImg = new Texture("badlogic.jpg");

    }

    @Override
    public void render(float delta) {
        super.render(delta);

        spriteBatch.begin();

        spriteBatch.draw(splashImg, 0,0);

        spriteBatch.end();
    }
}
