package com.Mini2D.Engine;


public class Setting {
	public static int ObjectKey;
	/*
	 * �û�����
	 * ��ϵͳ���н�����Ϣ
	 */
	//��ʱ���ð�
	public static String ScriptPackName = "com.Mini2D.Game"; 
	//���ô���ê��
	public static Vector2 WindowRect = new Vector2(Vector2.zero());
	//���ô��ڴ�С
	public static Vector2 WindowSize = new Vector2(ScreenSize.SIZE);
	//���ô��ڶ�����ť�Ƿ�ȥ��
	public static boolean WIndwUndecorated = true;
	//ϵͳÿ������֡��(0,1000)
	public static int FPS = 100;
}
