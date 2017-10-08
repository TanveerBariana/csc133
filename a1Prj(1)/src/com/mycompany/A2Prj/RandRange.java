package com.mycompany.A2Prj;
import java.util.Random;
//helper class contructed to generate rand values between min and max inclusive
public class RandRange {
	static Random r = new Random();
	public static int rand(int min, int max){	
		return r.nextInt((max-min)+1) + min;
	}
	public static double rand(double min, double max){
		double ra = min + (max - min) * r.nextDouble();
		return ra;
	}
}
