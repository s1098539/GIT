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

        audioPlayer(audio.getEindig2());

        audioPlayer(audio.getEindig3());

    }

    public void playHakken() throws Exception{
        audioPlayer(audio.getHakken1());
    }

}
