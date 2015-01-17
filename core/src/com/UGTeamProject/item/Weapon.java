package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;

public class Weapon extends Item {

	public int ammoSize;
	public int magazineSize;
	public int fireRate;
	public int damage;
	public int bulletSpeed;
	public Texture playerTexture;

	public Weapon(Texture texture) {
		super(texture);
	}
}