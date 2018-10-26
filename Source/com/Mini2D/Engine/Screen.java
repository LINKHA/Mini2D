package com.Mini2D.Engine;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
	static List<GameObject> gameObjects = new ArrayList<GameObject>();
	
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
		for(int i=0;i<gameObjects.size();i++) 
			gameObjects.get(i).paint(g);
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
	/**
	* @brief : 添加游戏对象直接添加到Screen中的gameObject
	*/
	public static void addToScreen(GameObject gameObj) {
		/*if(gameObjects.size()==0) {
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
		i++;*/
		gameObjects.add(gameObj);
	}
	
	public static void deleteToScerrn(int keyValue) {
		for(Component component : gameObjects) {
			if(keyValue==component.keyValue) {
				gameObjects.remove(component);
				return;
			}
		}
	}
}
	