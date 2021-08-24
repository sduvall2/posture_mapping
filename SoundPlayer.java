package research;
/*
 * Written by Alex Goslen 2017
 * */
import SimpleOpenNI.SimpleOpenNI;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class SoundPlayer {

	Minim minim;
	AudioPlayer player;
	
	
	
	public SoundPlayer(SimpleOpenNI context) {
		minim = new Minim(context);
		player = null;
		
	}
	
	public void playSound(String fileName) {
		player = minim.loadFile(fileName);
		player.play();
		player.rewind();
		//System.out.println("I was played.");
	}

}
