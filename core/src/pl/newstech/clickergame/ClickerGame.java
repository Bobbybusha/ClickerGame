package pl.newstech.clickergame;

import com.badlogic.gdx.Game;

import pl.newstech.clickergame.Screens.SplashScreen;

public class ClickerGame extends Game {

	private boolean paused;
	private int points;

	public final static String GAME_NAME = "GameClicker";
	public final static int WIDTH = 480;
	public final static int HEIGHT = 640;

	public void addPoint() {
		points++;
	}

	@Override
	public void create () {
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
}