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
	
	public void moveLeft(float move)
	{
		position.set( position.x - move, position.y);
		
		for (GameObject gameobj: gameObjects)
	        gameobj.position.set( position.x - move, position.y);
	}
	
	public void moveRight(float move)
	{
		position.set( position.x + move, position.y);
		
		for (GameObject gameobj: gameObjects)
	        gameobj.position.set( position.x + move, position.y);
		
	} 
	
	public void moveDown(float move)
	{
		position.set( position.x, position.y + move);
		
		for (GameObject gameobj: gameObjects)
	        gameobj.position.set( position.x, position.y + move);
		
	} 
	
	public void moveUp(float move)
	{
		position.set( position.x, position.y - move);
		
		for (GameObject gameobj: gameObjects)
	        gameobj.position.set( position.x, position.y - move);
		
	} 
	
	public void draw(){}

}
