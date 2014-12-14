package com.UGTeamProject.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.UGTeamProject.actor.Actor;
import com.UGTeamProject.prefab.adapters.Texture;

public class ScreenInput {
	
	public static Actor player;

	public ScreenInput(Actor newPlayer)
	{
		player = newPlayer;
	}
	
	public Touchpad initTouchpad()
	{
		Touchpad touchpad;
	    TouchpadStyle touchpadStyle;
	    Skin touchpadSkin;
	    Drawable touchBackground;
	    Drawable touchKnob;
	    
		touchpadSkin = new Skin();
        touchpadSkin.add("touchBackground", AssetsManager.touchBackground);
        touchpadSkin.add("touchKnob", AssetsManager.touchKnob);
        touchpadStyle = new TouchpadStyle();
        touchBackground = touchpadSkin.getDrawable("touchBackground");
        touchKnob = touchpadSkin.getDrawable("touchKnob");
        touchpadStyle.background = touchBackground;
        touchpadStyle.knob = touchKnob;
        touchpad = new Touchpad(10, touchpadStyle);
        touchpad.setBounds(15, 15, 200, 200);
        
		return touchpad;
	}
	
	public void listen()
	{
		if(Gdx.input.isTouched()) {
	         Vector3 touchPos = new Vector3();
	         touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
	         
	         if(touchPos.x > player.getX())
	        	 player.setX(player.getX() + 200 * Gdx.graphics.getDeltaTime());
	         else
	        	 player.setX(player.getX() - 200 * Gdx.graphics.getDeltaTime());
	         if(touchPos.y > player.getY())
	        	 player.setY(player.getY() + 200 * Gdx.graphics.getDeltaTime());
	         else
	        	 player.setY(player.getY() - 200 * Gdx.graphics.getDeltaTime());
	      }
		
		if(Gdx.input.isKeyPressed(Keys.LEFT)) 
	        player.setX(player.getX() - 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) 
	        player.setX(player.getX() + 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.UP)) 
	        player.setY(player.getY() + 200 * Gdx.graphics.getDeltaTime());
		if(Gdx.input.isKeyPressed(Keys.DOWN)) 
	        player.setY(player.getY() - 200 * Gdx.graphics.getDeltaTime());
		
	}
}
