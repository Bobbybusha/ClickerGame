package pl.newstech.clickergame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import pl.newstech.clickergame.Screens.SplashScreen;

public class ClickerGame extends Game {

	private boolean paused;
	private int points;
	private Preferences preferences;

	public final static String GAME_PREFERENCES = "pl.newstech.clickergame.preferences;";
	public final static String GAME_SCORE = "pl.newstech.clickergame.preferences.score;";
	public final static String GAME_NAME = "GameClicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 640;

	public void addPoint() {
		points++;
		updateSavePoints();
	}

	@Override
	public void create () {
		init();
		this.setScreen(new SplashScreen(this));
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	//get & set
	public int getPoints() {
		return points;
	}

	public void resetPoints() {
		points = 0;
		updateSavePoints();
	}

	private void updateSavePoints() {
		preferences.putInteger(GAME_SCORE, points);
		preferences.flush();//store to memory
	}

	private void init() {
		preferences = Gdx.app.getPreferences(GAME_PREFERENCES);
		loadPoints();
	}

	private void loadPoints() {
		points = preferences.getInteger(GAME_SCORE);
	}
}