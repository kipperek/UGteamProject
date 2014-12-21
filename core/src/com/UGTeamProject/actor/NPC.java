package com.UGTeamProject.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class NPC extends Actor {

	public NPC() {
		spawn();
		actor.width = 64;
		actor.height = 64;
	}
	
	public void spawn() {
		actor.x = MathUtils.random(500,2500);
		actor.y = MathUtils.random(500,2500); 
	}
	
	public void die() {
		if(life <= 0)
	        spawn();
	}
	
	public void act(Character player) {
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