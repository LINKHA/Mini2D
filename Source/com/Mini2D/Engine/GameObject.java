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
	* @brief : 输入图片名字，显示图片
	*/
	void PaintName(Graphics g,String name) {
		name=Image;
		paintComponent(g);
	}
	
	/**
	* @brief : Size(100,100)就是图片宽为100，高为100,然后显示
	*/
	public void Size(Graphics g,int width,int height){
		a=a*width;
		b=b*height;
		paintComponent(g);
	}

	/**
	* @brief : 设定图片的x，y轴起始位置（左顶点）,然后显示
	*/
	void Position(Graphics g,int x,int y){
		m=x;
		n=y;
		paintComponent(g);
	}
	
	/**
	* @brief : 添加游戏对象直接添加到Screen中的gameObject
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