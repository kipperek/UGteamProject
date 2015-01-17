package com.UGTeamProject.actor;

import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class NPC extends Actor {

	public NPC(Texture texture) {
		super(texture);
		spawn();
		actor.width = 64;
		actor.height = 64;
	}

	public void spawn() {
		actor.x = MathUtils.random(500, 2500);
		actor.y = MathUtils.random(500, 2500);
	}

	public void die() {
		if (life <= 0)
			spawn();
	}

	public void computeRotation(int playerX, int playerY) {
		rotation = (float) Math.toDegrees(Math.atan2(+playerY - actor.y,
				playerX - actor.x)) - 90;
	}

	public void act(Actor player) {
		// MOVE
		float speed = 90 * Gdx.graphics.getDeltaTime();
		actor.x += (speed * Math.cos(Math.toRadians(this.rotation + 90)));
		actor.y += (speed * Math.sin(Math.toRadians(this.rotation + 90)));
	}
}