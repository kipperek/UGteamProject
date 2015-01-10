package com.UGTeamProject.screen;

import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.game.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

public class MainMenuScreen extends ScreenAdapter {

	GameManager game;
	OrthographicCamera camera;
	Rectangle playBounds;
	Rectangle helpBounds;
	Vector3 touchPoint;

         public MainMenuScreen(GameManager game) {
                this.game = game;
                camera = new OrthographicCamera(320, 480);
	        camera.position.set(320 / 2, 480 / 2, 0);
	        playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
		helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
		touchPoint = new Vector3();
	}

	public void update () {
		if (Gdx.input.isTouched()) {
			camera.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
			
			if (playBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new GameScreen(game));
				return;
			}
			if (helpBounds.contains(touchPoint.x, touchPoint.y)) {
				game.setScreen(new HelpScreen(game));
				return;
			}
		}
	}
	
	public void draw () {
		GL20 gl = Gdx.gl;
		gl.glClearColor(1, 0, 0, 1);
		gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		game.batcher.setProjectionMatrix(camera.combined);

		game.batcher.disableBlending();
		game.batcher.begin();
		game.batcher.draw(AssetsManager.backgroundRegion, 0, 0, 320, 480);
		game.batcher.end();

		game.batcher.enableBlending();
		game.batcher.begin();
		game.batcher.draw(AssetsManager.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
		game.batcher.draw(AssetsManager.mainMenu, 10, 200 - 110 / 2, 300, 110);
		game.batcher.end();	
	}

	@Override
	public void render (float delta) {
		update();
		draw();
	}
}
