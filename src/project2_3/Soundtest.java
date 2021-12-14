package project2_3;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Soundtest {
	public void abc() {
		File bgm;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		
		bgm = new File("D:\\3학년 전공\\workspace\\project2_3/sound 03.wav"); 
		
		Clip clip;
		
		try {
			stream = AudioSystem.getAudioInputStream(bgm);
			format = stream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			clip = (Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			
		} catch (Exception e) {
			System.out.println("err : " + e);
			}
		
	}
	
}

/*	public static void main(String[] args) {
		MediaTest test = new MediaTest();
		while(true) {
			try {
				test.abc();
				Thread.sleep(3000); // 3초에 한번씩 재생하도록 설정
			} catch(Exception e) {
				
			}
		}

	}

}*/ // 사운드 test
