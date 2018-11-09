package com.Mini2D.Engine;

public abstract class UIComponent {
	public Vector2 location;
	public int width;
	public int height;
	public boolean isDown = false;
	/*
	 * ������ؼ�ʱ���ô˷���
	 * ˲ʱ����
	 */
	public abstract void mouseBegain() ;
	/*
	 * ������ؼ�ʱ���ô˷���
	 * ��ʱ����
	 */
	public abstract void mouseOn() ;
	/*
	 * ����ͷ�ʱ���ô˷���
	 * ˲ʱ����
	 */
	public abstract void mouseRelease() ;
}
