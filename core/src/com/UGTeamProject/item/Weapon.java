package com.UGTeamProject.item;

import com.UGTeamProject.prefab.adapters.Texture;

public class Weapon extends Item {

	protected int ammoSize;
	protected int magazineSize;
	protected int fireRate;
	protected int damage;
	protected int bulletSpeed;

	public Weapon(Texture texture) {
		super(texture);
	}
}