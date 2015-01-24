package com.UGTeamProject.prefab;

import com.UGTeamProject.game.AssetsManager;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Bullet {
	private Texture bulletTexture;
	private Vector2 position;
	private Vector2 startPosition;
	private float angle;
	
	public Bullet(Vector2 startPosition, float angle){
		this.position = startPosition;
		this.startPosition = startPosition;
		this.angle = angle;
		this.bulletTexture = AssetsManager.bulletTexture;
	}
	
	private void act(){
		float speed = 90 * Gdx.graphics.getDeltaTime();
		position.x += (speed * Math.cos(Math.toRadians(this.angle + 90)));
		position.y += (speed * Math.sin(Math.toRadians(this.angle + 90)));
	}
	
	public boolean isOutOfBounds(){
		
		float xDelta = Math.abs(this.startPosition.x - this.position.x);
		float yDelta = Math.abs(this.startPosition.y - this.position.y);
		
		float deltaPosition = (float)Math.sqrt(Math.pow(xDelta,2)+Math.pow(yDelta,2));
		
		if(deltaPosition > 200)
			return true;		
		
		return false;
	}
	
	public void draw(Batch batch){
		act();
		bulletTexture.draw(batch,position.x,position.y,angle);
	}
}
