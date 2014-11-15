package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.Logger;

public class Physics {
	
	public static enum SHAPE_TYPES{
		CIRCLE, RECTANGLE, POLYGON, EDGE, CONE
	}

	public static enum PHYSICS_TYPE{
		NORMAL, TRIGGER, LIGHT
	}
	
	private SHAPE_TYPES shapeType;
	private PHYSICS_TYPE physicsType;
	private Vector2 position;
	private Float angle;
	
	private BodyDef def;
	private FixtureDef fixture;
	private Shape shape;
	private Body body;
	
	private Filter physicsGroupFilter;
	
	public Physics(PHYSICS_TYPE type, Float angle, float width, float height){
		if(notLightType(type))
		{
			this.shapeType = SHAPE_TYPES.RECTANGLE;
			setShape(this.shapeType);
		}
	}
	
	public Physics(PHYSICS_TYPE type, Float angle, float radius, Vector2 position){
		if(notLightType(type))
		{
			this.shapeType = SHAPE_TYPES.CIRCLE;
			setShape(this.shapeType);
		}
	}
	
	public Physics(PHYSICS_TYPE type, Float angle, Vector2[] points, Vector2 position){
		if(notLightType(type))
		{
			this.shapeType = SHAPE_TYPES.POLYGON;
			setShape(this.shapeType);
		}
	}
	
	public Physics(PHYSICS_TYPE type, Float angle, Vector2 startPoint, Vector2[] points, Vector2 endPoint){
		if(notLightType(type))
		{
			// for real it is a chain type
			this.shapeType = SHAPE_TYPES.EDGE;
			setShape(this.shapeType);
		}
	}
	
	private boolean notLightType(PHYSICS_TYPE type){
		
		if(type == PHYSICS_TYPE.LIGHT)
		{
			new Logger("This physics cannot be a light", Logger.ERROR);
			return false;
		}
		else return true;
	}
	
	private void setShape(SHAPE_TYPES byType){
		switch(byType){
		case CIRCLE: this.shape = new CircleShape(); break;
		case RECTANGLE: break;
		case POLYGON: break;
		case EDGE: break;
		default: new Logger("Physics type is not valid value", Logger.ERROR); break;
		}
	}
}
