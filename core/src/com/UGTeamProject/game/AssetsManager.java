package com.UGTeamProject.game;

import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Texture;

public class AssetsManager {

	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static Texture touchBackground;
	public static Texture touchKnob;
	public static Music radioMusic;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.jpg");
		touchBackground = new Texture("sprites/touchBackground.png");
	    touchKnob = new Texture("sprites/touchKnob.png");
		radioMusic = new Music("music/radio.mp3"); 
	}
}
