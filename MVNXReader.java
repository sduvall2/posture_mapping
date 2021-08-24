package research;
/*
 * Written by Alex Goslen 2017
 * */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PVector;

public class MVNXReader {

	public static Skeleton skel;
	private static PVector p;
	private static EmotionDetector ed;
	private static String [] emotions = {"Anger", "Disgust", "Fear", "Sadness", "Happiness", "Surprise", "No Emotion"};
	private static String[] filepaths = {"AnBh_Anger.txt","AnBh_Disgust.txt", "AnBh_Fear.txt", "AnBh_Joy.txt", "AnBh_Neutral.txt", 
			"AnBh_Sadness.txt", "AnBh_Surprise.txt", "DiMi_Anger.txt","DiMi_Disgust.txt", "DiMi_Fear.txt", "DiMi_Joy.txt", "DiMi_Neutral.txt", 
			"DiMi_Sadness.txt", "DiMi_Surprise.txt"}; 
	private static String[] jointsUsed = {"pHipOrigin", "jL5S1", "jL4L3", "jL1T12", "jT9T8", "jT1C7", "jC1Head", "pTopOfHead", "jRightC7Shoulder",
			"jRightShoulder", "jRightElbow", "jRightWrist", "pRightTopOfHand", "jRightHip", "jRightKnee", "jRightAnkle", "jRightBallFoot", "pRightToe", "jLeftC7Shoulder",
			"jLeftShoulder", "jLeftElbow", "jLeftWrist", "pLeftTopOfHand", "jLeftHip","jLeftKnee", "jLeftAnkle", "jLeftBallFoot", "pLeftToe"};
	private static String[] jointNames = {"Hips", "Chest", "Chest2", "Chest3", "Chest4", "Neck", "Head", "RightCollar", "RightShoulder",
			"RightElbow", "RightWrist", "LeftCollar", "LeftShoulder", "LeftElbow", "LeftWrist", "RightHip", "RightKnee", "RightAnkle", 
			"RightToe", "LeftHip", "LeftKnee", "LeftAnkle", "LeftToe"
	};
	private static String[] jointsInOrder = {"pHipOrigin", "jL5S1", "jL4L3", "jL1T12", "jT9T8", "jT1C7", "jC1Head",  "jRightC7Shoulder",
			"jRightShoulder", "jRightElbow", "jRightWrist", "jLeftC7Shoulder",
			"jLeftShoulder", "jLeftElbow", "jLeftWrist", "jRightHip", "jRightKnee", "jRightAnkle", "jRightBallFoot", "jLeftHip",
			"jLeftKnee", "jLeftAnkle", "jLeftBallFoot"};
	
	private static ArrayList<String> joints = new ArrayList<String>();

