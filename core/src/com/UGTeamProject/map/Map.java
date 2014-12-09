package com.UGTeamProject.map;

import java.util.ArrayList;
import java.util.List;

import com.UGTeamProject.prefab.adapters.Texture;
import com.UGTeamProject.prefab.interfaces.Drawable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Map {
	
	Chunk[][] map = new Chunk[10][10];
	
	private void init(){
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[i].length; j++){
				Vector2 position = new Vector2(i*Chunk.WIDTH, j*Chunk.HEIGHT);
				Chunk[][] neighbours = new Chunk[3][3];
				List<Drawable> objects = new ArrayList<Drawable>();
				objects.add(new Texture("sprites/grass.png",new Vector2(50,50), position));
				map[i][j] = new Chunk(position, objects, neighbours);
			}
		
		
		
		for(int i=1; i < map.length-1; i++){
			int max = map[i].length-1;
			Chunk[][] neighbours = new Chunk[3][3];
			neighbours[0][0] = map[i][0];
			neighbours[0][1] = map[i-1][0];
			neighbours[0][2] = map[i-1][1];
			neighbours[1][0] = map[i][0];
			neighbours[1][1] = map[i][0];
			neighbours[1][2] = map[i][1];
			neighbours[2][0] = map[i][0];
			neighbours[2][1] = map[i+1][0];
			neighbours[2][2] = map[i+1][1];
			map[i][0].setNeighbours(neighbours);
			
			neighbours = new Chunk[3][3];
			neighbours[0][0] = map[i-1][max-1];
			neighbours[0][1] = map[i-1][max];
			neighbours[0][2] = map[i][max];
			neighbours[1][0] = map[i][max-1];
			neighbours[1][1] = map[i][max];
			neighbours[1][2] = map[i][max];
			neighbours[2][0] = map[i+1][max-1];
			neighbours[2][1] = map[i+1][max];
			neighbours[2][2] = map[i][max];
			map[i][max].setNeighbours(neighbours);
			
			neighbours = new Chunk[3][3];
			neighbours[0][0] = map[0][i];
			neighbours[0][1] = map[0][i];
			neighbours[0][2] = map[0][i];
			neighbours[1][0] = map[0][i-1];
			neighbours[1][1] = map[0][i];
			neighbours[1][2] = map[0][i+1];
			neighbours[2][0] = map[1][i-1];
			neighbours[2][1] = map[1][i];
			neighbours[2][2] = map[1][i+1];
			map[0][i].setNeighbours(neighbours);
			
			
			neighbours = new Chunk[3][3];
			neighbours[0][0] = map[max-1][i-1];
			neighbours[0][1] = map[max-1][i];
			neighbours[0][2] = map[max-1][i+1];
			neighbours[1][0] = map[max][i-1];
			neighbours[1][1] = map[max][i];
			neighbours[1][2] = map[max][i+1];
			neighbours[2][0] = map[max][i];
			neighbours[2][1] = map[max][i];
			neighbours[2][2] = map[max][i];
			map[max][i].setNeighbours(neighbours);
			
		}
		
		for(int i = 1; i < map.length-1; i++)
			for(int j = 1; j < map[i].length-1; j++){
				Chunk[][] neighbours = new Chunk[3][3];
				neighbours[0][0] = map[i-1][j-1];
				neighbours[0][1] = map[i-1][j];
				neighbours[0][2] = map[i-1][j+1];
				neighbours[1][0] = map[i][j-1];
				neighbours[1][1] = map[i][j];
				neighbours[1][2] = map[i][j+1];
				neighbours[2][0] = map[i+1][j-1];
				neighbours[2][1] = map[i+1][j];
				neighbours[2][2] = map[i+1][j+1];
				map[i][j].setNeighbours(neighbours);
			}
		
		Chunk[][] n = new Chunk[3][3];
		n[0][0] = map[0][0];
		n[0][1] = map[0][0];
		n[0][2] = map[0][0];
		n[1][0] = map[0][0];
		n[1][1] = map[0][0];
		n[1][2] = map[0][1];
		n[2][0] = map[0][0];
		n[2][1] = map[0][1];
		n[2][2] = map[1][1];
		map[0][0].setNeighbours(n);
		
		n = new Chunk[3][3];
		n[0][0] = map[0][map[0].length-1];
		n[0][1] = map[0][map[0].length-1];
		n[0][2] = map[0][map[0].length-1];
		n[1][0] = map[0][map[0].length-2];
		n[1][1] = map[0][map[0].length-1];
		n[1][2] = map[0][map[0].length-1];
		n[2][0] = map[1][map[0].length-2];
		n[2][1] = map[1][map[0].length-1];
		n[2][2] = map[0][map[0].length-1];
		map[0][map[0].length-1].setNeighbours(n);
		
		n = new Chunk[3][3];
		n[0][0] = map[map.length-1][0];
		n[0][1] = map[map.length-2][0];
		n[0][2] = map[map.length-2][1];
		n[1][0] = map[map.length-1][0];
		n[1][1] = map[map.length-1][0];
		n[1][2] = map[map.length-1][1];
		n[2][0] = map[map.length-1][0];
		n[2][1] = map[map.length-1][0];
		n[2][2] = map[map.length-1][0];
		map[map.length-1][0].setNeighbours(n);
		
		n = new Chunk[3][3];
		n[0][0] = map[map.length-2][map[map.length-1].length-2];
		n[0][1] = map[map.length-2][map[map.length-1].length-1];
		n[0][2] = map[map.length-1][map[map.length-1].length-1];
		n[1][0] = map[map.length-1][map[map.length-1].length-2];
		n[1][1] = map[map.length-1][map[map.length-1].length-1];
		n[1][2] = map[map.length-1][map[map.length-1].length-1];
		n[2][0] = map[map.length-1][map[map.length-1].length-1];
		n[2][1] = map[map.length-1][map[map.length-1].length-1];
		n[2][2] = map[map.length-1][map[map.length-1].length-1];
		map[map.length-1][map[map.length-1].length-1].setNeighbours(n);
	}
	
	public Map(){
		init();
	}
	
	public void draw(Batch batcher){
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map[i].length; j++){
				map[i][j].draw(batcher);
			}
	}
	
}
