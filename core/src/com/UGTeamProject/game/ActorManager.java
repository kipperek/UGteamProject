package com.UGTeamProject.game;

import java.util.ArrayList;

import com.UGTeamProject.actor.NPC;

public class ActorManager {
	
	public static NPC npc1, npc2, npc3, npc4, npc5, npc6;
	public static ArrayList<NPC> npcs;
	
	public static void load() {
		npc1 = new NPC(AssetsManager.npcTexture);
		npc2 = new NPC(AssetsManager.npcTexture);
		npc3 = new NPC(AssetsManager.npcTexture);
		npc4 = new NPC(AssetsManager.npcTexture);
		npc5 = new NPC(AssetsManager.npcTexture);
		npc6 = new NPC(AssetsManager.npcTexture);
		
		npcs = new ArrayList<NPC>();
		
		npcs.add(npc1);
		npcs.add(npc2);
		npcs.add(npc3);
		npcs.add(npc4);
		npcs.add(npc5);
		npcs.add(npc6);
	}
}