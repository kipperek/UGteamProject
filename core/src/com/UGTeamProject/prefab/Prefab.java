package com.UGTeamProject.prefab;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class Prefab {
	
	public static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	private Vector2 position;
	
	public void addGameObject(GameObject newObject){
		gameObjects.add(newObject);
	}
	public void removeGameObject(GameObject newObject){
		gameObjects.remove(newObject);
	}
	
	public void update(){} 
	
	public void draw(){}

}
