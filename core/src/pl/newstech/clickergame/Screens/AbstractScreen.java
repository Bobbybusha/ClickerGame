package pl.newstech.clickergame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import pl.newstech.clickergame.ClickerGame;

/**
 * Created by bartek on 27.05.16.
 */
public abstract class AbstractScreen implements Screen {
    protected ClickerGame game;
    protected Stage stage;
    protected SpriteBatch spriteBatch;
    private OrthographicCamera camera;

    private void createCamera() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, ClickerGame.WIDTH, ClickerGame.HEIGHT);
        camera.update();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    protected abstract void init();

    public AbstractScreen(ClickerGame game) {
        this.game = game;
        createCamera();
        stage = new Stage(new StretchViewport(ClickerGame.WIDTH, ClickerGame.HEIGHT));
        spriteBatch = new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        init();
    }

    @Override
    public void render(float delta) {
        clearScreen();
        camera.update();
        spriteBatch.setProjectionMatrix(camera.combined);
    }

    @Override
    public void resume() {
        game.setPaused(false);
    }

    @Override
    public void pause() {
        game.setPaused(true);
    }

    @Override
    public void show() {//first time
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {//when exit game
        game.dispose();//free memory
    }

    @Override
    public void resize(int width, int height) {
    }
}