	public MVNXReader(){
		skel  = new Skeleton();
		p = new PVector();
		ed = new EmotionDetector();

	}
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		for (int j = 0; j < 7; j++) {

			int lineMax = 120;
			// TODO Auto-generated method stub
			skel = new Skeleton();
			p = new PVector();
			ed = new EmotionDetector();
			//String fileName = "C:\\Users\\Robert\\Documents\\EmotionMapping\\Results\\Skeleton Data\\AnBh_Anger.txt";
			String fileName = "C:\\Users\\Robert\\Documents\\PostureMapping\\MVNH Data\\"+filepaths[j];
			System.out.println(filepaths[j]);
			File file = new File(fileName);
			// This will reference one line at a time
			String line = null;
			Class<?> params[] = {p.getClass(), Integer.TYPE};
			Class pVecClass = p.getClass();
			Class skeletonClass = skel.getClass();
			ArrayList<String> activeJoints  = initiateJoints(jointsUsed);

			try {
				// FileReader reads text files in the default encoding.
				FileReader fileReader = 
						new FileReader(file);

				Scanner sc = new Scanner(fileReader);
				// Always wrap FileReader in BufferedReader.
				//			BufferedReader bufferedReader = 
				//					new BufferedReader(fileReader);
				int numSpaces = 0;
				String jointName = "";
				String rootName = "";
				String pvec = "";
				boolean parsingMotion = false;
				//int jointIndex = 0;
				//PVector jointPos = new PVector();
				boolean segmentState = false;
				boolean motionState = false;
				int lineNum = 0;
				while(sc.hasNextLine()) {
					PVector jointPos = new PVector();
					String currentLine = sc.nextLine();
					if(currentLine.contains("<segments>")) {
						//begine parsing segment section
						segmentState = true;
					} 
					if(currentLine.contains("<frames>")) {
						segmentState = false;
						motionState = true;
					}
					if(currentLine.contains("</frames>")) {
						motionState = false;
						
					}

					if(segmentState && currentLine.contains("<point")){
						//get joint name and position vector
						Scanner s = new Scanner(currentLine);
						s.useDelimiter("=");
						s.next();
						String next =  s.next();
						jointName = next.substring(1, next.lastIndexOf("\""));
						//System.out.println(jointName);
						String pvector = s.next();
						int firstSpace  = pvector.indexOf(" ");
						int secondSpace = pvector.indexOf(" ", firstSpace+1);
						jointPos.x = Float.parseFloat(pvector.substring(1, firstSpace));
						jointPos.y = Float.parseFloat(pvector.substring(firstSpace,secondSpace));
						jointPos.z = Float.parseFloat(pvector.substring(secondSpace,pvector.indexOf("\"", firstSpace+1)));
						//System.out.println(pvector);
						//System.out.println(jointPos);
						s.close();

						//set the joints that we need
//						boolean shouldSet = false;
//						for(int i = 0; i < jointsUsed.length; i++){
//							if(jointsUsed[i].equals(jointName)) {
//								shouldSet = true;
//								break;
//							}
//						}
						if(activeJoints.contains(jointName)){
						//if(shouldSet) {
							String methodName = "set"+jointName;
							//System.out.println(methodName);
							Object[] o = {jointPos, 0};
							Method toCall = skeletonClass.getMethod(methodName, params);
							PVector answer = (PVector)(toCall.invoke(skel, o));
							
							activeJoints.remove(jointName);

							//System.out.println("Hips: " + skel.getpHipOrigin(0));
						}
						
						
						
					}
					if(motionState && currentLine.contains("<F")  ){
						Scanner s = new Scanner(currentLine);
						s.useDelimiter(" ");
						s.next();
						int k = 0; 
						int jointIndex = 0;
						while(s.hasNext()){
							String next = s.next();
							jointName = jointsInOrder[jointIndex%23];
//							if(next.contains("\"")){
//								next.substring(0, next.indexOf("\"")-1);
//							}
							//System.out.print("k: " + k + " jointIndex " + jointIndex + ", ");
							if(k%7==4){
								jointPos.x = Float.parseFloat(next);
							} else if(k%7 == 5) {
								jointPos.y = Float.parseFloat(next);
							} else if (k%7 == 6) {
								if(jointIndex%23 == 22) {
									next = next.substring(0, next.length()-1);
								}
								jointPos.z = Float.parseFloat(next);
								
								
								String methodName = "set"+jointName;
								//System.out.println(methodName);
								Object[] o = {jointPos, lineNum};
								Method toCall = skeletonClass.getMethod(methodName, params);
								PVector answer = (PVector)(toCall.invoke(skel, o));
								
								jointPos = new PVector();
								jointIndex++;
								//System.out.println(jointName + ": " + jointPos);
							}
							k++;
						}
						//System.out.println(s.next());
						s.close();

						lineNum++;
						//System.out.println(lineNum);
					}

					
					//System.out.println(currentLine);

				}
				System.out.println("lineNum " + lineNum);
				//System.out.println("head: " + skel.Head);
				for(int i = 0; i < lineNum; i ++){
					if(i  == i){
						int emotion = ed.getPosture(skel.getHips(i), skel.getHead(i), skel.getChest(i), skel.getNeck(i), 
								skel.getLeftElbow(i), skel.getLeftHip(i), skel.getLeftShoulder(i),
								skel.getRightElbow(i), skel.getRightHip(i), skel.getRightShoulder(i), skel.getLeftWrist(i), skel.getRightWrist(i));
						
						ed.angles.get(i).add(emotions[emotion]);
						if(!emotions[emotion].equals("No Emotion")) {
							System.out.println(emotions[emotion]);	
						}
					}
				}
				
				String posturesAbsoluteFilePath = "C:\\Users\\Robert\\Documents\\PostureMapping\\Results\\" + "both_"+filepaths[j];
				//System.out.println("Final filepath : " + jointsAbsoluteFilePath);
				System.out.println("Final filepath : " + posturesAbsoluteFilePath);

					
				//File jointsFile = new File(jointsAbsoluteFilePath);
				File posturesFile = new File(posturesAbsoluteFilePath);
				
				try {
					if(posturesFile.createNewFile()){
						System.out.println(filepaths[j] + " was created!");
					} else {
						System.out.println("File already exists");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				PrintWriter pw;
				try {
					pw = new PrintWriter(posturesFile);
					for (ArrayList<String> position : ed.angles){
						for(String p : position) {
							pw.write(p);	
							pw.write("\n");
						}
				    }
					pw.close();
					ed.angles.clear();
					
//					pw = new PrintWriter(posturesFile);
//					for(String posture: posturesDetected) {
//						pw.write(posture);
//					}
//					pw.close();
//					posturesDetected.clear();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.exit(0);

				

			}
			catch(FileNotFoundException ex) {
				System.out.println(
						"Unable to open file '" + 
								fileName + "'");
				System.out.println(ex);
			}
			catch(IOException ex) {
				System.out.println(
						"Error reading file '" 
								+ fileName + "'");                  
				// Or we could just do this: 
				// ex.printStackTrace();
			}
		}

	}


	public static ArrayList<String> initiateJoints(String[] j) {
		ArrayList<String> joints = new ArrayList<String>();
		for (String joint: j){
			joints.add(joint);
		}
		return joints;
	}

}
