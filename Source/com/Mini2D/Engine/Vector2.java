package com.Mini2D.Engine;

public class Vector2 {
	public float x;
	public float y;
	public Vector2() {
		x=0;
		y=0;
	}
	/**
	* @brief : �趨ͼƬ��x��y����ʼλ�ã��󶥵㣩,Ȼ����ʾ
	*/
	public Vector2(float x,float y) {
		this.x=x;
		this.y=y;
	}
	public Vector2(Vector2 vec) {
		this.x=vec.x;
		this.y=vec.y;
	}
	public Vector2 add(Vector2 vec) {
		this.x+=vec.x;
		this.x+=vec.x;
		return this;
	}
	public Vector2 sub(Vector2 vec) {
		this.x-=vec.x;
		this.x-=vec.x;
		return this;
	}
	/*�����䵥λ����*/
	public Vector2 direction() {
		double num=Math.sqrt(x*x+y*y);
		return new Vector2((float)(x/num),(float)(y/num));
	}
	public static Vector2 zero() {
		return new Vector2();
	}
}
