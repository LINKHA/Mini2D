package com.Mini2D.Engine;

public interface PaintMove {
	void move(float x,float y);
	void move(Vector vec);
	void moveTo(Vector position,float speed);
	void moveAdd(Vector distance,float speed);
}
