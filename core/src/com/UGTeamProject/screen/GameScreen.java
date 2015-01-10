package com.UGTeamProject.screen;

import com.UGTeamProject.actor.Actor;
import com.UGTeamProject.actor.Character;
import com.UGTeamProject.actor.NPC;
import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.game.GameManager;
import com.UGTeamProject.game.GameObjectManager;
import com.UGTeamProject.input.ScreenInput;
import com.UGTeamProject.map.Map;
import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen extends ScreenAdapter {

    OrthographicCamera camera;
    GameManager game;
    Actor player;
    Actor npc;
    Stage stage;
    Viewport newport;
    ScreenInput updateActor;
    Touchpad leftAnalog;
    Map map;
    
    public GameScreen (GameManager game) {
    	this.game = game;	
    	camera = new OrthographicCamera(800, 600);
    	camera.setToOrtho(false, 400, 300);
    	player = new Character();
    	npc = new NPC();
    	updateActor = new ScreenInput(player);
    	newport = new FitViewport(400, 300, camera);
    	stage = new Stage(newport,game.batcher);
    	if(Gdx.app.getType() == ApplicationType.Android)
    	{
    		leftAnalog = ScreenInput.initTouchpad(player.getX(),player.getY());
    		stage.addActor(leftAnalog);
    	}
    	map = new Map();
    	GameObjectManager.load();  
        Gdx.input.setInputProcessor(stage);
    }
	
	@Override
	public void render (float delta) {
		Gdx.gl.glClearColor(0.09f, 0.28f, 0.2f, 1);
		Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);
			
		camera.position.set(player.getX() + player.getWidth()/2, player.getY() + 75, 0);
	    camera.update();
	    game.batcher.setProjectionMatrix(camera.combined);
	    
	    game.batcher.disableBlending();
	    game.batcher.begin();
		map.draw(game.batcher);
		game.batcher.end();
		
		game.batcher.enableBlending();
		game.batcher.begin();
		game.font.setScale( 0.6f,0.6f);
		game.font.draw(game.batcher, "X: " + player.getX() + "Y: " + player.getY(), player.getX() - 150, player.getY() + 200);      
		AssetsManager.radioTexture.draw(game.batcher, GameObjectManager.radio.position.x, GameObjectManager.radio.position.y);	
		AssetsManager.playerTexture.draw(game.batcher, player.getX(), player.getY());	// WTF?
		AssetsManager.npcTexture.draw(game.batcher, npc.getX(), npc.getY());	
		
		if(Gdx.app.getType() == ApplicationType.Android)
			updateActor.listen(leftAnalog);
		else if(Gdx.app.getType() == ApplicationType.Desktop)
			updateActor.listen();
		
		game.batcher.end();
		
		GameObjectManager.radio.music.get(0).play(GameObjectManager.radio.position, player.getX(), player.getY()); 
		stage.act(Gdx.graphics.getDeltaTime());    
		npc.act(player);
        stage.draw();
	}
}
