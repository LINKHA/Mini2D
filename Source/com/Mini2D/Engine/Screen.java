package com.Mini2D.Engine;

import java.awt.Graphics;

import javax.swing.JPanel;


public class Screen extends JPanel{
	private int scale=1;
	private int x,y;
	private int height,width;
	private String Image="Assets/t.png";
	/// V1.0
	private static final long serialVersionUID = 1L;
	//private static final Graphics Graphics = null;
	/**
	* @brief : This function is called once per frame to render the component
	*/
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		x=200;y=200;height=50;width=50;
		g.drawImage(LoadImage.load(Image), x, y, width*scale, height*scale,null);
		x=100;y=100;height=50;width=50;
		g.drawImage(LoadImage.load(Image), x, y, width*scale, height*scale,null);
		
	}
	public void Scale(int scale) {
		this.scale=scale;
	}
	public void PaintSizePlace(String Image,int x,int y,int width,int height) {
		this.Image=Image;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		//paintComponent(Graphics);
	}
}
