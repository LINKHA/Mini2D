package com.Mini2D.Engine;

import java.util.ArrayList;
import java.util.List;


public class UISystem extends FrameSystem{
	private static UISystem instance;
	List<UIComponent> compontents = new ArrayList<UIComponent>() ;
	private UISystem() {}
	public void addButton(UIComponent compontent) {
		compontents.add(compontent);
	}
	public void deleteButton(int keyValue) {
		for(UIComponent checkValue :  compontents) {
			if(checkValue.keyValue == keyValue) {
				compontents.remove(checkValue);
				return;
			}
		}
	}
	//检查鼠标是否在控件按下
	public List<UIComponent> pressedCompontents() {
		 List<UIComponent> comp = new ArrayList<UIComponent>();
		 if(compontents.size()==0) {
			 return comp;
		 }
			
		 for(UIComponent compontent :compontents ) {

			 if(compontent.isDown == false /*&& isHitComfpant(compontent)*/) {
				 compontent.isDown = true;
				 comp.add(compontent);
			 }
		 }
		 return comp;
	}
	
	public void performPressedCompontents() {
		if(compontents.size()==0) 
			return;

		for(UIComponent comp: pressedCompontents()) {

			comp.mouseBegain();
		}
	}

	public boolean isHitCompant(UIComponent comp) {
		Vector2 mousePosition = Input.getMouseLocation();
		return (int)comp.location.x-(int)comp.width/2<=(int)mousePosition.x && 
				(int)comp.location.x+(int)comp.width/2>=(int)mousePosition.x &&
				(int)comp.location.y-(int)comp.height/2<=(int)mousePosition.y &&
				(int)comp.location.y+(int)comp.height/2>=(int)mousePosition.y ;
	}

	//检查鼠标是否在控件弹起
		public List<UIComponent> releasedCompontents() {
			 List<UIComponent> comp = new ArrayList<UIComponent>();
			 if(compontents.size()==0) {
				 return comp;
			 }
			 for(UIComponent compontent :compontents ) {
				 if(compontent.isDown == true) {
					 compontent.isDown = false;
					 comp.add(compontent);
				 }
			 }
			 return comp;
		}
		
		public void performReleasedCompontents() {
			if(compontents.size()==0) 
				return;
			for(UIComponent comp: releasedCompontents()) {
				comp.mouseRelease();
			}
		}


	public static UISystem getSystem() {
		if(instance==null) {
			instance = new UISystem();
		}
		return instance;
	}

	public void mousePressed() {	

		performPressedCompontents();
	}

	public void mouseReleased() {
		performReleasedCompontents();
	}
}
