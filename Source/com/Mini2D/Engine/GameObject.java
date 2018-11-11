package com.Mini2D.Engine;

import java.awt.Graphics;
import java.awt.Image;




public class GameObject extends Component implements PanitcControl,PaintMove{
	protected boolean visible = true;
	private Vector2 position = new Vector2();
	private int width;
	private int height;
	Vector2 targetPosition;
	Image image = null;
	//Collision collider = null;
	Button button = null;
	Sprite sprite = null;
	Animator animator = null;
	/*
	 * ��Image�Ĺ��캯��
	 */
	public GameObject(Image image,float x,float y,int width,int height,Tag tag ,Layout layout) {
		this.image = image;
		position.x = x;
		position.y = y;
		this.width = width;
		this.height = height;
		this.tag = tag;
		this.layout = layout;
		keyValue = Setting.ObjectKey++;
		Screen.addToScreen(this);
	}

	public GameObject(Image image,Vector2 position,int width,int height,Tag tag,Layout layout) {
		this(image,position.x, position.y,width,height, tag,layout);
	}
	public GameObject(Image image,Vector2 position,int width,int height,Layout layout) {
		this(image,position.x, position.y,width,height, Tag.Default,layout);
	}
	
	public GameObject(Image image,float x,float y,int width,int height) {
		this(image,x, y,width,height, Tag.Default,Layout.Default);
	}
	
	public GameObject(Image image,Vector2 position,int width,int height) {
		this(image,position.x, position.y,width,height, Tag.Default,Layout.Default);
	}
	/*
	 * ����Image�Ĺ��캯��
	 */
	public GameObject(float x,float y,int width,int height,Tag tag ,Layout layout) {
		position.x = x;
		position.y = y;
		this.width = width;
		this.height = height;
		this.tag = tag;
		this.layout = layout;
		keyValue = Setting.ObjectKey++;
		Screen.addToScreen(this);
	}
	public GameObject(Vector2 position,int width,int height,Tag tag,Layout layout) {
		this(position.x, position.y,width,height, tag,layout);
	}
	public GameObject(Vector2 position,int width,int height,Layout layout) {
		this(position.x, position.y,width,height, Tag.Default,layout);
	}
	public GameObject(float x,float y,int width,int height) {
		this(x, y,width,height, Tag.Default,Layout.Default);
	}
	
	public GameObject(Vector2 position,int width,int height) {
		this(position.x, position.y,width,height, Tag.Default,Layout.Default);
	}
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(image, (int)(position.x-width/2.0f), (int)(position.y-height/2.0f), width, height,null);
		}
	}
	//public void addCollider(Collision collider) {
	//	this.collider = collider;
	//	this.collider.tag =tag;
	//}
	public void addButton(Button button) {
		this.button = button;
	}
	public void addSprite(Sprite sprite) {
		this.sprite = sprite;
		image = sprite.image;
	}
	public void addAnimator(Animator animator) {
		this.animator = animator;
	}
	@Override
	public void move(float deltaX,float deltaY) {
		position.x+=deltaX;
		position.y+=deltaY;
	//	if(collider!=null) {
	//		collider.move();
	//	}
	}
	@Override
	public void move(Vector2 vec) {
		move(vec.x,vec.y);
	}
	@Override
	public  void moveTo(Vector2 position,float speed) {
		targetPosition = position;
		Vector2 countVec2 = new Vector2(this.position.sub(targetPosition));
		if(targetPosition != this.position)
			move(countVec2.direction().x*speed,countVec2.direction().y*speed);
	}
	@Override
	public  void moveAdd(Vector2 distance,float speed) {
		targetPosition = position.add(distance);
		Vector2 countVec2 = new Vector2(this.position.sub(targetPosition));
		if(targetPosition != this.position)
			move(countVec2.direction().x*speed,countVec2.direction().y*speed);
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public void setPosition(float x,float y) {
		this.position.x = x;
		this.position.y = y;
	}
	public void setTag(Tag tag) {
		this.tag = tag;
	//	if(collider!=null) {
	//		collider.tag =tag;
	//	}
	}
	public void setImage(Image changeImage) {
		image = changeImage;
	}
	public Layout getLayout() {
		return layout;
	}
	public Tag getTag() {
		return tag;
	}
	public Vector2 getPosition() {
		return position;
	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getkeyValue() {
		return keyValue;
	}
	//public Collision getCollision() {
	//	return collider;
	//}
	public Image getImage() {
		return image;
	}
	public Button getButton() {
		return button;
	}
	public Animator getAnimator() {
		return animator;
	}
	public Sprite getSprite() {
		return sprite;
	}
	@Override
	public void Destroy() {
		if(visible) {
			Screen.deleteToScreen(keyValue);
			visible = false;
	//		if(collider!=null) {
	//			collider.Destroy();
	//		}
			if(animator!=null) {
				animator.Destroy();
			}
			if(button!=null) {
				button.Destroy();
			}
		}
	}
}