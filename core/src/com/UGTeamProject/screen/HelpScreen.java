package com.UGTeamProject.screen;

import com.UGTeamProject.game.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class HelpScreen extends ScreenAdapter {

	GameManager game;
	OrthographicCamera camera;
	Rectangle mainmenuBounds;
	Vector3 touchPoint;

	public HelpScreen(GameManager game) {
		this.game = game;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 480);
		mainmenuBounds = new Rectangle(325, 375, 175, 50);
		touchPoint = new Vector3();
	}

	public void update() {
		if (Gdx.input.isTouched()) {
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			if (mainmenuBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new MainMenuScreen(game));
				return;
			}
		}
	}

	public void draw() {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		game.batcher.setProjectionMatrix(camera.combined);
		game.batcher.begin();
		game.font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
		game.font.setScale(2.0f, 2.0f);
		game.font.draw(game.batcher, "Main menu", 350, 400);
		game.batcher.end();
	}

	@Override
	public void render(float delta) {
		update();
		draw();
	}

}