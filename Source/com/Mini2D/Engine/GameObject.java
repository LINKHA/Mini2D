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
	* @brief : ����ͼƬ���֣���ʾͼƬ
	*/
	public void PaintName(String name) {
		Image = name;
	}
	
	/**
	* @brief : Size(100,100)����ͼƬ��Ϊ100����Ϊ100,Ȼ����ʾ
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
	* @brief : �趨ͼƬ��x��y����ʼλ�ã��󶥵㣩,Ȼ����ʾ
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