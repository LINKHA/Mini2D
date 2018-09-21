package com.Mini2D.Engine;

import javax.swing.JFrame;


public class Engine extends JFrame {
	/// V1.0
	private static final long serialVersionUID = 1L;
	///Graphics screen
	Screen screen;
	///Key input
	Input input;
	public Engine() {
		screen = new Screen();
		
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);	
		addKeyListener(input);	
		setLocation((int)0, (int)0);
		setSize((int)1000,(int)1000);
		//Set whether the top button of the window is removed
		setUndecorated(true);
		//Set whether the VIsible is displayed
		setVisible(true);
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
		return true;
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
		
		
		
		//Graphics system run in frame
		screen.repaint();
		
		return true;
	}
	/**
	* @brief : Engine Exit if fail return false
	*/
	public boolean Exit() {
		return true;
		
	}
}
