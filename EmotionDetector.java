package research;

/*
 * Written by Alex Goslen 2017
 * */
import ddf.minim.effects.HighPassSP;
import processing.core.PVector;
import java.util.ArrayList;

public class EmotionDetector {
	private VectorCalculator calc;
	private static final int ANGER = 0;
	private static final int DISGUST = 1;
	private static final int FEAR = 2;
	private static final int SADNESS = 3;
	private static final int HAPPINESS = 4;
	private static final int SURPRISE = 5;
	private static final int NO_EMOTION_DETECTED = 6;
	public ArrayList<ArrayList<String>> angles = new ArrayList<ArrayList<String>>();
	
	
	public EmotionDetector(){
		calc = new VectorCalculator();
	}
	
	
	public int getPosture(PVector hips, PVector head, PVector torso, PVector neck, 
		PVector leftElbow, PVector leftHip, PVector leftShoulder,
		PVector rightElbow, PVector rightHip, PVector rightShoulder, PVector leftHand, PVector rightHand){
//		System.out.println(head);
//		System.out.println(torso);
//		System.out.println(neck);
		//head.x = neck.x;
		//torso.x = neck.x;
		double headTilt = calc.getAngle(head, torso, neck);
		double leftArmRaise = calc.getAngle(leftElbow, leftHip, leftShoulder);
		double rightArmRaise = calc.getAngle(rightElbow, rightHip, rightShoulder);
		double leftElbowBend = calc.getAngle(leftHand, leftShoulder, leftElbow);
		double rightElbowBend = calc.getAngle(rightHand, rightShoulder, rightElbow);
		PVector rightAdjustedTorso = new PVector();
		rightAdjustedTorso.y = torso.y;
		rightAdjustedTorso.z = torso.z;
		rightAdjustedTorso.x = rightShoulder.x;
		
		double rightChestBend = calc.getAngle(rightShoulder, rightHip, rightAdjustedTorso);
		
		PVector leftAdjustedTorso = new PVector();
		leftAdjustedTorso.y = torso.y;
		leftAdjustedTorso.z = torso.z;
		leftAdjustedTorso.x = leftShoulder.x;
		double leftChestBend = calc.getAngle(leftShoulder, leftHip, leftAdjustedTorso);
		double middleChestBend = calc.getAngle(hips, neck, torso);

		
		ArrayList<String> calculatedAngles = new ArrayList<String>();
		calculatedAngles.add("middle chest bend " + middleChestBend);
		calculatedAngles.add("head tilt " + headTilt);
		calculatedAngles.add("left arm raise " + leftArmRaise);
		calculatedAngles.add("right arm raise " + rightArmRaise);
		calculatedAngles.add("left elbow bend "  + leftElbowBend);
		calculatedAngles.add("right elbow bend "  + rightElbowBend);
		
		angles.add(calculatedAngles);
		
//		System.out.println("middle chest bend " + middleChestBend);
//		System.out.println("head tilt " + headTilt);		
//		System.out.println("left arm raise " + leftArmRaise);
//		System.out.println("right arm raise " + rightArmRaise);
//		System.out.println("left elbow bend "  + leftElbowBend);
//		System.out.println("right elbow bend "  + rightElbowBend);
//		System.out.println("left chest bend " + leftChestBend);
//		System.out.println("right chest bend " + rightChestBend);
		
//		if((headTilt <= 150 && headTilt >= 170)){
//			System.out.println("head tilt true");
//		}
//		if ((rightChestBend >= 160 && rightChestBend <= 180) 
//				&& (leftChestBend >= 160 && leftChestBend <= 180)){
//			System.out.println("chest bend true");
//		}
//		
//		if((rightArmRaise >= 110 && rightArmRaise <= 130)
//				&& (leftArmRaise >= 110 && leftArmRaise <= 130)){
//			System.out.println("right arm raise true");
//		}
//		if ((rightElbowBend >= 160 && rightElbowBend <= 180)
//				&& (leftElbowBend >= 160 && leftElbowBend <= 180)){
//			System.out.println("elbow bend true");
//		}
		
		/*Both sides testing*/
//		if ((headTilt >= 160 || headTilt <= 20) && (rightChestBend >= 20 && rightChestBend <= 60) 
//				&& (leftChestBend >= 20 && leftChestBend <= 60) && (rightArmRaise >= 30 && rightArmRaise <= 80)
//				&& (leftArmRaise >= 30 && leftArmRaise <= 80) && (rightElbowBend >= 50 && rightElbowBend <= 90)
//				&& (leftElbowBend >= 50 && leftElbowBend <= 90)){
//			return ANGER;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (rightChestBend >= 160 || rightChestBend <= 20) 
//				&& (leftChestBend >= 160 || leftChestBend <= 20) && (rightArmRaise >= 45 && rightArmRaise <= 90)
//				&& (leftArmRaise >= 45 && leftArmRaise <= 90) && (rightElbowBend >= 160 || rightElbowBend <= 20)
//				&& (leftElbowBend >= 160 || leftElbowBend <= 20)){
//			return DISGUST;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (rightChestBend >= 0 && rightChestBend <= 40) 
//				&& (leftChestBend >= 0 && leftChestBend <= 40) && (rightArmRaise >= 30 && rightArmRaise <= 80)
//				&& (leftArmRaise >= 30 && leftArmRaise <= 80) && (rightElbowBend >= 110 && rightElbowBend <= 150)
//				&& (leftElbowBend >= 110 && leftElbowBend <= 150)){
//			return FEAR;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (rightChestBend >= 160 || rightChestBend <= 20) 
//				&& (leftChestBend >= 160 || leftChestBend <= 20) && (rightArmRaise >= 100 && rightArmRaise <= 140)
//				&& (leftArmRaise >= 100 && leftArmRaise <= 140) && (rightElbowBend >= 160 || rightElbowBend <= 20)
//				&& (leftElbowBend >= 160 || leftElbowBend <= 20)){
//			return HAPPINESS;
//		}
//		
//		if ((headTilt >= 30 && headTilt <= 70) && (rightChestBend >= 20 && rightChestBend <= 60) 
//				&& (leftChestBend >= 20 && leftChestBend <= 60) && (rightArmRaise >= 0 && rightArmRaise <= 60)
//				&& (leftArmRaise >= 0 && leftArmRaise <= 60) && (rightElbowBend >= 110 && rightElbowBend <= 150)
//				&& (leftElbowBend >= 110 && leftElbowBend <= 150)){
//			return SADNESS;
//		}
//		
//		if ((headTilt >= 5 && headTilt <= 45) && (rightChestBend >= 160 || rightChestBend <= 20) 
//				&& (leftChestBend >= 160 || leftChestBend <= 20) && (rightArmRaise >= 100 && rightArmRaise <= 140)
//				&& (leftArmRaise >= 100 && leftArmRaise <= 140) && (rightElbowBend >= 160 || rightElbowBend <= 20)
//				&& (leftElbowBend >= 160 || leftElbowBend <= 20)){
//			return SURPRISE;
//		}
//		
//		else {
//			return NO_EMOTION_DETECTED;
//		}
		/*right side test*/
//		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 120 && rightChestBend <= 160)
//				&& (rightArmRaise >= 30 && rightArmRaise <= 80)
//				&& (rightElbowBend >= 50 && rightElbowBend <= 90)){
//			return ANGER;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 160 || middleChestBend <= 20) 
//				&& (rightArmRaise >= 45 && rightArmRaise <= 90)
//				&& (rightElbowBend >= 160 || rightElbowBend <= 20)){
//			return DISGUST;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 100 && middleChestBend <= 140) 
//				&& (rightArmRaise >= 30 && rightArmRaise <= 80)
//				&& (rightElbowBend >= 110 && rightElbowBend <= 150)){
//			return FEAR;
//		}
//		
//		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 160 || middleChestBend <= 20) 
//				&& (rightArmRaise >= 100 && rightArmRaise <= 140)
//				&& (rightElbowBend >= 160 || rightElbowBend <= 20)){
//			return HAPPINESS;
//		}
//		
//		if ((headTilt >= 30 && headTilt <= 70) && (middleChestBend >= 120 && middleChestBend <= 160) 
//				&& (rightArmRaise >= 0 && rightArmRaise <= 60)
//				&& (rightElbowBend >= 110 && rightElbowBend <= 150)){
//			return SADNESS;
//		}
//		
//		if ((headTilt >= 5 && headTilt <= 45) && (middleChestBend >= 160 || middleChestBend <= 20) 
//				&& (rightArmRaise >= 100 && rightArmRaise <= 140)
//				&& (rightElbowBend >= 160 || rightElbowBend <= 20)){
//			return SURPRISE;
//		}
//		
//		else {
//			return NO_EMOTION_DETECTED;
//		}

		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 120 && rightChestBend <= 160)
				&& ((leftArmRaise >= 30 && leftArmRaise <= 80)||(rightArmRaise >= 30 && rightArmRaise <= 80))
				&& ((leftElbowBend >= 50 && leftElbowBend <= 90)||(rightElbowBend >= 50 && rightElbowBend <= 90))){
			return ANGER;
		}
		
		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 160 || middleChestBend <= 20) 
				&& ((leftArmRaise >= 45 && leftArmRaise <= 90)||(rightArmRaise >= 45 && rightArmRaise <= 90))
				&& ((leftElbowBend >= 160 || leftElbowBend <= 20)||(rightElbowBend >= 160 || rightElbowBend <= 20))){
			return DISGUST;
		}
		
		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 100 && middleChestBend <= 140) 
				&& ((leftArmRaise >= 30 && leftArmRaise <= 80)||(rightArmRaise >= 30 && rightArmRaise <= 80))
				&& ((leftElbowBend >= 110 && leftElbowBend <= 150)||(rightElbowBend >= 110 && rightElbowBend <= 150))){
			return FEAR;
		}
		
		if ((headTilt >= 160 || headTilt <= 20) && (middleChestBend >= 160 || middleChestBend <= 20) 
				&& ((leftArmRaise >= 100 && leftArmRaise <= 140)||(rightArmRaise >= 100 && rightArmRaise <= 140))
				&& ((leftElbowBend >= 160 || leftElbowBend <= 20)||(rightElbowBend >= 160 || rightElbowBend <= 20))){
			return HAPPINESS;
		}
		
		if ((headTilt >= 130 && headTilt <= 170) && (middleChestBend >= 120 && middleChestBend <= 160) 
				&& ((leftArmRaise >= 0 && leftArmRaise <= 60)||(rightArmRaise >= 0 && rightArmRaise <= 60))
				&& ((leftElbowBend >= 110 && leftElbowBend <= 150)||(rightElbowBend >= 110 && rightElbowBend <= 150))){
			return SADNESS;
		}
		
		if ((headTilt >= 135 && headTilt <= 175) && (middleChestBend >= 160 || middleChestBend <= 20) 
				&& ((leftArmRaise >= 100 && leftArmRaise <= 140)||(rightArmRaise >= 100 && rightArmRaise <= 140))
				&& ((leftElbowBend >= 160 || leftElbowBend <= 20)||(rightElbowBend >= 160 || rightElbowBend <= 20))){
			return SURPRISE;
		}
		
		else {
			return NO_EMOTION_DETECTED;
		}		
	}
	
	
	
	

}
