package com.UGTeamProject.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.UGTeamProject.actor.Actor;

public class ScreenInput {
	
	public static Actor player;

	public ScreenInput(Actor newplayer)
	{
		player = newplayer;
	}
	
	public void listen()
	{
		if(Gdx.input.isTouched()) {
	         Vector3 touchPos = new Vector3();
	         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	         
	         if(touchPos.x > player.getX())
	        	 player.setX(player.getX() + 200 * Gdx.graphics.getDeltaTime());
	         else
	        	 player.setX(player.getX() - 200 * Gdx.graphics.getDeltaTime());
	         if(touchPos.y > player.getY())
	        	 player.setY(player.getY() + 200 * Gdx.graphics.getDeltaTime());
	         else
	        	 player.setY(player.getY() - 200 * Gdx.graphics.getDeltaTime());
	      }
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) 
	        player.setX(player.getX() - 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) 
	        player.setX(player.getX() + 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.UP)) 
	        player.setY(player.getY() - 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.DOWN)) 
	        player.setY(player.getY() + 200 * Gdx.graphics.getDeltaTime());
		
	}
}
