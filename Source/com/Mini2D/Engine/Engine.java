package com.Mini2D.Engine;

public class Engine extends MiniObject{
	public Engine() {
		
	}
	/**
	* @brief : Registrat subsystem graphics and IO
	*/
	public void RegistratSubSystem() {
		//IO.Registrat();
		//Graphics.Registrat();
	}
	/**
	* @brief : Engine init if fail return false
	*/
	public boolean Init() {
		return false;
	}
	/**
	* @brief : This method runs once per frame
	*/
	public boolean RunFrame() {
		/////////////////////////////////////////////////////////////////////////////////////////////
		////Press the esc button to exit the loop
		//
		//if(IO.GetButtonDown(Input.ESC))
		//	return false;
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		////Graphics system run in frame
		//
		////Clear screen all image
		//Graphics.Clear();
		//
		////Redraw the image and update the interaction based on the information
		//Graphics.Draw();
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		return true;
	}
	/**
	* @brief : Engine Exit if fail return false
	*/
	public boolean Exit() {
		return false;
		
	}
}
