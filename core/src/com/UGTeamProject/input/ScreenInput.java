package com.UGTeamProject.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad.TouchpadStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.UGTeamProject.actor.Actor;
import com.UGTeamProject.game.AssetsManager;

public class ScreenInput {
	
	public static Actor player;

	public ScreenInput(Actor newPlayer)
	{
		player = newPlayer;
	}
	
	public static Touchpad initTouchpad(float x, float y)
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
        touchpad = new Touchpad(1, touchpadStyle);
        touchpad.setBounds(x - 150, y - 50, 50, 50);
        
		return touchpad;
	}
	
	public void listen(Touchpad leftAnalog)
	{
		player.setX(player.getX() + leftAnalog.getKnobPercentX()*5);
		leftAnalog.setX((player.getX() - 150) + leftAnalog.getKnobPercentX()*5);
        player.setY(player.getY() + leftAnalog.getKnobPercentY()*5);
        leftAnalog.setY((player.getY() - 50) + leftAnalog.getKnobPercentY()*5);
        
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

