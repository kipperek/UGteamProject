package com.UGTeamProject.actor;

import com.badlogic.gdx.math.Rectangle;

public class Actor {

	protected Rectangle actor;
	
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
}