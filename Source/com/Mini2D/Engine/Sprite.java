package com.Mini2D.Engine;

import java.awt.Image;

public class Sprite extends Component{
	public Image image;
	GameObject gameObject;
	
	public  Sprite(Image image,GameObject gameObject) {
		this.image =image;
		this.gameObject = gameObject;
	}
	public  Sprite(String imageName,GameObject gameObject) {
		image = LoadImage.load(imageName);
		this.gameObject = gameObject;
	}
	@Override
	public void Destroy() {
		// TODO Auto-generated method stub
		
	}
}