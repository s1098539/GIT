package controller;


import model.*;

public class SpeelveldController {
    private static final long serialVersionUID = 1L; //Necessary for RMI Marshalling

    SpeelveldData veldD;

    public SpeelveldData getVeldD() {
        return veldD;
    }

    public void setVeldD(SpeelveldData veldD) {
        this.veldD = veldD;
    }
}