package com.Mini2D.Engine;

public class RectHitBox {
	private Vector2 objectLocation;
	int width;
	int height;
	boolean blueBox;
	public RectHitBox(int x,int y,int width,int height,boolean blueBox) {
		objectLocation.x = x;
		objectLocation.y = y;
		this.width = width;
		this.height = height;
	}
	public RectHitBox(Vector2 location,int width,int height,boolean blueBox) {
		objectLocation = location;
		this.width = width;
		this.height = height;
	}
	public void move(Vector2 location) {
		objectLocation = location;
	}
	/*
	 * 当前碰撞体是否和参数碰撞体 
	 * 使用这些信息判断是否交错(碰撞)
	 */
	public boolean intersects(RectHitBox r) {
		int tw = this.width;
		int th = this.height;
		int rw = r.width;
		int rh = r.height;
		if(rw<=0||rh<=0||tw<=0||th<=0) {
			return false;
		}
		int tx = (int)objectLocation.x - tw/2;
		int ty = (int)objectLocation.y - th/2;
		int rx = (int)r.objectLocation.x - rw/2;
		int ry = (int)r.objectLocation.y - rh/2;
		rw += rx;
		rh += ry;
		tw += tx;
		th += ty;
		return ((rw<rx || rw>tx)&&
				(rh<ry || rh>ty)&&
				(tw<tx || tw>rx)&&
				(th<ty || th>ry));
	}
	Vector2 getPosition() {
		return objectLocation;
	}
}
