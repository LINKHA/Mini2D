package com.Mini2D.Engine;

import javax.swing.JFrame;

public class Engine extends JFrame {
	/// V1.0
	private static final long serialVersionUID = 1L;

	public Screen screen;
	
	public Engine() {
		screen = new Screen();
		add(screen);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);	
		addKeyListener(Input.GetInstance());
		addMouseListener(Input.GetInstance());	
		setLocation((int)Setting.WindowRect.x, (int)Setting.WindowRect.y);
		setSize((int)Setting.WindowSize.x,(int)Setting.WindowSize.y);
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