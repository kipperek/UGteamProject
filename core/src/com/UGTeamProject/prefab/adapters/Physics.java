package com.UGTeamProject.prefab.adapters;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.CircleShape;
//import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Logger;

public class Physics {

	public final static float PIXELS_TO_METERS = 100f;
	public final static float GRAVITY = -9.8f;

	public static enum SHAPE_TYPE {
		CIRCLE, RECTANGLE, POLYGON, EDGE
	}

	public static enum PHYSICS_TYPE {
		NORMAL, TRIGGER
	}

	public static enum MOBILITY_TYPE {
		WALL, BULLET, PROP
	}

	private Vector2 position;
	private Float angle;

	private BodyDef def;
	private FixtureDef fixture;
	private Shape shape;
	private Body body;

	// private Filter physicsGroupFilter;

	private void Initialize(World physics, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Shape shape, Float angle, float density, float friction, float restitution, Vector2 position) {

		this.fixture = new FixtureDef();
		setFixture(shape, density, friction, restitution, type);

		this.def = new BodyDef();

		this.def.type = getMobility(mobility);
		this.def.position.set(new Vector2(position.x / PIXELS_TO_METERS, position.y / PIXELS_TO_METERS));

		this.body = physics.createBody(this.def);
		this.body.createFixture(this.fixture);

		this.angle = angle;
		this.position = this.def.position;
	}

	public Physics(World physics, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, float width, float height, Vector2 position) {
		setShape(SHAPE_TYPE.RECTANGLE);
		PolygonShape shape = (PolygonShape) this.shape;
		shape.setAsBox(width / PIXELS_TO_METERS, height / PIXELS_TO_METERS, new Vector2((position.x / 2) / PIXELS_TO_METERS, (position.y / 2) / PIXELS_TO_METERS), angle);

		Initialize(physics, type, mobility, shape, angle, density, friction, restitution, position);
	}

	public Physics(World physics, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, float radius, Vector2 position) {
		setShape(SHAPE_TYPE.CIRCLE);
		CircleShape shape = (CircleShape) this.shape;
		shape.setRadius(radius / PIXELS_TO_METERS);

		Initialize(physics, type, mobility, shape, angle, density, friction, restitution, position);

		this.body.setTransform(position.x / PIXELS_TO_METERS, position.y / PIXELS_TO_METERS, this.angle);

	}

	public Physics(World physics, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, Vector2[] points, Vector2 position, Vector2 origin) {
		setShape(SHAPE_TYPE.POLYGON);
		PolygonShape shape = (PolygonShape) this.shape;

		Vector2 tab[] = new Vector2[points.length];

		for (int i = 0; i < points.length; i++) {
			tab[i] = new Vector2(points[i].x / PIXELS_TO_METERS, points[i].y / PIXELS_TO_METERS);
		}
		shape.set(tab);

		Initialize(physics, type, mobility, shape, angle, density, friction, restitution, position);

		this.body.setTransform((position.x / PIXELS_TO_METERS) + (origin.x / PIXELS_TO_METERS), (position.y / PIXELS_TO_METERS) + (origin.y / PIXELS_TO_METERS), this.angle);
	}

	public Physics(World physics, PHYSICS_TYPE type, MOBILITY_TYPE mobility, Float angle, float density, float friction, float restitution, Vector2 startPoint, Vector2[] points, Vector2 endPoint,
			Vector2 position, Vector2 origin) {
		setShape(SHAPE_TYPE.EDGE);
		ChainShape shape = (ChainShape) this.shape;

		Vector2 tab[] = new Vector2[points.length + 2];

		tab[0] = new Vector2(startPoint.x / PIXELS_TO_METERS, startPoint.y / PIXELS_TO_METERS);

		for (int i = 0; i < points.length; i++) {
			tab[i + 1] = new Vector2(new Vector2(points[i].x / PIXELS_TO_METERS, points[i].y / PIXELS_TO_METERS));
		}

		tab[tab.length - 1] = new Vector2(endPoint.x / PIXELS_TO_METERS, endPoint.y / PIXELS_TO_METERS);

		shape.createChain(tab);

		Initialize(physics, type, mobility, shape, angle, density, friction, restitution, position);

		this.body.setTransform((position.x / PIXELS_TO_METERS) + (origin.x / PIXELS_TO_METERS), (position.y / PIXELS_TO_METERS) + (origin.y / PIXELS_TO_METERS), this.angle);
	}

	public Vector2 getPosition() {
		return this.position;
	}

	public Float getAngle() {
		return this.angle;
	}

	private void setShape(SHAPE_TYPE byType) {
		switch (byType) {
		case CIRCLE:
			this.shape = new CircleShape();
			break;
		case RECTANGLE:
			this.shape = new PolygonShape();
			break;
		case POLYGON:
			this.shape = new PolygonShape();
			break;
		case EDGE:
			this.shape = new ChainShape();
			break;
		default:
			new Logger("Physics type is not valid value", Logger.ERROR);
			break;
		}
	}

	private BodyDef.BodyType getMobility(MOBILITY_TYPE byMobility) {
		switch (byMobility) {
		case WALL:
			return BodyDef.BodyType.StaticBody;
		case BULLET:
			return BodyDef.BodyType.KinematicBody;
		case PROP:
			return BodyDef.BodyType.DynamicBody;
		default:
			new Logger("Physics mobility type is not valid value", Logger.ERROR);
			return null;
		}
	}

	private void setFixture(Shape shape, float density, float friction, float restitution, PHYSICS_TYPE type) {
		this.fixture.shape = shape;
		this.fixture.density = density;
		this.fixture.friction = friction;
		this.fixture.restitution = restitution;

		if (type == PHYSICS_TYPE.TRIGGER)
			this.fixture.isSensor = true;
	}
}