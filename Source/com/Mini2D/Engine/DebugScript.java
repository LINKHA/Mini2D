package com.Mini2D.Engine;

public class DebugScript {
	public void Start() {
		
	}
	public void Update() {
		//Change picture position to 100 100
		Screen.GetInstance().Position(500, 500);	
		//Set picture scale to 2
		Screen.GetInstance().Scale(2);	
	}
}
