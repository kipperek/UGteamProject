package com.UGTeamProject.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Actor {

	protected Rectangle actor;
	protected int life = 100;
	
	public Actor() {
		actor = new Rectangle();
	}
	
	public float getX() {
		return actor.x;
	}
	
	public void setX(float x) {
		actor.x = x;
	}
	
	public float getY() {
		return actor.y;
	}
	
	public void setY(float y) {
		actor.y = y;
	}
	
	public float getWidth() {
		return actor.width;
	}
	
	public void setWidth(float width) {
		actor.width = width;
	}
	
	public float getHeight() {
		return actor.height;
	}
	
	public void setHeight(float height) {
		actor.height = height;
	}
	
	public void act(Actor player) {
		 if(player.getY() > actor.y)
			 actor.y += 100 * Gdx.graphics.getDeltaTime();
        else
       	 actor.y -= 100 * Gdx.graphics.getDeltaTime();
        
        if(player.getX() > actor.x)
       	 actor.x += 100 * Gdx.graphics.getDeltaTime();
        else
       	 actor.x -= 100 * Gdx.graphics.getDeltaTime();
	}
}
