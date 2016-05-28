package pl.newstech.clickergame.Screens;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import pl.newstech.clickergame.ClickerGame;
import pl.newstech.clickergame.Entities.Player;

/**
 * Created by bartek on 28.05.16.
 */
public class GamePlayScreen extends AbstractScreen {
    public GamePlayScreen(ClickerGame game) {
        super(game);
    }

    private Player player;
    private Button playerButton;

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

    @Override
    protected void init() {
        initPlayer();
        initPlayerButton();
    }

    private void initPlayerButton() {
        playerButton = new Button(new Button.ButtonStyle());
        playerButton.setWidth(460);
        playerButton.setHeight(360);
        playerButton.setX(10);
        playerButton.setY(170);
        playerButton.setDebug(true);

        stage.addActor(playerButton);

        playerButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                player.reactOnClick();

                game.addPoint();

                return super.touchDown(event, x, y, pointer, button);
            }
        });

    }
}
