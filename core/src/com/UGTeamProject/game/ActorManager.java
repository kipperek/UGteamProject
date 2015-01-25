package com.UGTeamProject.game;

import java.util.ArrayList;

import com.UGTeamProject.actor.NPC;

public class ActorManager {
	
	public static NPC npc;
	public static ArrayList<NPC> npcs;
	
	public static void load() {
		
		npcs = new ArrayList<NPC>();
		
		for(int i=0; i<10; i++) {
		    npc = new NPC(AssetsManager.npcTexture);
			npcs.add(npc);
		}
	}
}