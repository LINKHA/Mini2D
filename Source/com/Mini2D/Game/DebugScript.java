package com.Mini2D.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.Mini2D.Engine.GameObject;
import com.Mini2D.Engine.Screen;
import com.Mini2D.Engine.ScriptSuper;
import com.Mini2D.Engine.Vector2;

public class DebugScript extends ScriptSuper{	
	float x1=500,y1=500;
	int w1=100,h1=100;
	
	float x2=100,y2 =100;
	int w2=100,h2=100;
	
	GameObject obj1;
	GameObject obj2;
	
	String name1="Assets/t.png";
	String name2="Assets/t2.png";
	Vector2 Vec1 = new Vector2(500,500);
	Vector2 Vec2 = new Vector2(100,100);
	
	static DebugScript instance;
	static DebugScript example;
	
	public static DebugScript GetInstance() {
		if(instance == null)
			instance = new DebugScript();
		return instance;
	}
	public static DebugScript GetExample() {
		if(example == null)
			example = new DebugScript();
		return example;
	}
	

	
	public void Start() {
/*		obj1.setPaintName("Assets/t.png");
		obj1.setPosition(x1, y1);
		obj1.Size(w1, h1);
		obj1.Scale(2, 2);
		obj1.GameObject("Assets/t.png",new Vector2(500,500),100,100);
		obj2.GameObject("Assets/t.png",new Vector2(100,100),100,100);
		obj2.setPaintName("Assets/t2.png");
		obj2.setPosition(x2, y2);
		obj2.Size(w2, h2);
		obj2.Scale(2, 2);*/
		
		obj1 = new GameObject(name1, Vec1, w1, h1);
		obj2 = new GameObject(name2, Vec2, w2, h2);
	} 
	public DebugScript(){
		Screen.GetInstance();
		Screen.addToScreen(obj1);
		Screen.GetInstance();
		Screen.addToScreen(obj2);
	}
	public void Update() {

		obj1.setPosition(x1, y1);
		obj1.Size(w1, h1);
		obj2.setPosition(x2, y2);
		obj2.Size(w2, h2);
	}
	
	public void ButtonDown(KeyEvent e) {
		if(e.getKeyChar()=='w')
			y1-=3;
		if(e.getKeyChar()=='s')
			y1+=3;
		if(e.getKeyChar()=='d')
			x1+=3;
		if(e.getKeyChar()=='a')
			x1-=3;
		if(e.getKeyCode()==KeyEvent.VK_UP)
			y2-=3;
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			y2+=3;
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			x2-=3;
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			x2+=3;
		if(e.getKeyChar()=='r'){
			w1+=3;
			h1+=3;
		}
			
		if(e.getKeyChar()=='f'){
			w1-=3;
			h1-=3;
		}
			
		
	}
	public void Button1Down(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
			System.out.println("×ó¼ü");
		else if(e.getButton()==MouseEvent.BUTTON3)
			System.out.println("ÓÒ¼ü");
			
	}
	@Override
	public void Init() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void RunLoop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Destruction() {
		// TODO Auto-generated method stub
		System.out.print("....");
	}
	
}
