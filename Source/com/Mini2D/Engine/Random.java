package com.Mini2D.Engine;

public class Random {
	

	/////////////////////////////////////////////////////////////////////////////////////////////
	//��¶��Ӧ�ò�Ľӿ�
	//��:Random
	/////////////////////////////////////////////////////////////////////////////////////////////
		public static int Rang(int min,int max) {

			return (int)(min+Math.random()*max);
		}
		public static double Rang(double min,double max) {
			return (double)(min+Math.random()*max);
		}
		public static float Rang(float min,float max) {
			return (float)(min+Math.random()*max);
		}

	


}
