package com.UGTeamProject.actor;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;


public class Character {

	private Rectangle player;
	
	public Character() {
		player = new Rectangle();
		spawn();
		player.width = 64;
		player.height = 64;
	}
	
	public void spawn() {
		player.x = MathUtils.random(0,1000);
		player.y = MathUtils.random(0,1000); 
	}
	
	public float getX() {
		return player.x;
	}
	
	public void setX(float x) {
		player.x = x;
	}
	
	public float getY() {
		return player.y;
	}
	
	public void setY(float y) {
		player.y = y;
	}
}
