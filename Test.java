
package research;
/*
 * Written by Alex Goslen 2017
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import processing.core.PVector;

public class Test {

	public Skeleton skel;
	private static PVector p;
	private static EmotionDetector ed;
	private static String [] emotions = {"Anger", "Disgust", "Fear", "Sadness", "Happiness", "Surprise", "No Emotion"};

	public Test(){
		skel  = new Skeleton();
		p = new PVector();
		ed = new EmotionDetector();
		
	}
	public void testingSkeleton(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		skel = new Skeleton();
		p = new PVector();
		ed = new EmotionDetector();
		
		VectorCalculator vc = new VectorCalculator();
		PVector p1 = new PVector();
		p1.x = (float) 0.0;
		p1.y = (float) 0.0;
		p1.z = (float) 0.0;
		PVector p2 = new PVector();
		p2.x = (float) 1.0;
		p2.y = (float) 0.0;
		p2.z = (float) 0.0;
		PVector p3 = new PVector();
		p3.x = (float) 0.0;
		p3.y = (float) 1.0;
		p3.z = (float) 0.0;
		System.out.println(vc.distance3D(p1,p2));
		System.out.println(vc.getAngle(p2, p1, p3));
		
		

	}	
}


