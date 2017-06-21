package Controller;

import Model.Speler;
import Model.Spraak;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class SpraakController {
    SpelController spelC;
    SpelerController spelerC;

    public void setControllers(SpelController spelC, SpelerController spelerC) {
        this.spelC = spelC;
        this.spelerC = spelerC;
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
        wait(waitTime);
    }

    public synchronized void playEindigZet() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getEindig1());
        wait(waitTime);
        audioPlayer(audio.getEindig2());
        wait(waitTime);
        audioPlayer(audio.getEindig3());
        wait(waitTime);
    }

    public synchronized void playHakken() throws Exception{
        int waitTime = 3000;
        audioPlayer(audio.getHakken2());
        wait(waitTime);
        audioPlayer(audio.getHakken1());
        wait(waitTime);

    }

    public synchronized void playOppakken() throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getOppakken());
        wait(waitTime);
    }


    public synchronized void playBlussen() throws Exception{
        int waitTime=3000;
        int waitTime2=5000;
        audioPlayer(audio.getVuurBlussen());
        wait(waitTime);
        audioPlayer(audio.getVuurNaarRook());
        wait(waitTime);
        audioPlayer(audio.getRookBlussen());
        wait(waitTime);
        audioPlayer(audio.getDokterBlussen());
        wait(waitTime);
    }

    public synchronized void playRijden() throws Exception{
        int waitTime=3000;
        int waitTime2=5500;
        audioPlayer(audio.getRijden1());
        wait(waitTime);
        audioPlayer(audio.getRijden2());
        wait(waitTime2);
    }

    public synchronized void playBewegen() throws Exception{
        int waitTime=2500;
        int waitTime2=7500;
        int waitTime3=9000;
        int waitTime4=3500;
        audioPlayer(audio.getBewegen1());
        wait(waitTime);
        audioPlayer(audio.getBewegen2());
        wait(waitTime2);
        audioPlayer(audio.getBewegen3());
        wait(waitTime2);
        audioPlayer(audio.getDokterBehandeld());
        wait(waitTime3);
        audioPlayer(audio.getVuurBewegen());
        wait(waitTime4);
    }

    public synchronized void playSpecial () throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getKlasse());
        wait(waitTime);
    }

    public synchronized void playRolWissel() throws Exception{
        int waitTime=4000;
        audioPlayer(audio.getRolWissel());
        wait(waitTime);
    }

    public synchronized void playWagenBlussen() throws Exception{
        int waitTime=4300;
        int waitTime2=8000;
        audioPlayer(audio.getBrandspuit1());
        wait(waitTime);
        audioPlayer(audio.getBrandspuit2());
        wait(waitTime);
        audioPlayer(audio.getBrandspuit3());
        wait(waitTime2);
    }

    public void playAP(int actiepunten) throws Exception{
        if(actiepunten>=0 && actiepunten<=9){
            switch(actiepunten) {
               case 0:audioPlayer(audio.getAp0());
               break;
               case 1: audioPlayer(audio.getAp1());
               break;
               case 2: audioPlayer(audio.getAp2());
               break;
               case 3: audioPlayer(audio.getAp3());
               break;
               case 4: audioPlayer(audio.getAp4());
               break;
               case 5: audioPlayer(audio.getAp5());
               break;
               case 6: audioPlayer(audio.getAp6());
               break;
               case 7: audioPlayer(audio.getAp7());
               break;
               case 8: audioPlayer(audio.getAp8());
               break;
               case 9: audioPlayer(audio.getAp9());
               break;
            }
        }
    }

    public void playEP(int extrapunten) throws Exception{
        if (extrapunten>=0 && extrapunten<=3) {
            switch (extrapunten) {
                //default WAV moet nog gemaakt worden.
                case 0: audioPlayer(audio.getEp0());
                break;
                case 1: audioPlayer(audio.getEp1());
                break;
                case 2: audioPlayer(audio.getEp2());
                break;
                case 3: audioPlayer(audio.getEp3());
                break;
            }
        }
    }

    public void playPva(int extrapunten) throws Exception{
        if (extrapunten>=1 && extrapunten<=3) {
            switch (extrapunten) {
                //default moet 0 worden WAV komt er nog aan.
                default: audioPlayer(audio.getPva1());
                break;
                case 1: audioPlayer(audio.getPva1());
                break;
                case 2: audioPlayer(audio.getPva2());
                break;
                case 3: audioPlayer(audio.getPva3());
                break;
                case 4: audioPlayer(audio.getPva4());
                break;
                case 5: audioPlayer(audio.getPva5());
                break;
                case 6: audioPlayer(audio.getPva6());
                break;
                case 7: audioPlayer(audio.getPva7());
                break;
            }
        }
    }

}
