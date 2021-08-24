package research;
/*
 * Written by Alex Goslen 2017
 * */

import java.awt.Color;
import java.util.ArrayList;

import SimpleOpenNI.*;
import SimpleOpenNI.SimpleOpenNI;
import processing.core.PApplet;
import processing.core.PMatrix3D;
import processing.core.PVector;

public class ONIFileReading extends PApplet{
	SimpleOpenNI context;
	String fileName;
	
	private float zoomF =0.5f;
	private float rotX = radians(180);  // by default rotate the hole scene 180deg around the x-axis, 
	// the data from openni comes upside down
	private float rotY = radians(0);
	private boolean autoCalib=true;

	protected PVector      bodyCenter = new PVector();
	protected PVector      bodyDir = new PVector();
	private PVector      com = new PVector();                                   
	private PVector      com2d = new PVector();                                   
	private Color[] userClr = new Color[]{ new Color(255,0,0),
			new Color(0,255,0),
			new Color(0,0,255),
			new Color(255,255,0),
			new Color(255,0,255),
			new Color(0,255,255)
	};

//	private ArrayList<PImage> images;
	
	PVector head = new PVector();
	PVector leftHand = new PVector();
	PVector neck = new PVector();
	PVector rightHand = new PVector();
	PVector leftKnee = new PVector();
	PVector leftHip = new PVector();
	PVector rightKnee = new PVector();
	PVector rightHip = new PVector();
	PVector rightShoulder = new PVector();
	PVector leftShoulder = new PVector();
	PVector torso = new PVector();
	PVector leftElbow = new PVector();
	PVector rightElbow  = new PVector();
	PVector leftFoot = new PVector();
	PVector rightFoot  = new PVector();
	PVector direction = new PVector();

	public void setup(){
	  size(640,480);
	  fileName = "C:\\Users\\Robert\\Documents\\EmotionMapping\\Results\\Images 34172 2.oni";
	  context = new SimpleOpenNI(this, fileName);
	  System.out.println(fileName);
//	  if(SimpleOpenNI.deviceCount() == 0){
//		  System.out.println("device count is 0");
//		  context.openFileRecording(fileName);
//	  }
	  
	
	}
	
	
	public void draw(){
	  context.update();
	  image(context.depthImage(),0,0);
	  
	// draw the skeleton if it's available
			int[] userList = context.getUsers();
			for(int i=0;i<userList.length;i++) {
				if(context.isTrackingSkeleton(userList[i]))
					drawSkeleton(userList[i]);
		
		
				// draw the center of mass
				if(context.getCoM(userList[i],com)) {
					stroke(100,255,0);
					strokeWeight(1);
					beginShape(LINES);
					vertex(com.x - 15,com.y,com.z);
					vertex(com.x + 15,com.y,com.z);
					vertex(com.x,com.y - 15,com.z);
					vertex(com.x,com.y + 15,com.z);
					vertex(com.x,com.y,com.z - 15);
					vertex(com.x,com.y,com.z + 15);
					endShape();
		
					fill(0,255,100);
					text(Integer.toString(userList[i]),com.x,com.y,com.z);
				}     
			}
		  context.enableDepth();
	}
	 
	 
	 
