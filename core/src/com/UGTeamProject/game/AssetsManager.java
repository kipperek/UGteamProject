package com.UGTeamProject.game;

import com.UGTeamProject.prefab.adapters.Texture;

public class AssetsManager {

	public static Texture playerTexture;
	public static Texture grassTexture;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		
	}
}