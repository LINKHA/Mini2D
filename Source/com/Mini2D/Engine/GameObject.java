package com.Mini2D.Engine;

import java.awt.Graphics;
import java.awt.Image;



public class GameObject extends Component implements PanitcControl{
	protected boolean visible = true;
	private Vector position=new Vector();
	private int width;
	private int height;
	private int scaleX = 1;
	private int scaleY = 1;
	String image=null;


	/**
	* @brief : ����ͼƬ���֣���ʾͼƬ
	*/
	public void PaintName(String name) {
		image = name;
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
	public void Position(float x,float y){
		position.x=x;
		position.y=y;
	}
	
	public GameObject(String image,float x,float y,int width,int height,Layout layout) {
		this.image=image;
		position.x=x;
		position.y=y;
		this.width=width;
		this.height=height;
		this.layout=layout;
		Screen.addToScreen(this);
	}
	
	public GameObject(String image,Vector position,int width,int height,Layout layout) {
		this(image,position.x,position.y,width,height,layout);
	}
	
	public GameObject(String image,Vector position,int width,int height) {
		this(image,position.x,position.y,width,height,Layout.Default);
	}
	
	public GameObject(float x,float y,int width,int height,Layout layout) {
		position.x=x;
		position.y=y;
		this.width=width;
		this.height=height;
		this.layout=layout;
		Screen.addToScreen(this);
	}
	
	public GameObject(Vector position,int width,int height,Layout layout) {
		this(position.x,position.y,width,height,layout);
	}
	
	public GameObject(Vector position,int width,int height) {
		this(position.x,position.y,width,height,Layout.Default);
	}
	
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(LoadImage.load(image), (int)position.x, (int)position.y, width*scaleX, height*scaleY,null);
		}
	}
	
	public Layout getLayout() {
		return layout;
	}
}