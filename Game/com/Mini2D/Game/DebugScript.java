package com.Mini2D.Game;

import com.Mini2D.Engine.GameObject;
import com.Mini2D.Engine.Input;
import com.Mini2D.Engine.KeyCodeIndex;
import com.Mini2D.Engine.ScriptSuper;
import com.Mini2D.Engine.Vector2;

public class DebugScript extends ScriptSuper{	
	float x1=500,y1=500;
	int w1=100,h1=100;
	
	float x2=100,y2 =100;
	int w2=100,h2=100;
	
	GameObject obj1;
	GameObject obj2;
	
	String name1="Assets/t.png";
	String name2="Assets/t2.png";
	Vector2 Vec1 = new Vector2(500,500);
	Vector2 Vec2 = new Vector2(100,100);

	
	@Override
	public void Init() {
		obj1 = new GameObject(name1, Vec1, w1, h1);
		obj2 = new GameObject(name2, Vec2, w2, h2);
	}
	@Override
	public void RunLoop() {
		buttonDown();
		mouseDown();
		obj1.setPosition(x1, y1);
		obj1.Size(w1, h1);
		obj2.setPosition(x2, y2);
		obj2.Size(w2, h2);
	}

	public void buttonDown() {
		if(Input.getButtonDown(KeyCodeIndex.W))
			y1-=3;
		if(Input.getButtonDown(KeyCodeIndex.S))
			y1+=3;
		if(Input.getButtonDown(KeyCodeIndex.D))
			x1+=3;
		if(Input.getButtonDown(KeyCodeIndex.A))
			x1-=3;
		if(Input.getButtonDown(KeyCodeIndex.UP))
			y2-=3;
		if(Input.getButtonDown(KeyCodeIndex.DOWN))
			y2+=3;
		if(Input.getButtonDown(KeyCodeIndex.LEFT))
			x2-=3;
		if(Input.getButtonDown(KeyCodeIndex.RIGHT))
			x2+=3;
		if(Input.getButtonDown(KeyCodeIndex.R)){
			w1+=3;
			h1+=3;
		}
		if(Input.getButtonDown(KeyCodeIndex.F)){
			w1-=3;
			h1-=3;
		}
	}
	private void mouseDown() {
		if(Input.leftMouseDown())
			System.out.println("Left");
		else if(Input.rightMouseDown())
			System.out.println("right");
	}
	@Override
	public void Destruction() {
	}
	
}