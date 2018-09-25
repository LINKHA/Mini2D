package com.Mini2D.Engine;

import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JPanel;


public class ScreenTJL extends JPanel{
	int scale;
	int x;
	int y;
	private int height;
	private int width;
	private String image;
	char name;
	
	///singleton instance
	private static ScreenTJL instance;
	/// V1.0
	private static final long serialVersionUID = 1L;
	//private static final Graphics Graphics = null;
	
	/**
	* @brief : Constructed
	*/
	ScreenTJL() {
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
	public static ScreenTJL GetInstance() {
		if(instance==null) {
			instance = new ScreenTJL();
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
	* @brief : change paintSizeplace
	*/
	void Position(int m,int n){
		x=m;
		y=n;
	}
	/**
	* @brief : Store GameObject in List containe
	*/
	void Gmanagemen(int m,int n,int scale,char name){	
		GameObjectTJL obj1 = new GameObjectTJL();
		obj1.Position(m,n);		
		obj1.Scale(scale);
		obj1.Name(name);
		ArrayList<GameObjectTJL> list = new ArrayList<GameObjectTJL>();
		list.add(obj1);
		}

}
