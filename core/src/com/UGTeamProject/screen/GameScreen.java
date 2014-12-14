package com.UGTeamProject.screen;

import java.util.ArrayList;
import com.UGTeamProject.actor.Actor;
import com.UGTeamProject.actor.Character;
import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.game.GameManager;
import com.UGTeamProject.input.ScreenInput;
import com.UGTeamProject.map.Map;
import com.UGTeamProject.prefab.GameObject;
import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
public class GameScreen extends ScreenAdapter {

    OrthographicCamera camera;
    GameManager game;
    Actor player;
    ScreenInput updateActor;
    //Touchpad leftanalog;
    Map map;
    
    GameObject radio;
    ArrayList<Texture> texture = new ArrayList<Texture>(); // ???
    ArrayList<Music> music = new ArrayList<Music>(); // ???
    
    public GameScreen (GameManager game) {
    	this.game = game;	
    	camera = new OrthographicCamera(800, 600);
    	camera.setToOrtho(false, 400, 300);
    	player = new Character();
    	updateActor = new ScreenInput(player);

    	//leftanalog = ScreenInput.initTouchpad();
    	map = new Map();
    	
    	music.add(AssetsManager.radioMusic); // ???
        texture.add(AssetsManager.radioTexture); // ???
    	radio = new GameObject(null, texture, null, music, 333, 333);
    }
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0.09f, 0.28f, 0.2f, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
			
		camera.position.set(player.getX() + player.getWidth()/2, player.getY() + 75, 0);
	    camera.update();
	    game.batcher.setProjectionMatrix(camera.combined);
		
		game.batcher.begin();
		map.draw(game.batcher);
		game.font.setScale( 0.6f,0.6f);
		game.font.draw(game.batcher, "X: " + player.getX() + "Y: " + player.getY(), player.getX() - 150, player.getY() + 200);      
		AssetsManager.playerTexture.draw(game.batcher, player.getX(), player.getY());	// WTF?
		AssetsManager.radioTexture.draw(game.batcher, radio.position.x, radio.position.y);
		radio.music.get(0).play(radio.position, player.getX(), player.getY()); // ???
		//leftanalog.draw(game.batcher, 15);
		updateActor.listen();
		
		game.batcher.end();
	}
}


