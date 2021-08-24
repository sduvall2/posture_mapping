package research;
/*
 * Written by Alex Goslen 2017
 * */
import java.util.ArrayList;

import processing.core.PVector;

public class Skeleton {
	ArrayList <PVector> Hips = new ArrayList<PVector>();
	ArrayList <PVector> Chest = new ArrayList<PVector>();
	ArrayList <PVector> Chest2 = new ArrayList<PVector>();
	ArrayList <PVector> Chest3 = new ArrayList<PVector>();
	ArrayList <PVector> Chest4 = new ArrayList<PVector>();
	ArrayList <PVector> Neck = new ArrayList<PVector>();
	ArrayList<PVector> Head = new ArrayList<PVector>();
	ArrayList <PVector> RightCollar = new ArrayList<PVector>();
	ArrayList <PVector> RightShoulder = new ArrayList<PVector>();
	ArrayList <PVector> RightElbow = new ArrayList<PVector>();
	ArrayList <PVector> RightWrist = new ArrayList<PVector>();
	ArrayList <PVector> LeftCollar = new ArrayList<PVector>();
	ArrayList <PVector> LeftShoulder = new ArrayList<PVector>();
	ArrayList <PVector> LeftElbow = new ArrayList<PVector>();
	ArrayList <PVector> LeftWrist = new ArrayList<PVector>();
	ArrayList <PVector> RightHip = new ArrayList<PVector>();
	ArrayList <PVector> RightKnee = new ArrayList<PVector>();
	ArrayList <PVector> RightAnkle = new ArrayList<PVector>();
	ArrayList <PVector> RightToe = new ArrayList<PVector>();
	ArrayList <PVector> LeftHip = new ArrayList<PVector>();
	ArrayList <PVector> LeftKnee = new ArrayList<PVector>();
	ArrayList <PVector> LeftAnkle = new ArrayList<PVector>();
	ArrayList <PVector> LeftToe = new ArrayList<PVector>();
	
	//mvnx data points
	ArrayList <PVector> pHipOrigin = new ArrayList<PVector>();
	ArrayList <PVector> jL5S1 = new ArrayList<PVector>();
	ArrayList <PVector> jL4L3 = new ArrayList<PVector>();
	ArrayList <PVector> jL1T12 = new ArrayList<PVector>();
	ArrayList <PVector> jT9T8 = new ArrayList<PVector>();
	ArrayList <PVector> jT1C7 = new ArrayList<PVector>();
	ArrayList<PVector> jC1Head = new ArrayList<PVector>();
	ArrayList <PVector> pTopOfHead = new ArrayList<PVector>();
	ArrayList <PVector> jRightC7Shoulder = new ArrayList<PVector>();
	ArrayList <PVector> jRightShoulder = new ArrayList<PVector>();
	ArrayList <PVector> jRightElbow = new ArrayList<PVector>();
	ArrayList <PVector> jRightWrist = new ArrayList<PVector>();
	ArrayList <PVector> pRightTopOfHand = new ArrayList<PVector>();
	ArrayList <PVector> jRightHip = new ArrayList<PVector>();
	ArrayList <PVector> jRightKnee = new ArrayList<PVector>();
	ArrayList <PVector> jRightAnkle = new ArrayList<PVector>();
	ArrayList <PVector> jRightBallFoot = new ArrayList<PVector>();
	ArrayList <PVector> pRightToe = new ArrayList<PVector>();
	ArrayList <PVector> jLeftC7Shoulder = new ArrayList<PVector>();
	ArrayList <PVector> jLeftShoulder = new ArrayList<PVector>();
	ArrayList <PVector> jLeftElbow = new ArrayList<PVector>();
	ArrayList <PVector> jLeftWrist = new ArrayList<PVector>();
	ArrayList <PVector> pLeftTopOfHand = new ArrayList<PVector>();
	ArrayList <PVector> jLeftHip = new ArrayList<PVector>();
	ArrayList <PVector> jLeftKnee = new ArrayList<PVector>();
	ArrayList <PVector> jLeftAnkle = new ArrayList<PVector>();
	ArrayList <PVector> jLeftBallFoot = new ArrayList<PVector>();
	ArrayList <PVector> pLeftToe = new ArrayList<PVector>();
	
