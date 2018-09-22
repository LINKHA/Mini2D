package com.Mini2D.Engine;

import java.awt.Graphics;

import javax.swing.JPanel;


public class Screen extends JPanel{
	private int scale;
	private int x;
	private int y;
	private int height;
	private int width;
	private String image;
	
	///singleton instance
	private static Screen instance;
	/// V1.0
	private static final long serialVersionUID = 1L;
	//private static final Graphics Graphics = null;
	
	/**
	* @brief : Constructed
	*/
	private Screen() {
		scale = 1;
		x = 100;
		y = 100;
		width = 100;
		height = 100;
		image = "Assets/t.png";
	}
	/**
	* @brief : Get instance ,If instance not create,create it.
	*/
	public static Screen GetInstance() {
		if(instance==null) {
			instance = new Screen();
		}
		return instance;
	}
	/**
	* @brief : This function is called once per frame to render the component
	*/
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(LoadImage.load(image), x, y, width*scale, height*scale,null);
		g.drawImage(LoadImage.load(image), x+100, y+100, width*scale, height*scale,null);
		
	}
	public void Scale(int scale) {
		this.scale=scale;
	}
	public void PaintSizePlace(String image,int x,int y,int width,int height) {
		this.image=image;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}
	/**
	* @brief : 改变图片的x，y轴起始位置,左顶点,然后显示
	*/
	void Position(int m,int n){
		x=m;
		y=n;
	}
}
