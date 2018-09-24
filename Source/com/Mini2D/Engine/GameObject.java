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
	* @brief : ����ͼƬ���֣���ʾͼƬ
	*/
	void PaintName(Graphics g,String name) {
		name=Image;
		//paintComponent(g);
	}
	
	/**
	* @brief : Size(100,100)����ͼƬ��Ϊ100����Ϊ100,Ȼ����ʾ
	*/
	public void Size(Graphics g,int width,int height){
		a=a*width;
		b=b*height;
		//paintComponent(g);
	}

	/**
	* @brief : �趨ͼƬ��x��y����ʼλ�ã��󶥵㣩,Ȼ����ʾ
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