	public Skeleton(){
		
	}
	
	
	public PVector getHips(int i) {
		return Hips.get(i);
	}

	public void setHips(PVector hips, int i) {
		//System.out.println(hips);
		Hips.add(pHipOrigin.get(i));
	}

	public PVector getChest(int i) {
		return Chest.get(i);
	}

	public void setChest(PVector chest, int i) {
		Chest.add(jL5S1.get(i));
	}

	public PVector getChest2(int i) {
		return Chest2.get(i);
	}

	public void setChest2(PVector chest2, int i) {
		Chest2.add(jL4L3.get(i));
	}

	public PVector getChest3(int i) {
		return Chest3.get(i);
	}

	public void setChest3(PVector chest3, int i) {
		Chest3.add(jL1T12.get(i));
	}

	public PVector getChest4(int i) {
		return Chest4.get(i);
	}

	public void setChest4(PVector chest4, int i) {
		Chest4.add(jT9T8.get(i));
	}

	public PVector getNeck(int i) {
		return Neck.get(i);
	}

	public void setNeck(PVector neck, int i) {
		Neck.add(jT1C7.get(i));
	}

	public PVector getHead(int i) {
	//	System.out.println("getHeadValue " + Head);
		return Head.get(i);
	}

	public void setHead(PVector head, int i) {

		//System.out.println("setHeadValue " + head);
		Head.add(jC1Head.get(i));
	}

	public PVector getRightCollar(int i) {
		return RightCollar.get(i);
	}

	public void setRightCollar(PVector rightCollar, int i) {
		RightCollar.add(jRightC7Shoulder.get(i));
	}

	public PVector getRightShoulder(int i) {
		return RightShoulder.get(i);
	}

	public void setRightShoulder(PVector rightShoulder, int i) {
		RightShoulder.add(jRightShoulder.get(i));
	}

	public PVector getRightElbow(int i) {
		return RightElbow.get(i);
	}

	public void setRightElbow(PVector rightElbow, int i) {
		RightElbow.add(jRightElbow.get(i));
	}

	public PVector getRightWrist(int i) {
		return RightWrist.get(i);
	}

	public void setRightWrist(PVector rightWrist, int i) {
		RightWrist.add(jRightWrist.get(i));
	}

	public PVector getLeftCollar(int i) {
		return LeftCollar.get(i);
	}

	public void setLeftCollar(PVector leftCollar, int i) {
		LeftCollar.add(jLeftC7Shoulder.get(i));
	}

	public PVector getLeftShoulder(int i) {
		return LeftShoulder.get(i);
	}

	public void setLeftShoulder(PVector leftShoulder, int i) {
		LeftShoulder.add(jLeftShoulder.get(i));
	}

	public PVector getLeftElbow(int i) {
		return LeftElbow.get(i);
	}

	public void setLeftElbow(PVector leftElbow, int i) {
		LeftElbow.add(jLeftElbow.get(i));
	}

	public PVector getLeftWrist(int i) {
		//System.out.println("Left Wrist " + LeftWrist);
		return LeftWrist.get(i);
	}

	public void setLeftWrist(PVector leftWrist, int i) {
		LeftWrist.add(jLeftWrist.get(i));
	}

	public PVector getRightHip(int i) {
		return RightHip.get(i);
	}

	public void setRightHip(PVector rightHip, int i) {
		RightHip.add(jRightHip.get(i));
	}

	public PVector getRightKnee(int i) {
		return RightKnee.get(i);
	}

	public void setRightKnee(PVector rightKnee, int i) {
		RightKnee.add(jRightKnee.get(i));
	}

	public PVector getRightAnkle(int i) {
		return RightAnkle.get(i);
	}

	public void setRightAnkle(PVector rightAnkle, int i) {
		RightAnkle.add(jRightAnkle.get(i));
	}

	public PVector getRightToe(int i) {
		return RightToe.get(i);
	}

