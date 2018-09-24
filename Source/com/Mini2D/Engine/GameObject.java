package com.Mini2D.Engine;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class GameObject extends JPanel{
	private int m,n,a=1,b=1;
	private String Image;
	public Layout layout;
	/// V1.0
	private static final long serialVersionUID = 1L;
	static List<GameObject> gameObjects = new ArrayList<GameObject>();
	/**
	* @brief : This function is called once per frame to render the component
	*/
	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0;i<gameObjects.size();i++) 
			gameObjects.get(i).paint(g);
			
		g.drawImage(LoadImage.load(Image), m, n, a, b,null);

	}
	
	/**
	* @brief : ����ͼƬ���֣���ʾͼƬ
	*/
	void PaintName(Graphics g,String name) {
		name=Image;
		paintComponent(g);
	}
	
	/**
	* @brief : Size(100,100)����ͼƬ��Ϊ100����Ϊ100,Ȼ����ʾ
	*/
	public void Size(Graphics g,int width,int height){
		a=a*width;
		b=b*height;
		paintComponent(g);
	}

	/**
	* @brief : �趨ͼƬ��x��y����ʼλ�ã��󶥵㣩,Ȼ����ʾ
	*/
	void Position(Graphics g,int x,int y){
		m=x;
		n=y;
		paintComponent(g);
	}
	
	/**
	* @brief : �����Ϸ����ֱ����ӵ�Screen�е�gameObject
	*/
	public static void addToScreen(GameObject gameObj) {
		if(gameObjects.size()==0) {
			gameObjects.add(gameObj);
			return;
		}
		int i=0;
		for(GameObject object : gameObjects){
			if(object.layout.getValue()>=gameObj.layout.getValue()) {
				gameObjects.add(i,gameObj);
				return;
			}
		} 
		i++;
		gameObjects.add(gameObj);
	}
}