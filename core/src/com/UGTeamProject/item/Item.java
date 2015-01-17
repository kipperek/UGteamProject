package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;

public class Item {

	public Rectangle item;
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

	public boolean isPickedUp() {
		return pickedUp;
	}

	public void setPickedUp(boolean pickedUp) {
		this.pickedUp = pickedUp;
	}

	public void spawn() {
		item.x = MathUtils.random(0, 500);
		item.y = MathUtils.random(0, 500);
	}

	public void draw(Batch batch) {
		texture.draw(batch, item.x, item.y);
	}
}