package com.Mini2D.Engine;

import javax.swing.JFrame;


public class Engine extends JFrame {
	/// V1.0
	private static final long serialVersionUID = 1L;
	///Key input
	Input input;
	///
	DebugScript script;
	public Engine() {
		script = new DebugScript();
		add(Screen.GetInstance());
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
		script.Start();
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
		script.Update();
		
		
		//Graphics system run in frame
		Screen.GetInstance().repaint();
		
		return true;
	}
	/**
	* @brief : Engine Exit if fail return false
	*/
	public boolean Exit() {
		return true;
		
	}
}
