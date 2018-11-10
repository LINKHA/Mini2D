package com.Mini2D.Engine;

import java.awt.Toolkit;
public class ScreenSize {
	/*
	 * ��Ļ����ê��
	 */
	public static final Vector2 RECT_LU = Vector2.zero();
	/*
	 * ��Ļ����ê��
	 */
	public static final Vector2 RECT_LD = new Vector2(0,Toolkit.getDefaultToolkit().getScreenSize().height);
	/*
	 * ��Ļ����ê��
	 */
	public static final Vector2 RECT_RU = new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width,0);
	/*
	 * ��Ļ����ê��
	 */
	public static final Vector2 RECT_RD = new Vector2(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height);
	/*
	 * ��Ļ��
	 */
	public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	/*
	 * ��Ļ��
	 */
	public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	/*
	 * ��Ļ�ߴ�
	 */
	public static final Vector2 SIZE = new Vector2(WIDTH,HEIGHT);
}
