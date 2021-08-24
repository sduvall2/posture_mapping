package research;
/*
 * Written by Alex Goslen 2017
 * */
import java.io.IOException;

import processing.core.PVector;

public class Detector {
	private VectorCalculator calc;
	//private boolean rightHandBite;
	//private boolean leftHandBite;
	private int numRocks;
	private long lastTimeRocked;
	private Skeleton skel;
	//private SkeletonProcessing skpr;

	public Detector() {
		calc = new VectorCalculator();
		skel = new Skeleton();
		//rightHandBite = false;
		//leftHandBite = false;
		numRocks = 0;
		lastTimeRocked = 0;
		//skpr = new SkeletonProcessing();
	}

	public boolean detectBitingLeft(PVector head, PVector neck, PVector leftHand, PVector leftElbow) {
		head.y -= (head.y - neck.y)*.5;
		leftElbow.x -= (leftElbow.x - leftHand.x)*.5;
		float leftHandToMouthDistance = calc.distance3D(head, leftHand);
		float leftElbowToMouthDistance = calc.distance3D(head, leftElbow);
		//System.out.println("The distance is: " + handToMouthDistance);
		if (leftHandToMouthDistance <= 150 || leftElbowToMouthDistance <= 150) {
			//			System.out.println("The user touched their mouth with their left hand, the distance is " 
			//					+ leftHandToMouthDistance);
			//System.out.println("I'm biting my hand " + displayTime);
			//playSound("../../Banana_slap_sound.mp3");
			//			bw.write("Hand Biting, " + displayTime);
			//			bw.newLine();

			return true;
		}
		return false;
	}


	public boolean detectBitingRight(PVector head, PVector neck, PVector rightHand, PVector rightElbow) {
		head.y -= (head.y - neck.y)*.5;
		rightElbow.x -= (rightElbow.x - rightHand.x)*.5;
		float rightHandToMouthDistance = calc.distance3D(head, rightHand);
		float rightElbowToMouthDistance = calc.distance3D(head, rightElbow);
		if (rightHandToMouthDistance <= 150 || rightElbowToMouthDistance <= 150) {
//						System.out.println("The user touched their mouth with their left hand, the distance is " 
//								+ rightHandToMouthDistance);
			//System.out.println("I'm biting my hand " + displayTime);
			//playSound("../../Banana_slap_sound.mp3");
			//			bw.write("Hand Biting, " + displayTime);
			//			bw.newLine();

			return true;
		}
		return false;
	}

	public boolean isRocking(long timeRocked) {
		if(timeRocked - lastTimeRocked < 10) {
			numRocks++;
			lastTimeRocked = timeRocked;
		}
		if(numRocks >= 3) {
			numRocks = 0;
			return true;
		}
		else {
			return false;
		}
		
	}

//	public boolean isPacing(int counter) {
//		if(counter >= 3) {
//			return true;
//		} else return false;
//
//	}
	
	
//	public boolean isFlapping(int counter) {
//		double elapsed = changeInTime(lastTime);
//		//System.out.println("Elapsed Time: " + elapsed);
//		if(elapsed <= 10 && counter >= 3) {
//			slouchCounter = 0;
//			return true;
//		} else return false;
//
//	}

	public boolean isSitting(PVector leftHip, PVector leftKnee, PVector rightHip, PVector rightKnee) {
		float hipToKneeDistanceLeft = leftHip.y - leftKnee.y;
		float hipToKneeDistanceRight = rightHip.y - rightKnee.y;

		//System.out.println("Hip to knee distance: " + hipToKneeDistanceRight);
		if(hipToKneeDistanceLeft >= 0 && hipToKneeDistanceLeft <= 150) {
			if(hipToKneeDistanceRight >= 0 && hipToKneeDistanceRight <= 150) {
				//playSound("../../water_drop_sound.mp3");
				//System.out.print("I'm sitting! " + displayTime);
				return true;
				//				bw.write("Sitting, " + displayTime);
				//				bw.newLine();
			}
		}

		return false;
	}

	public boolean isSlouching(PVector torso, PVector rightShoulder, PVector leftShoulder) {
		float slouchDistanceRight = Math.abs(torso.z - rightShoulder.z);
		float slouchDistanceLeft = Math.abs(torso.z - leftShoulder.z);
		if(slouchDistanceRight >= 50 && slouchDistanceLeft >= 50 ) {
			//playSound("../../Electronic_chime.mp3");
			//System.out.println("I'm slouching! " + displayTime);
			//slouchCounter++;
			//lastTime = System.currentTimeMillis();
			//			bw.write("Slouching, " + displayTime);
			//			bw.newLine();
			return true;			
		} else {
			return false;
		}

	}
	
	public boolean isUpright(PVector torso, PVector rightShoulder, PVector leftShoulder) {
		float slouchDistanceRight = Math.abs(torso.z - rightShoulder.z);
		float slouchDistanceLeft = Math.abs(torso.z - leftShoulder.z);
		if((slouchDistanceRight >= 0 || slouchDistanceRight <= 10) && (slouchDistanceLeft >= 0 || slouchDistanceLeft <= 10)) {
		
			return true;			
		} else {
			return false;
		}
	}
	
	
	
	
	

}
