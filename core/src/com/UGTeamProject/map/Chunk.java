package com.UGTeamProject.map;

import java.util.ArrayList;
import java.util.List;

import com.UGTeamProject.prefab.interfaces.Drawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Chunk {
	final static int WIDTH = 1024;
	final static int HEIGHT = 1024;
	
	final private Vector2 position;
	final private List<Drawable> objects;
	
	private List<Drawable> toDelete = new ArrayList<Drawable>();
	
	private Chunk[][] neighbours;
	
	public Chunk(Vector2 position, List<Drawable>objects, Chunk[][] neighbours){
		this.position = position;
		this.objects = objects;
		this.neighbours = neighbours;
	}
	
	public void setNeighbours(Chunk[][] neighbours){
		this.neighbours = neighbours;
	}
	
	public void add(Drawable item){
		objects.add(item);
	}
	
	public void remove(Drawable item){
		objects.remove(item);
	}
	
	public Vector2 getPosition(){
		return position;
	}
	
	public void draw(Batch batcher){
		toDelete = new ArrayList<Drawable>();
		for(Drawable item : objects){
			item.draw(batcher);
			update(item);			
		}
		for(Drawable item : toDelete){
			objects.remove(item);
		}
	}
	
	private void update(Drawable item){
		Vector2 boundries = new Vector2(position.x+WIDTH,position.y+HEIGHT);
		Vector2 itemPosition = item.getPosition();
		
		int x=1;
		int y=1;
		
		if(itemPosition.x<position.x)
			x = 0;
		else if(itemPosition.x>boundries.x)
			x = 2;
		
		if(itemPosition.y<position.y)
			x = 2;
		else if(itemPosition.y>boundries.y)
			x = 0;
		
		if(x != 1 || y != 1){
			neighbours[x][y].add(item);
			toDelete.add(item);
		}			
	}

	
	
	
	
	
	
	

}
