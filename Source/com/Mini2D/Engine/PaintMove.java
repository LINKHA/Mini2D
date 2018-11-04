package com.Mini2D.Engine;

public interface PaintMove {
	void move(float x,float y);
	void move(Vector2 vec);
	void moveTo(Vector2 position,float speed);
	void moveAdd(Vector2 distance,float speed);
}
