package com.UGTeamProject.actor;

import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;

public class Actor {

	protected Rectangle actor;
	protected Texture texture;
	protected float rotation = 1;
	protected int life = 100;
	
	public Actor(Texture texture) {
		actor = new Rectangle();
		this.texture = texture;
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
	
	public float getRotation() {
		return rotation;
	}
	
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	public void draw(Batch batch){
		if(life > 0)
			texture.draw(batch, actor.x, actor.y, rotation);
	}
}