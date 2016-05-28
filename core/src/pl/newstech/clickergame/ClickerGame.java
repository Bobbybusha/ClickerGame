package pl.newstech.clickergame;

import com.badlogic.gdx.Game;

import pl.newstech.clickergame.Screens.SplashScreen;

public class ClickerGame extends Game {

	public final static String GAME_NAME = "GameClicker";
	public final static int WIDTH = 640;
	public final static int HEIGHT = 640;

	private boolean paused;


	private int points;
	@Override
	public void create () {
		this.setScreen(new SplashScreen(this));
	}

	public void addPoint() {
		points++;
	}

	//get & set
	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public int getPoints() {
		return points;
	}
}