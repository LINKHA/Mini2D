package com.Mini2D.Engine;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class DebugScript {
	GameObject obj1 = new GameObject();
	GameObject obj2 = new GameObject();
	
	int x1=500,y1=500;
	int w1=100,h1=100;
	
	int x2=100,y2 =100;
	int w2=100,h2=100;
	
	public DebugScript(){
		Screen.GetInstance().addToScreen(obj1);
		Screen.GetInstance().addToScreen(obj2);
	}
	

	static DebugScript instance;
	
	public static DebugScript GetInstance() {
		if(instance == null)
			instance = new DebugScript();
		return instance;
	}
	
	public void Start() {
		obj1.PaintName("Assets/t.png");
		obj1.Position(x1, y1);
		obj1.Size(w1, h1);
		obj1.Scale(2, 2);
		
		obj2.PaintName("Assets/t2.png");
		obj2.Position(x2, y2);
		obj2.Size(w2, h2);
		obj2.Scale(2, 2);
	} 
	public void Update() {

		obj1.Position(x1, y1);

		obj2.Position(x2, y2);
		
	}
	
	void ButtonDown(KeyEvent e) {
		if(e.getKeyChar()=='w')
			y1-=3;
		else if(e.getKeyChar()=='s')
			y1+=3;
		else if(e.getKeyChar()=='d')
			x1+=3;
		else if(e.getKeyChar()=='a')
			x1-=3;
		else if(e.getKeyCode()==KeyEvent.VK_UP)
			y2-=3;
		else if(e.getKeyCode()==KeyEvent.VK_DOWN)
			y2+=3;
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
			x2-=3;
		else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			x2+=3;
	}
}
