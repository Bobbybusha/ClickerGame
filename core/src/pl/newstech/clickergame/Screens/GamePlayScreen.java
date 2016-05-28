package pl.newstech.clickergame.Screens;

import pl.newstech.clickergame.ClickerGame;
import pl.newstech.clickergame.Entities.Player;

/**
 * Created by bartek on 28.05.16.
 */
public class GamePlayScreen extends AbstractScreen {
    public GamePlayScreen(ClickerGame game) {
        super(game);
        init();
    }

    private Player player;
    private void init() {
        initPlayer();
    }

    private void initPlayer() {
        player = new Player();
        stage.addActor(player);//add player to stage
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update();
        spriteBatch.begin();

        stage.draw();

        spriteBatch.end();
    }

    private void update() {
        stage.act();
    }
}
