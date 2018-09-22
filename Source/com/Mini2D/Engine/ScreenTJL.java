package com.Mini2D.Engine;



import java.awt.Graphics;

import javax.swing.JPanel;


public class ScreenTJL extends JPanel{
	private int x,y,a,b=100;

	/// V1.0
	private static final long serialVersionUID = 1L;
	/**
	* @brief : This function is called once per frame to render the component
	*/
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(LoadImage.load("Assets/t.png"), x, y, a, b,null);

	}
	/**
	* @brief : Zoon(0.5,0.5)就是图片缩放至一半，比例,然后显示
	*/
	public void Zoom(Graphics g,int i,int j){
		a=a*i;
		b=b*j;
		paintComponent(g);
	}

	/**
	* @brief : 改变图片的x，y轴起始位置,左顶点,然后显示
	*/
	void Position(Graphics g,int m,int n){
		x=m;
		y=n;
		paintComponent(g);
	}
}
