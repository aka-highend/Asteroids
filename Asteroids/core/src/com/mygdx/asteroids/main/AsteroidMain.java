package com.mygdx.asteroids.main;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.asteroids.managers.GameInputProcessor;
import com.mygdx.asteroids.managers.GameKeys;
import com.mygdx.asteroids.managers.GameStateManager;


public class AsteroidMain implements ApplicationListener {

	public static int WIDTH, HEIGHT;

	public static OrthographicCamera cam;

	private GameStateManager gsm;

	@Override
	public void create() {
		WIDTH = Gdx.graphics.getWidth();
		HEIGHT = Gdx.graphics.getHeight();

		cam = new OrthographicCamera(WIDTH, HEIGHT);
		cam.translate(WIDTH / 2, HEIGHT / 2);
		cam.update();

		Gdx.input.setInputProcessor(
				new GameInputProcessor()
		);

		gsm = new GameStateManager();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render() {

		// Clear screen to black
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.draw();

		GameKeys.update();

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}
}
