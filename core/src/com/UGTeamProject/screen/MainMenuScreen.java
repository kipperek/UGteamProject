package com.UGTeamProject.screen;

import com.UGTeamProject.game.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class MainMenuScreen extends ScreenAdapter {

	GameManager game;
	OrthographicCamera camera;

    public MainMenuScreen(GameManager game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
	}

	public void update () {
		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
            return;		
		}
	}

	public void draw () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.update();
		game.batcher.setProjectionMatrix(camera.combined);
		game.batcher.begin();
		game.font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		game.font.setScale( 2.0f,2.0f);
		game.font.draw(game.batcher, "START GAME!", 333, 333);
		game.batcher.end();
	}

	@Override
	public void render (float delta) {
		update();
		draw();
	}
}