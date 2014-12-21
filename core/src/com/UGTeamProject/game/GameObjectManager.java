package com.UGTeamProject.game;

import java.util.ArrayList;

import com.UGTeamProject.prefab.GameObject;
import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;

public class GameObjectManager {

	public static GameObject radio;
	
	
	public static void load() {
		
	    ArrayList<Texture> texture = new ArrayList<Texture>(); 
        ArrayList<Music> music = new ArrayList<Music>(); 
        music.add(AssetsManager.radioMusic); 
        texture.add(AssetsManager.radioTexture); 
	    radio = new GameObject(null, texture, null, music, 333, 333);
	}
}