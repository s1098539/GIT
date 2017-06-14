//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
//import javax.sound.sampled.LineUnavailableException;
//import java.io.File;
//import java.io.IOException;
//
///**
// * Created by Acer on 9-6-2017.
// */
//public class Audio2 {
//
//    public void playSound(int i)
//    {
//        try
//        {
//        .  //Others buttons sound
//        .  //Others buttons sound
//            if(i == 3 || i == 4)
//            {
//                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Background.wav"));
//                Clip clip3 = AudioSystem.getClip( );
//                clip3.open(audioInputStream);
//                if(i == 3)
//                {
//                    clip3.loop(Clip.LOOP_CONTINUOUSLY);
//                    clip3.start();
//                    settingSubMenuItem3.setEnabled(false);
//                    settingSubMenuItem4.setEnabled(true);
//                }
//                if(i == 4)
//                {
//                    clip3.stop();
//                    settingSubMenuItem3.setEnabled(true);
//                    settingSubMenuItem4.setEnabled(false);
//                }
//            }
//    catch(Exception e)
//            {
//                System.out.println("Error with playing sound.");
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (LineUnavailableException e) {
//            e.printStackTrace();
//        }
//    }
