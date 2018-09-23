package com.Mini2D.Engine;

public class DebugScript {
	int x=10000,y=500;
	public void Start() {
		
		
	} 
	public void Update() {
		if(x>=1000)
		{
			x=500;
		}
		if(x<=0)
		{
			x=0;
		}
		if(y>=1000)
		{
			y=500;
		}
		if(y<=0)
		{
			y=0;
		}
		
		
		//Change picture position to 100 100
		Screen.GetInstance().Position(x, y);	
		//Set picture scale to 2
		Screen.GetInstance().Scale(2);
	}
	void SetPosition(int x,int y) {
		this.x = x;
		this.y = y;
	}
}
