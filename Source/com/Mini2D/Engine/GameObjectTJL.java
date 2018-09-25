package com.Mini2D.Engine;

public class GameObjectTJL {
	ScreenTJL screen=new ScreenTJL();
	/**
	* @brief : Position of image
	*/
	void Position(int m,int n){
		screen.x=m;
		screen.y=n;
	}
	/**
	* @brief :Zoom ratio of existing image
	*/
	public void Scale(int scale) {
		
		screen.scale=scale;
	}
	/**
	* @brief :Save image name
	*/
	public void Name(char name) {
		screen.name=name;
		
	}
}                                                             
                                