package com.Mini2D.Engine;

public class Gravity {
	GameObject gameObject;
	int time;
	Vector2 gravityVec;
	void Down(GameObject gameObject,int time) {
		gameObject=this.gameObject;
		time=this.time;
		for(int i=0;i<time;i++)
			gameObject.move(0, (float) (9.8*i));
	}
}
