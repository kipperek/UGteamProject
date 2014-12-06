package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Logger;

public class Physics {
	
	public final static float PIXELS_TO_METERS = 100f;
	public final static float GRAVITY = -9.8f;
	
	public final static World physics = new World(new Vector2(0, GRAVITY), false);
	
	public static enum SHAPE_TYPE{
		CIRCLE, RECTANGLE, POLYGON, EDGE
	}

	public static enum PHYSICS_TYPE{
		NORMAL, TRIGGER
	}
	
	public static enum MOBILITY_TYPE{
		WALL, BULLET, PROP
	}
	
	private Vector2 position;
	private Float angle;
	
	private BodyDef def;
	private FixtureDef fixture;
	private Shape shape;
	private Body body;
	
	private Filter physicsGroupFilter;
	
	private void Initialize(SHAPE_TYPE shapeType, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, Vector2 position){
		
		setShape(shapeType);
		
		this.fixture = new FixtureDef();
		setFixture(density, friction, restitution);
			
		this.def.type = getMobility(mobility);
		this.def.position.set(position);
			
		this.body = physics.createBody(this.def);
		this.body.createFixture(this.fixture);
		
		this.angle = angle;
		this.position = this.def.position;
	}
	
	public Physics(PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, float width, float height, Vector2 position){
		Initialize(SHAPE_TYPE.RECTANGLE, type, mobility, angle, density, friction, restitution, position);
		
		PolygonShape a = (PolygonShape)this.shape;
		a.setAsBox(width, height, new Vector2(position.x/2, position.y/2), angle);
		this.shape = a;
	}
	
	public Physics(PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, float radius, Vector2 position){
		Initialize(SHAPE_TYPE.CIRCLE, type, mobility, angle, density, friction, restitution, position);
		
		CircleShape a = (CircleShape)this.shape;
		a.setRadius(radius);
		this.shape = a;
		
		this.body.setTransform(position.x, position.y, this.angle);
	}
	
	public Physics(PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, Vector2[] points, Vector2 position, Vector2 origin){
		Initialize(SHAPE_TYPE.POLYGON, type, mobility, angle, density, friction, restitution, position);
		
		PolygonShape a = (PolygonShape)this.shape;
		a.set(points);
		
		this.body.setTransform(origin.x, origin.y, this.angle);
	}
	
	public Physics(PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, Vector2 startPoint, Vector2[] points, Vector2 endPoint, Vector2 position, Vector2 origin){
		// for real it is a chain type
		Initialize(SHAPE_TYPE.EDGE, type, mobility, angle, density, friction, restitution, position);
		
		ChainShape a = (ChainShape)this.shape;
		a.createChain(points);
		this.shape = a;
		
		this.body.setTransform(origin.x, origin.y, this.angle);
	}

	public Vector2 getPosition() {
		return this.position;
	}

	public Float getAngle() {
		return this.angle;
	}
	
	private void setShape(SHAPE_TYPE byType){
		switch(byType){
		case CIRCLE: this.shape = new CircleShape(); break;
		case RECTANGLE: this.shape = new PolygonShape(); break;
		case POLYGON: this.shape = new PolygonShape(); break;
		case EDGE: this.shape = new ChainShape(); break;
		default: new Logger("Physics type is not valid value", Logger.ERROR); break;
		}
	}
	
	private BodyDef.BodyType getMobility(MOBILITY_TYPE byMobility){
		switch(byMobility){
		case WALL: return BodyDef.BodyType.StaticBody; 
		case BULLET: return BodyDef.BodyType.KinematicBody; 
		case PROP: return BodyDef.BodyType.DynamicBody; 
		default: new Logger("Physics mobility type is not valid value", Logger.ERROR); return null;
		}
	}
	
	private void setFixture(float density, float friction, float restitution)
	{
		fixture.density = density;
		fixture.friction = friction;
		fixture.restitution = restitution;
	}
}
