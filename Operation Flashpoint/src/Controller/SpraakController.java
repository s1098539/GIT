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

    private void audioPlayer(String s) throws Exception {
        InputStream in = new FileInputStream(s);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    public void playSchade() throws Exception {
        audioPlayer(audio.getSchade1());
    }

    public void playEindigZet() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getEindig1());
        audio.wait(waitTime);
        audioPlayer(audio.getEindig2());
        audio.wait(waitTime);
        audioPlayer(audio.getEindig3());
        audio.wait(waitTime);
    }

    public void playHakken() throws Exception{
        int waitTime=3000;
        audioPlayer(audio.getHakken1());
        audio.wait(waitTime);
        audioPlayer(audio.getHakken2());
        audio.wait(waitTime);
    }

}
