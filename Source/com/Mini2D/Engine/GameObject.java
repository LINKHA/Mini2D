package com.Mini2D.Engine;

import java.awt.Graphics;


public class GameObject{
	protected boolean visible = true;
	private int m,n,a=1,b=1;
	private String Image;
	public Layout layout;
	/// V1.0
	//private static final long serialVersionUID = 1L;
	
	
	/**
	* @brief : 输入图片名字，显示图片
	*/
	void PaintName(Graphics g,String name) {
		name=Image;
		//paintComponent(g);
	}
	
	/**
	* @brief : Size(100,100)就是图片宽为100，高为100,然后显示
	*/
	public void Size(Graphics g,int width,int height){
		a=a*width;
		b=b*height;
		//paintComponent(g);
	}

	/**
	* @brief : 设定图片的x，y轴起始位置（左顶点）,然后显示
	*/
	void Position(Graphics g,int x,int y){
		m=x;
		n=y;
		//paintComponent(g);
	}
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(LoadImage.load(Image), m, n, a, b,null);
		}
	}
}