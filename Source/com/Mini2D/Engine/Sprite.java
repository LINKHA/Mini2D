package com.Mini2D.Engine;

import java.awt.Image;

public class Sprite extends Component{
	String imageName;
	GameObject gameObject;
	public Sprite(Image image,GameObject gameObject) {
		image=LoadImage.load(imageName);
		this.gameObject=gameObject;
	}
	public Sprite(String imageName,GameObject gameObject) {
		this.imageName=imageName;
		this.gameObject=gameObject;
	}
	public void Destroy() {
		
	}
}
