package com.Mini2D.Engine;

public class Vector {
	public float x;
	public float y;
	public Vector() {
		x=0;
		y=0;
	}
	/**
	* @brief : 设定图片的x，y轴起始位置（左顶点）,然后显示
	*/
	public void Position(float x,float y) {
		this.x=x;
		this.y=y;
	}
		
}
