package com.Mini2D.Engine;

import java.awt.Graphics;


public class GameObject{
	protected boolean visible = true;
	private int x;
	private int y;
	private int width;
	private int height;
	private int scaleX = 1;
	private int scaleY = 1;
	private String Image;
	public Layout layout;

	/**
	* @brief : 输入图片名字，显示图片
	*/
	public void PaintName(String name) {
		Image = name;
	}
	
	/**
	* @brief : Size(100,100)就是图片宽为100，高为100,然后显示
	*/
	public void Size(int width,int height){
		this.width=width;
		this.height=height;
	}
	/**
	* @brief : Set transform scale
	*/
	public void Scale(int scaleX,int scaleY){
		this.scaleX = scaleX;
		this.scaleY = scaleY;
	}
	/**
	* @brief : 设定图片的x，y轴起始位置（左顶点）,然后显示
	*/
	public void Position(int x,int y){
		this.x=x;
		this.y=y;
	}
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(LoadImage.load(Image), x, y, width*scaleX, height*scaleY,null);
		}
	}
}