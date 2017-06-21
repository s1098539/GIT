package Controller;

import Model.Spraak;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class SpraakController {
    SpelController spelC;

    public void setController(SpelController spelC) {
        this.spelC = spelC;
    }

    public SpraakController() {
    }

    Spraak audio = new Spraak();
//    boolean play=false;

    private void audioPlayer(String s) throws Exception {
        InputStream in = new FileInputStream(s);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
//            if(!play){
//                AudioPlayer.player.stop(audioStream);
//            }
    }

//    public void audioStopper(boolean play){
//        if(play) {
//            this.play = false;
//        }
//    }


    public void playSchade() throws Exception {
        audioPlayer(audio.getSchade1());
    }

    public synchronized void playDeurActies() throws Exception{
        int waitTime=4500;
        audioPlayer(audio.getDeur());
        audio.wait(waitTime);
    }

    public synchronized void playEindigZet() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getEindig1());
        audio.wait(waitTime);
        audioPlayer(audio.getEindig2());
        audio.wait(waitTime);
        audioPlayer(audio.getEindig3());
        audio.wait(waitTime);
    }

    public synchronized void playHakken() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getHakken2());
        audio.wait(waitTime);
        audioPlayer(audio.getHakken1());
        audio.wait(waitTime);

    }

    public synchronized void playOppakken() throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getOppakken());
        audio.wait(waitTime);
    }


    public synchronized void playBlussen() throws Exception{
        int waitTime=3000;
        audioPlayer(audio.getVuurBlussen());
        audio.wait(waitTime);
        audioPlayer(audio.getVuurNaarRook());
        audio.wait(waitTime);
        audioPlayer(audio.getRookBlussen());
        audio.wait(waitTime);
        audioPlayer(audio.getDokterBlussen());
        audio.wait(waitTime);
    }

    public synchronized void playRijden() throws Exception{
        int waitTime=4500;
        int waitTime2=5500;
        audioPlayer(audio.getRijden1());
        audio.wait(waitTime);
        audioPlayer(audio.getRijden2());
        audio.wait(waitTime2);
    }

    public synchronized void playBewegen() throws Exception{
        int waitTime=2500;
        int waitTime2=7500;
        int waitTime3=9000;
        int waitTime4=3500;
        audioPlayer(audio.getBewegen1());
        audio.wait(waitTime);
        audioPlayer(audio.getBewegen2());
        audio.wait(waitTime);
        audioPlayer(audio.getBewegen3());
        audio.wait(waitTime);
    }

    public synchronized void playSpecial () throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getKlasse());
        audio.wait(waitTime);
    }

}
