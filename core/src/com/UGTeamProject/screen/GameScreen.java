package com.UGTeamProject.screen;

import com.UGTeamProject.game.GameManager;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class GameScreen extends ScreenAdapter {

	OrthographicCamera camera;
    GameManager game;
    
    public GameScreen (GameManager game) {
    	this.game = game;	
    	camera = new OrthographicCamera();
    	camera.setToOrtho(false, 800, 480);
	}
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
		game.batcher.begin();
		game.font.draw(game.batcher, "CIEMNOSC!", 333, 333);
		game.batcher.end();
	}
}