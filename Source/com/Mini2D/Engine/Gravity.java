package com.Mini2D.Engine;

public class Gravity {
	GameObject gameObject;
	Vector2 gravityVec;
	int time;
	void Down() {
		for(int i=0;i<time;i++)
			gameObject.move(0, (float) (9.8*i));
	}
}
