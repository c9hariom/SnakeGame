package Snake;
//C:\\Users\\ph\\WorkSpaces\\Java\\Snake\\src\\Snake\\Duniya_Haseeno_Ka_Mela_Vs_Husn_Hain_Suhana__(2016_Official_Single_Mix)_Arya_DJ_Bihar-PawanMp3.IN.mp3
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Music {
	public static void main(String[] args) throws Exception {

//		System.out.println("1");
//		URL url = new URL("http://www.edu4java.com/sound/back.wav");
//		System.out.println("2");
//		AudioClip clip = Applet.newAudioClip(url);
//		System.out.println("3");
//		clip.play();
//		System.out.println("4");
//		Thread.sleep(1000);

URL url = new URL("C:\\Users\\ph\\WorkSpaces\\Java\\Snake\\src\\Snake\\Duniya_Haseeno_Ka_Mela_Vs_Husn_Hain_Suhana__(2016_Official_Single_Mix)_Arya_DJ_Bihar-PawanMp3.IN.mp3");

		//URL url = Sound.class.getResource("");
		AudioClip clip = Applet.newAudioClip(url);
		AudioClip clip2 = Applet.newAudioClip(url);
		clip.play();
		Thread.sleep(1000);
		clip2.loop();
		Thread.sleep(20000);
		clip2.stop();
		
		System.out.println("end");
	}
}