	 public void drawSkeleton(int userId) {
			//skeleton  = new Skeleton(context, userId);
			strokeWeight(3);

			// to get the 3d joint data
			drawLimb(userId, SimpleOpenNI.SKEL_HEAD, SimpleOpenNI.SKEL_NECK);

			drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_LEFT_SHOULDER);
			drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_LEFT_ELBOW);
			drawLimb(userId, SimpleOpenNI.SKEL_LEFT_ELBOW, SimpleOpenNI.SKEL_LEFT_HAND);

			drawLimb(userId, SimpleOpenNI.SKEL_NECK, SimpleOpenNI.SKEL_RIGHT_SHOULDER);
			drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_RIGHT_ELBOW);
			drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_ELBOW, SimpleOpenNI.SKEL_RIGHT_HAND);

			drawLimb(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, SimpleOpenNI.SKEL_TORSO);
			drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, SimpleOpenNI.SKEL_TORSO);

			drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_LEFT_HIP);
			drawLimb(userId, SimpleOpenNI.SKEL_LEFT_HIP, SimpleOpenNI.SKEL_LEFT_KNEE);
			drawLimb(userId, SimpleOpenNI.SKEL_LEFT_KNEE, SimpleOpenNI.SKEL_LEFT_FOOT);

			drawLimb(userId, SimpleOpenNI.SKEL_TORSO, SimpleOpenNI.SKEL_RIGHT_HIP);
			drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_HIP, SimpleOpenNI.SKEL_RIGHT_KNEE);
			drawLimb(userId, SimpleOpenNI.SKEL_RIGHT_KNEE, SimpleOpenNI.SKEL_RIGHT_FOOT);  
			
			
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_HEAD, head);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_NECK, neck);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_SHOULDER, leftShoulder);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_SHOULDER, rightShoulder);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_ELBOW, leftElbow);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_ELBOW, rightElbow);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_HAND, leftHand);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_HAND, rightHand);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_TORSO, torso);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_HIP, leftHip);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_HIP, rightHip);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_KNEE, leftKnee);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_KNEE, rightKnee);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_LEFT_FOOT, leftFoot);
			context.getJointPositionSkeleton(userId, SimpleOpenNI.SKEL_RIGHT_FOOT, rightFoot);
			
			
			// draw body direction
			getBodyDirection(userId,bodyCenter,bodyDir);

			bodyDir.mult(200);  // 200mm length
			bodyDir.add(bodyCenter);

			stroke(255,200,200);
			line(bodyCenter.x,bodyCenter.y,bodyCenter.z,
					bodyDir.x ,bodyDir.y,bodyDir.z);

			strokeWeight(1);
		}
	 
	 public void drawLimb(int userId,int jointType1,int jointType2) {
			PVector jointPos1 = new PVector();
			PVector jointPos2 = new PVector();
			float  confidence;
			// draw the joint position
			confidence = context.getJointPositionSkeleton(userId,jointType1,jointPos1);
			confidence = context.getJointPositionSkeleton(userId,jointType2,jointPos2);
			stroke(255,0,0,confidence * 200 + 55);
			line(jointPos1.x,jointPos1.y,jointPos1.z,
					jointPos2.x,jointPos2.y,jointPos2.z);
			drawJointOrientation(userId,jointType1,jointPos1,50);
		}

		public void drawJointOrientation(int userId,int jointType,PVector pos,float length){
			// draw the joint orientation  
			PMatrix3D  orientation = new PMatrix3D();
			float confidence = context.getJointOrientationSkeleton(userId,jointType,orientation);
			if(confidence < 0.001f) {
				// nothing to draw, orientation data is useless
				return; }
			pushMatrix();
			translate(pos.x,pos.y,pos.z);
			// set the local coordsys
			applyMatrix(orientation);
			// coordsys lines are 100mm long
			// x - r
			stroke(255,0,0,confidence * 200 + 55);
			line(0,0,0,
					length,0,0);
			// y - g
			stroke(0,255,0,confidence * 200 + 55);
			line(0,0,0,
					0,length,0);
			// z - b    
			stroke(0,0,255,confidence * 200 + 55);
			line(0,0,0,
					0,0,length);
			popMatrix();
		}


		public void getBodyDirection(int userId,PVector centerPoint,PVector dir){
			PVector jointL = new PVector();
			PVector jointH = new PVector();
			PVector jointR = new PVector();
			float  confidence;

			// draw the joint position
			confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_LEFT_SHOULDER,jointL);
			confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_HEAD,jointH);
			confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_RIGHT_SHOULDER,jointR);

			// take the neck as the center point
			confidence = context.getJointPositionSkeleton(userId,SimpleOpenNI.SKEL_NECK,centerPoint);

			/*  // manually calc the centerPoint
			  PVector shoulderDist = PVector.sub(jointL,jointR);
			  centerPoint.set(PVector.mult(shoulderDist,.5));
			  centerPoint.add(jointR);
			 */

			PVector up = PVector.sub(jointH,centerPoint);
			PVector left = PVector.sub(jointR,centerPoint);

			dir.set(up.cross(left));
			dir.normalize();
		}	
}
