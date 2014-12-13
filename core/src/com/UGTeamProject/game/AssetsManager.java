package com.UGTeamProject.game;

import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;

public class AssetsManager {

	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static Music radioMusic;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.jpg");
		radioMusic = new Music("music/radio.mp3"); 
	}
}
