package com.Mini2D.Engine;

import java.util.ArrayList;
import java.util.List;

public class Collider extends Collision{
	RectHitBox hitBox;
	GameObject gameObject;
	//碰撞该物体的碰撞体
	private List<Collision> collisions = new ArrayList<Collision>();
	private boolean isHit = false;
	boolean begainHit = false;
	boolean outHit = false;
	public Collider(GameObject gameObject) {
		this.gameObject = gameObject;
		hitBox = new RectHitBox(gameObject.getPosition(),gameObject.getWidth(),gameObject.getHeight(),true);
		keyValue = gameObject.keyValue;
		CollisionSystem.getSystem().addCollider(this);
	}
	@Override
	public RectHitBox getHitBox() {
		// TODO Auto-generated method stub
		return hitBox;
	}
	@Override
	public void begainHit() {
		// TODO Auto-generated method stub
		begainHit = true;
	}
	@Override
	public void onHit(Collision collision) {
		// TODO Auto-generated method stub
		isHit = true;
		for(Collision c : collisions) {
			if(c.keyValue==collision.keyValue) {
				return;
			}
		}
		collisions.add(collision);
	}
	@Override
	public void releaseHit() {
		// TODO Auto-generated method stub
		outHit = true;
		isHit = false;
		this.collisions.clear();
	}
	@Override
	public void move() {
		// TODO Auto-generated method stub
		hitBox.move(gameObject.getPosition());
	}
	/*
	 * 控件开始发生碰撞
	 */
	public boolean onHit() {
		if(begainHit) {
			begainHit = false;
			return true;
		}
		return false;
	}
	/*
	 * 控件释放碰撞
	 */
	public boolean outHit() {
		if(outHit) {
			outHit = false;
			return true;
		}
		return false;
	}
	@Override
	public Boolean isHit() {
		// TODO Auto-generated method stub
		return isHit;
	}
	@Override
	public List<Collision> getHit() {
		// TODO Auto-generated method stub
		return collisions;
	}
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		collisions.clear();
	}
	/*
	 * 判断是否碰撞Tag为tag的碰撞体
	 */
	@Override
	public Boolean hit(Tag tag) {
		// TODO Auto-generated method stub
		if(isHit&&collisions.size()!=0) {
			for(Collision c : collisions) {
				if(c.tag==tag) {
					return true;
				}
			}
		}
		return false;
	}
}
