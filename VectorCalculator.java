package research;
/*
 * Written by Alex Goslen 2017
 * */
import processing.core.PVector;

public class VectorCalculator {
	
	public VectorCalculator(){
		
	}
	// calculate the distance between any two points in 3D space and return it as a float
	public float distance3D(PVector point1, PVector point2) {
		float diff_x, diff_y, diff_z;    // to store differences along x, y and z axes
		double distance;                  // to store final distance value
		//System.out.println("vectors " + point1 +", " + point2);
		// calculate the difference between the two points
		diff_x = (float)point1.x - point2.x;
		diff_y = (float)point1.y - point2.y;
		diff_z = (float)point1.z - point2.z; 
		//System.out.println("differences " +diff_x  + diff_y + diff_z);
		// calculate the Euclidean distance between the two points
		distance = Math.sqrt(Math.pow(diff_x,2)+Math.pow(diff_y,2)+Math.pow(diff_z,2));
		return (float)distance;  // return the distance as a float
	}	
	
	
//	public double calcAngleBetweenVectors(PVector joint1, PVector joint2) {
//		double theta;
//		theta = Math.acos((joint1.dot(joint2))/(lengthOfVector(joint1)*lengthOfVector(joint2))); 
//		theta = (180*theta)/Math.PI;
//		System.out.println("theta = " + theta);
//		
//		return theta;
//	}
	
	public double lengthOfVector(PVector v) {
		double length;
		length = Math.sqrt(v.x*v.x + v.y*v.y + v.z*v.z);
		
		return length;
	}
	
	public double getAngle(PVector p1, PVector p2, PVector vertex){
		float distanceP1V = distance3D(p1, vertex);
		float distanceP2V = distance3D(p2, vertex);
		float distanceP1P2 = distance3D(p1, p2);
		//System.out.println("distances: " + distanceP1V + ", " + distanceP2V + ", " + distanceP1P2);
		double angle = Math.acos((Math.pow(distanceP1V, 2) + 
				Math.pow(distanceP2V, 2) - Math.pow(distanceP1P2, 2))/(2*distanceP1V*distanceP2V));
		//System.out.println("Angle");
		angle = (180*angle)/Math.PI;
 		
		return angle;
	}

	

}
