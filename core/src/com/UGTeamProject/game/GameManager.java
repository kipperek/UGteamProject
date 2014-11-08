package com.UGTeamProject.game;

import com.UGTeamProject.screen.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameManager extends Game {
	
	public SpriteBatch batcher; //used by all screens
	public BitmapFont font;
  
	@Override
    public void create() {
        batcher = new SpriteBatch();
        font = new BitmapFont();
        setScreen(new MainMenuScreen(this));
    }

	@Override
    public void render() {
        super.render(); 
    }
}	