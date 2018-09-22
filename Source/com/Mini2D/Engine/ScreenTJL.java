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
	* @brief : Zoon(0.5,0.5)����ͼƬ������һ�룬����,Ȼ����ʾ
	*/
	public void Zoom(Graphics g,int i,int j){
		a=a*i;
		b=b*j;
		paintComponent(g);
	}

	/**
	* @brief : �ı�ͼƬ��x��y����ʼλ��,�󶥵�,Ȼ����ʾ
	*/
	void Position(Graphics g,int m,int n){
		x=m;
		y=n;
		paintComponent(g);
	}
}
