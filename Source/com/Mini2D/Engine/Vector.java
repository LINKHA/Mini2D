package com.Mini2D.Engine;

public class Vector {
	public float x;
	public float y;
	public Vector() {
		x=0;
		y=0;
	}
	/**
	* @brief : �趨ͼƬ��x��y����ʼλ�ã��󶥵㣩,Ȼ����ʾ
	*/
	public Vector(float x,float y) {
		this.x=x;
		this.y=y;
	}
	public Vector(Vector vec) {
		this.x=vec.x;
		this.y=vec.y;
	}
	public Vector add(Vector vec) {
		this.x+=vec.x;
		this.x+=vec.x;
		return this;
	}
	public Vector sub(Vector vec) {
		this.x-=vec.x;
		this.x-=vec.x;
		return this;
	}
}
