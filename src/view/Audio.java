package view;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import view.viewInterface.IAudio;

public class Audio implements IAudio{
	private Clip clip;
 /**
  * Play a sound in wav formats
  * @param sound
  * 			String which contain the path to the sound
  * 
  *@param gain
  *				the gain of the sound
  */
	 public  void playSound(File sound, float gain) {
		try{	
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(sound));
		clip.start();
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(gain);
		}
		catch(Exception e){
		}
		

	}	
	 
	 /* (non-Javadoc)
	 * @see view.IAudio#stopSound()
	 */
	public void stopSound(){
		clip.stop();
	}
}
