package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Texture {
	
	private Sprite texture;
	
	public Texture (String resourceName, Vector2 origin, Vector2 position){
		texture = new Sprite(new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(resourceName)));
		texture.setOrigin(origin.x,origin.y);
		texture.setPosition(position.x, position.y);
		
	}
	public Texture (String resourceName, Vector2 origin){
		texture = new Sprite(new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(resourceName)));
		texture.setOrigin(origin.x,origin.y);
	}
	public Texture (String resourceName){
		texture = new Sprite(new com.badlogic.gdx.graphics.Texture(Gdx.files.internal(resourceName)));
	}
	
	public void draw(Batch batch, float x, float y, float angle){
		texture.setRotation(angle);
		texture.setPosition(x, y);
		texture.draw(batch);
		
	}
	public void draw(Batch batch, float x, float y){
		texture.setPosition(x, y);
		texture.draw(batch);
	}
	public void draw(Batch batch){
		texture.draw(batch);
	}

}
