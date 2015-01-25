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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Logger;

public class AssetsManager {

	public static TreeMap<String, Texture> textures = new TreeMap<String, Texture>();
	public static TreeMap<String, Sound> sounds = new TreeMap<String, Sound>();
	public static TreeMap<String, Music> music = new TreeMap<String, Music>();
	public static TreeMap<String, Physics> physics = new TreeMap<String, Physics>();
	public static TreeMap<String, Animation> animations = new TreeMap<String, Animation>();

	public static Texture playerKnifeTexture;
	public static Texture playerKnife2Texture;
	public static Texture playerPistolTexture;
	public static Texture playerPistol2Texture;
	public static Texture playerRifleTexture;
	public static Texture playerRifle2Texture;
	public static Texture grassTexture;
	public static Texture radioTexture;
	public static Texture npcTexture;
	public static Texture pistolTexture;
	public static Texture rifleTexture;
	public static Texture bulletTexture;

	public static com.badlogic.gdx.graphics.Texture touchBackground;
	public static com.badlogic.gdx.graphics.Texture touchKnob;
	public static com.badlogic.gdx.graphics.Texture pickupButton;
	public static com.badlogic.gdx.graphics.Texture pistolButton;
	public static com.badlogic.gdx.graphics.Texture background;
	public static com.badlogic.gdx.graphics.Texture items;

	public static TextureRegion mainMenu;
	public static TextureRegion logo;
	public static TextureRegion backgroundRegion;

	public static Music radioMusic;
	public static Music zombie;

	public static void load() {

		playerKnifeTexture = new Texture("sprites/playerKnife.png");
		playerKnifeTexture.setOrigin(32f, 14f);
		playerKnife2Texture = new Texture("sprites/playerKnife2.png");
		playerKnife2Texture.setOrigin(32f, 14f);
		playerPistolTexture = new Texture("sprites/playerPistol.png");
		playerPistolTexture.setOrigin(32f, 14f);
		playerPistol2Texture = new Texture("sprites/playerPistol2.png");
		playerPistol2Texture.setOrigin(32f, 14f);
		playerRifleTexture = new Texture("sprites/playerRifle.png");
		playerRifleTexture.setOrigin(32f, 14f);
		playerRifle2Texture = new Texture("sprites/playerRifle2.png");
		playerRifle2Texture.setOrigin(32f, 14f);
		
		
		bulletTexture = new Texture("sprites/bullet.png");
		pistolTexture = new Texture("sprites/pistol.png");
		rifleTexture = new Texture("sprites/rifle.png");

		grassTexture = new Texture("sprites/grass.png");
		radioTexture = new Texture("sprites/radio.png");
		npcTexture = new Texture("sprites/npc.png");
		npcTexture.setOrigin(32f, 14f);
		touchBackground = new Texture("sprites/touchBackground.png").getTexture();
		touchKnob = new Texture("sprites/touchKnob.png").getTexture();
		pickupButton = new Texture("sprites/pickupArrow.png").getTexture();
		pistolButton = new Texture("sprites/pistolButton.png").getTexture();
		background = new com.badlogic.gdx.graphics.Texture("sprites/background.png");
		items = new com.badlogic.gdx.graphics.Texture("sprites/items.png");

		backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);
		mainMenu = new TextureRegion(items, 0, 224, 300, 110);
		logo = new TextureRegion(items, 0, 352, 274, 142);

		radioMusic = new Music("music/radio.mp3");
		zombie = new Music("music/zombie.wav");

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(Gdx.files.internal("objects.xml").file());
			// doc.getDocumentElement().normalize();

			NodeList nodeLst = doc.getElementsByTagName("item");

			for (int i = 0; i < nodeLst.getLength(); i++) {
				Node node = nodeLst.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) node;
					String name = item.getAttribute("name");
					Element type = (Element) item.getElementsByTagName("type").item(0);

					switch (type.getNodeValue()) {
					case "Texture":
									
					Element position = (Element)item.getElementsByTagName("position").item(0);
					Element origin = (Element)item.getElementsByTagName("origin").item(0);
					
					if(origin != null)
						textures.puit(name, new Texture("sprites/" + item.getElementsByTagName("file").item(0).getNodeValue()));
					else if(position != null && origin == null)
						textures.put(name, new Texture("sprites/" + item.getElementsByTagName("file").item(0).getNodeValue(), origin));
					else
						textures.put(name, new Texture("sprites/" + item.getElementsByTagName("file").item(0).getNodeValue(), origin, position));		
						break;
					case "Sound":
						break;
					case "Music":
						music.put(name, new Music("music/" + item.getElementsByTagName("file").item(0).getNodeValue()));
						break;
					case "Physics":
						break;
					case "Animation":
						break;
					default:
						new Logger("bad type name in objects.xml: " + type.getNodeValue(), Logger.ERROR);
						break;
					}
				}
			}

		} catch (Exception e) {
			new Logger("problems with objects xml file", Logger.ERROR);
		}
	}
}