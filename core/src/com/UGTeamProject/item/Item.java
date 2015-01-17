package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Item {

	protected Rectangle item;
	protected Texture texture;
	protected boolean pickedUp;

	public Item(Texture texture) {
		item = new Rectangle();
		spawn();
		pickedUp = false;
		this.texture = texture;
	}

	public float getX() {
		return item.x;
	}

	public void setX(float x) {
		item.x = x;
	}

	public float getY() {
		return item.y;
	}

	public void setY(float y) {
		item.y = y;
	}

	public void spawn() {
		item.x = MathUtils.random(0, 1000);
		item.y = MathUtils.random(0, 1000);
	}

	public void draw(Batch batch) {
		texture.draw(batch, item.x, item.y);
	}
}