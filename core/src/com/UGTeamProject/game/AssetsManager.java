package com.UGTeamProject.game;

import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.UGTeamProject.prefab.adapters.Animation;
import com.UGTeamProject.prefab.adapters.Music;
import com.UGTeamProject.prefab.adapters.Physics;
import com.UGTeamProject.prefab.adapters.Sound;
import com.UGTeamProject.prefab.adapters.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;

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
		
		try{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(Gdx.files.internal("objects.json").file());
			doc.getDocumentElement().normalize();
			
			NodeList nodeLst = doc.getElementsByTagName("item");
			
			for(int i=0; i<nodeLst.getLength(); i++)
			{
				Node node = nodeLst.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE){
					Element item = (Element) node;
					String name = item.getAttribute("name");
					Element type = (Element) item.getElementsByTagName("type").item(0);

					switch(type.getNodeValue()){
					case "Texture": textures.put(name, new Texture("sprites/" + item.getElementsByTagName("file"))); break;
					case "Sound": break;
					case "Music": music.put(name, new Music("music/" + item.getElementsByTagName("file"))); break;
					case "Physics": break;
					case "Animation": break;
					default: new Logger("bad type name in objects.xml: " + type.getNodeValue(), Logger.ERROR); break;
					}
				}
			}
			
		} catch(Exception e){
			new Logger("problems with objects xml file", Logger.ERROR);
		}
	}
}