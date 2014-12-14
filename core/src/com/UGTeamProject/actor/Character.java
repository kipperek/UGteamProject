package com.UGTeamProject.actor;

import com.badlogic.gdx.math.MathUtils;

public class Character extends Actor {

	public Character() {
		spawn();
		actor.width = 64;
		actor.height = 64;
	}
	
	public void spawn() {
		actor.x = MathUtils.random(0,1000);
		actor.y = MathUtils.random(0,1000); 
	}
	
	public void die() {
		if(life <= 0)
	        spawn();
	}
}
