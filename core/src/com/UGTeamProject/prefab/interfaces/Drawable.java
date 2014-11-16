package com.UGTeamProject.prefab.interfaces;
import com.badlogic.gdx.graphics.g2d.Batch;

public interface Drawable {
	
	public void draw(Batch batcher);
	public void draw(Batch batch, float x, float y, float angle);
	public void draw(Batch batch, float x, float y);

}
