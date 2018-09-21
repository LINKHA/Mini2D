package com.Mini2D.Engine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class Screen extends JPanel{

	/// V1.0
	private static final long serialVersionUID = 1L;
	/**
	* @brief : This function is called once per frame to render the component
	*/
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(LoadImage.load("Assets/t.png"), 100, 100, 100, 100,null);

	}
}