	public void setRightToe(PVector rightToe, int i) {
		RightToe.add(pRightToe.get(i));
	}

	public PVector getLeftHip(int i) {
		return LeftHip.get(i);
	}

	public void setLeftHip(PVector leftHip, int i) {
		LeftHip.add(jLeftHip.get(i));
	}

	public PVector getLeftKnee(int i) {
		return LeftKnee.get(i);
	}

	public void setLeftKnee(PVector leftKnee, int i) {
		LeftKnee.add(jLeftKnee.get(i));
	}

	public PVector getLeftAnkle(int i) {
		return LeftAnkle.get(i);
	}

	public void setLeftAnkle(PVector leftAnkle, int i) {
		LeftAnkle.add(jLeftAnkle.get(i));
	}

	public PVector getLeftToe(int i) {
		return LeftToe.get(i);
	}

	public void setLeftToe(PVector leftToe, int i) {
		LeftToe.add(pLeftToe.get(i));
	}
	
	public PVector getpHipOrigin(int i) {
		return pHipOrigin.get(i);
	}


	public void setpHipOrigin(PVector p, int i) {
		this.pHipOrigin.add(p);
		setHips(p, i);
	}


	public PVector getjL5S1(int i) {
		return jL5S1.get(i);
	}


	public void setjL5S1(PVector jL5S1, int i) {
		PVector root  = pHipOrigin.get(i);
//		System.out.println("root: " + root);
//		System.out.println("jL5S1: " + jL5S1);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jL5S1.get(0);
			jL5S1 = PVector.add(jL5S1, root);
			jL5S1 = PVector.add(jL5S1, offset);
		}
		this.jL5S1.add(jL5S1);
		setChest(jL5S1, i);
//		System.out.println("jL5s1 UPdated: " + jL5S1);
		
	}


	public PVector getjL4L3(int i) {
		return jL4L3.get(i);
	}


	public void setjL4L3(PVector jL4L3, int i) {
		PVector root = jL5S1.get(i);
		jL4L3 = PVector.add(jL4L3, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jL4L3.get(0);
			jL4L3 = PVector.add(jL4L3, root);
			jL4L3 = PVector.add(jL4L3, offset);
		}
		
		this.jL4L3.add(jL4L3);
		setChest2(jL4L3, i);
	}


	public PVector getjL1T12(int i) {
		return jL1T12.get(i);
	}


	public void setjL1T12(PVector jL1T12, int i) {
		PVector root = jL4L3.get(i);
		jL1T12 = PVector.add(root, jL1T12);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jL1T12.get(0);
			jL1T12 = PVector.add(jL1T12, root);
			jL1T12 = PVector.add(jL1T12, offset);
		}
		this.jL1T12.add(jL1T12);
		setChest3(jL1T12, i);
	}


	public PVector getjT9T8(int i) {
		return jT9T8.get(i);
	}


	public void setjT9T8(PVector jT9T8, int i) {
		PVector root = jL1T12.get(i);
		jT9T8 = PVector.add(root, jT9T8);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jT9T8.get(0);
			jT9T8 = PVector.add(jT9T8, root);
			jT9T8 = PVector.add(jT9T8, offset);
		}
		this.jT9T8.add(jT9T8);
		setChest4(jT9T8, i);
	}


	public PVector getjT1C7(int i) {
		return jT1C7.get(i);
	}


	public void setjT1C7(PVector jT1C7, int i) {
		PVector root = jT9T8.get(i);
		jT1C7 = PVector.add(root, jT1C7);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jT1C7.get(0);
			jT1C7 = PVector.add(jT1C7, root);
			jT1C7 = PVector.add(jT1C7, offset);
		}
		this.jT1C7.add(jT1C7);
		setNeck(jT1C7, i);
	}


	public PVector getjC1Head(int i) {
		return jC1Head.get(i);
	}


	public void setjC1Head(PVector jC1Head, int i) {
		PVector root = jT1C7.get(i);
		jC1Head = PVector.add(root, jC1Head);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jC1Head.get(0);
			jC1Head = PVector.add(jC1Head, root);
			jC1Head = PVector.add(jC1Head, offset);
		}
		
		this.jC1Head.add(jC1Head);
		setHead(jC1Head, i);
	}


	public PVector getpTopOfHead(int i) {
		return pTopOfHead.get(i);
	}


	public void setpTopOfHead(PVector pTopOfHead, int i) {
		PVector root = jC1Head.get(i);
		pTopOfHead = PVector.add(pTopOfHead, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.pTopOfHead.get(0);
			pTopOfHead = PVector.add(pTopOfHead, root);
			pTopOfHead = PVector.add(pTopOfHead, offset);
		}
		this.pTopOfHead.add(pTopOfHead);
	}


	public PVector getjRightC7Shoulder(int i) {
		return jRightC7Shoulder.get(i);
	}


	public void setjRightC7Shoulder(PVector jRightC7Shoulder, int i) {
		PVector root = jT9T8.get(i);
		jRightC7Shoulder = PVector.add(jRightC7Shoulder, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightC7Shoulder.get(0);
			jRightC7Shoulder = PVector.add(jRightC7Shoulder, root);
			jRightC7Shoulder = PVector.add(jRightC7Shoulder, offset);
		}
		
		this.jRightC7Shoulder.add(jRightC7Shoulder);
		setRightCollar(jRightC7Shoulder, i);
	}


	public PVector getjRightShoulder(int i) {
		return jRightShoulder.get(i);
	}


	public void setjRightShoulder(PVector jRightShoulder, int i) {
		PVector root = jRightC7Shoulder.get(i);
		jRightShoulder = PVector.add(jRightShoulder, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightShoulder.get(0);
			jRightShoulder = PVector.add(jRightShoulder, root);
			jRightShoulder = PVector.add(jRightShoulder, offset);
		}
		this.jRightShoulder.add(jRightShoulder);
		setRightShoulder(jRightShoulder, i);
	}


	public PVector getjRightElbow(int i) {
		return jRightElbow.get(i);
	}


	public void setjRightElbow(PVector jRightElbow, int i) {
		PVector root = jRightShoulder.get(i);
		jRightElbow = PVector.add(root, jRightElbow);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightElbow.get(0);
			jRightElbow = PVector.add(jRightElbow, root);
			jRightElbow = PVector.add(jRightElbow, offset);
		}
		this.jRightElbow.add(jRightElbow);
		setRightElbow(jRightElbow, i);
	}


	public PVector getjRightWrist(int i) {
		return jRightWrist.get(i);
	}


	public void setjRightWrist(PVector jRightWrist, int i) {
		PVector root = jRightElbow.get(i);
		jRightWrist = PVector.add(root, jRightWrist);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightWrist.get(0);
			jRightWrist = PVector.add(jRightWrist, root);
			jRightWrist = PVector.add(jRightWrist, offset);
		}
		this.jRightWrist.add(jRightWrist);
		setRightWrist(jRightWrist, i);
	}


	public PVector getpRightTopOfHand(int i) {
		return pRightTopOfHand.get(i);
	}


	public void setpRightTopOfHand(PVector pRightTopOfHand, int i) {
		PVector root = jRightWrist.get(i);
		pRightTopOfHand = PVector.add(root, pRightTopOfHand);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.pRightTopOfHand.get(0);
			pRightTopOfHand = PVector.add(pRightTopOfHand, root);
			pRightTopOfHand = PVector.add(pRightTopOfHand, offset);
		}
		this.pRightTopOfHand.add(pRightTopOfHand);
	}


	public PVector getjRightHip(int i) {
		return jRightHip.get(i);
	}


	public void setjRightHip(PVector jRightHip, int i) {
		PVector root = pHipOrigin.get(i);
		jRightHip = PVector.add(root, jRightHip);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightHip.get(0);
			jRightHip = PVector.add(jRightHip, root);
			jRightHip = PVector.add(jRightHip, offset);
		}
		this.jRightHip.add(jRightHip);
		setRightHip(jRightHip, i);
	}


	public PVector getjRightKnee(int i) {
		return jRightKnee.get(i);
	}


	public void setjRightKnee(PVector jRightKnee, int i) {
		PVector root = jRightHip.get(i);
		jRightKnee = PVector.add(root, jRightKnee);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightKnee.get(0);
			jRightKnee = PVector.add(jRightKnee, root);
			jRightKnee = PVector.add(jRightKnee, offset);
		}
		this.jRightKnee.add(jRightKnee);
		setRightKnee(jRightKnee, i);
	}


	public PVector getjRightAnkle(int i) {
		return jRightAnkle.get(i);
	}


	public void setjRightAnkle(PVector jRightAnkle, int i) {
		PVector root = jRightKnee.get(i);
		jRightAnkle = PVector.add(root, jRightAnkle);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightAnkle.get(0);
			jRightAnkle = PVector.add(jRightAnkle, root);
			jRightAnkle = PVector.add(jRightAnkle, offset);
		}
		this.jRightAnkle.add(jRightAnkle);
		setRightAnkle(jRightAnkle, i);
	}


	public PVector getjRightBallFoot(int i) {
		return jRightBallFoot.get(i);
	}


	public void setjRightBallFoot(PVector jRightBallFoot, int i) {
		PVector root = jRightAnkle.get(i);
		jRightBallFoot = PVector.add(root, jRightBallFoot);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jRightBallFoot.get(0);
			jRightBallFoot = PVector.add(jRightBallFoot, root);
			jRightBallFoot = PVector.add(jRightBallFoot, offset);
		}
		this.jRightBallFoot.add(jRightBallFoot);
		//setRightFoot(jRightBallFoot, i);
	}


	public PVector getpRightToe(int i) {
		return pRightToe.get(i);
	}


	public void setpRightToe(PVector pRightToe, int i) {
		PVector root = jRightBallFoot.get(i);
		pRightToe = PVector.add(root, pRightToe);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.pRightToe.get(0);
			pRightToe = PVector.add(pRightToe, root);
			pRightToe = PVector.add(pRightToe, offset);
		}
		this.pRightToe.add(pRightToe);
		setRightToe(pRightToe, i);
	}


	public PVector getjLeftC7Shoulder(int i) {
		return jLeftC7Shoulder.get(i);
	}


	public void setjLeftC7Shoulder(PVector jLeftC7Shoulder, int i) {
		PVector root = jT9T8.get(i);
		jLeftC7Shoulder = PVector.add(jLeftC7Shoulder, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftC7Shoulder.get(0);
			jLeftC7Shoulder = PVector.add(jLeftC7Shoulder, root);
			jLeftC7Shoulder = PVector.add(jLeftC7Shoulder, offset);
		}
		this.jLeftC7Shoulder.add(jLeftC7Shoulder);
		setLeftCollar(jLeftC7Shoulder, i);
	}


	public PVector getjLeftShoulder(int i) {
		return jLeftShoulder.get(i);
	}


	public void setjLeftShoulder(PVector jLeftShoulder, int i) {
		PVector root = jLeftC7Shoulder.get(i);
		jLeftShoulder = PVector.add(jLeftShoulder, root);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftShoulder.get(0);
			jLeftShoulder = PVector.add(jLeftShoulder, root);
			jLeftShoulder = PVector.add(jLeftShoulder, offset);
		}
		this.jLeftShoulder.add(jLeftShoulder);
		setLeftShoulder(jLeftShoulder, i);
	}


	public PVector getjLeftElbow(int i) {
		return jLeftElbow.get(i);
	}


	public void setjLeftElbow(PVector jLeftElbow, int i) {
		PVector root = jLeftShoulder.get(i);
		jLeftElbow = PVector.add(root, jLeftElbow);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jL5S1.get(0);
			jLeftElbow = PVector.add(jLeftElbow, root);
			jLeftElbow = PVector.add(jLeftElbow, offset);
		}
		this.jLeftElbow.add(jLeftElbow);
		setLeftElbow(jLeftElbow, i);
	}


	public PVector getjLeftWrist(int i) {
		return jLeftWrist.get(i);
	}


	public void setjLeftWrist(PVector jLeftWrist, int i) {
		PVector root = jLeftElbow.get(i);
		jLeftWrist = PVector.add(root, jLeftWrist);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftWrist.get(0);
			jLeftWrist = PVector.add(jLeftWrist, root);
			jLeftWrist = PVector.add(jLeftWrist, offset);
		}
		this.jLeftWrist.add(jLeftWrist);
		setLeftWrist(jLeftWrist, i);
	}
	


	public PVector getpLeftTopOfHand(int i) {
		return pLeftTopOfHand.get(i);
	}


	public void setpLeftTopOfHand(PVector pLeftTopOfHand, int i) {
		PVector root = jLeftWrist.get(i);
		pLeftTopOfHand = PVector.add(root, pLeftTopOfHand);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.pLeftTopOfHand.get(0);
			pLeftTopOfHand = PVector.add(pLeftTopOfHand, root);
			pLeftTopOfHand = PVector.add(pLeftTopOfHand, offset);
		}
		this.pLeftTopOfHand.add(pLeftTopOfHand);
	}


	public PVector getjLeftHip(int i) {
		return jLeftHip.get(i);
	}


	public void setjLeftHip(PVector jLeftHip, int i) {
		PVector root = pHipOrigin.get(i);
		jLeftHip = PVector.add(root, jLeftHip);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftHip.get(0);
			jLeftHip = PVector.add(jLeftHip, root);
			jLeftHip = PVector.add(jLeftHip, offset);
		}
		this.jLeftHip.add(jLeftHip);
		setLeftHip(jLeftHip, i);
	}


	public PVector getjLeftKnee(int i) {
		return jLeftKnee.get(i);
	}


	public void setjLeftKnee(PVector jLeftKnee, int i) {
		PVector root = jLeftHip.get(i);
		jLeftKnee = PVector.add(root, jLeftKnee);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftKnee.get(0);
			jLeftKnee = PVector.add(jLeftKnee, root);
			jLeftKnee = PVector.add(jLeftKnee, offset);
		}
		this.jLeftKnee.add(jLeftKnee);
		setLeftKnee(jLeftKnee, i);
	}


	public PVector getjLeftAnkle(int i) {
		return jLeftAnkle.get(i);
	}


	public void setjLeftAnkle(PVector jLeftAnkle, int i) {
		PVector root = jLeftKnee.get(i);
		jLeftAnkle = PVector.add(root, jLeftAnkle);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftAnkle.get(0);
			jLeftAnkle = PVector.add(jLeftAnkle, root);
			jLeftAnkle = PVector.add(jLeftAnkle, offset);
		}
		this.jLeftAnkle.add(jLeftAnkle);
		setLeftAnkle(jLeftAnkle, i);
	}


	public PVector getjLeftBallFoot(int i) {
		return jLeftBallFoot.get(i);
	}


	public void setjLeftBallFoot(PVector jLeftBallFoot, int i) {
		PVector root = jLeftAnkle.get(i);
		jLeftBallFoot = PVector.add(root, jLeftBallFoot);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.jLeftBallFoot.get(0);
			jLeftBallFoot = PVector.add(jLeftBallFoot, root);
			jLeftBallFoot = PVector.add(jLeftBallFoot, offset);
		}
		this.jLeftBallFoot.add(jLeftBallFoot);
	}


	public PVector getpLeftToe(int i) {
		return pLeftToe.get(i);
	}


	public void setpLeftToe(PVector pLeftToe, int i) {
		PVector root = jLeftBallFoot.get(i);
		pLeftToe = PVector.add(root, pLeftToe);
		if(i !=0) {
//			System.out.println("offset: " + this.jL5S1.get(0));
			PVector offset = this.pLeftToe.get(0);
			pLeftToe = PVector.add(pLeftToe, root);
			pLeftToe = PVector.add(pLeftToe, offset);
		}
		this.pLeftToe.add(pLeftToe);
		setLeftToe(pLeftToe, i);
	}
	

}
