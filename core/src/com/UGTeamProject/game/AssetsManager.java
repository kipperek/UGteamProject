package com.UGTeamProject.game;

import java.util.TreeMap;

import com.UGTeamProject.prefab.adapters.Animation;
import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Physics;
import com.UGTeamProject.prefab.adapters.Sound;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.utils.XmlReader;

public class AssetsManager {
	
	public static TreeMap<String, Texture> textures = new TreeMap<String, Texture>();
	public static TreeMap<String, Sound> sounds = new TreeMap<String, Sound>();
	public static TreeMap<String, Music> music = new TreeMap<String, Music>();
	public static TreeMap<String, Physics> physics = new TreeMap<String, Physics>();
	public static TreeMap<String, Animation> animations = new TreeMap<String, Animation>();
	
	public static Texture playerTexture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static Texture npcTexture;
	public static com.badlogic.gdx.graphics.Texture touchBackground;
	public static com.badlogic.gdx.graphics.Texture touchKnob;
	public static Music radioMusic;
	
	public static void load() {
		
		playerTexture = new Texture("sprites/bohater.png");
		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.jpg");
		npcTexture = new Texture("sprites/npc.png");
		touchBackground = new Texture("sprites/touchBackground.png").getTexture();
	    touchKnob = new Texture("sprites/touchKnob.png").getTexture();
		radioMusic = new Music("music/radio.mp3"); 

	}
}