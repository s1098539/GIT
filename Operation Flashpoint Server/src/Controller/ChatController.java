package Controller;

//delete knoppen hier en maak er methodes van, dan kan je de methodes gebruiken met de knoppen in spelcontroller

/**
 * Created by Joep Oonk on 14-6-2017.
 */


public class ChatController {
    SpeelveldController veldC;
    SpelerController spelerC;
    DobbelsteenController dobbelC;
    SpelController spelC;
    ChatController chatC;



    // Lion, verbind deze controller met 3 andere
    public void setControllers(SpelController spelC, SpeelveldController veldC, SpelerController spelerC, DobbelsteenController dobbelC, ChatController chatC) {
        this.veldC = veldC;
        this.spelC = spelC;
        this.spelerC = spelerC;
        this.dobbelC = dobbelC;
        this.chatC = chatC;

    }

    /* moet nog chatlisten en chatserver object maken, hiervoor moeten we eerst een textinputdialog maken/lobby maken
    om de host in een string op te kunnen slaan */


    //chat groter maken
   public void groterChat() {
       spelC.getChatArea().setPrefHeight(500);
       spelC.getChatArea().setScrollTop(Double.MAX_VALUE);
    }

    //Chat kleiner maken
    public void kleinerChat() {
        spelC.getChatArea().setPrefHeight(50);
        spelC.getChatArea().setScrollTop(Double.MAX_VALUE);
    }

    //berichten sturen
    public void stuurBericht() {
//        spelC.setLocalMessage(spelC.getTextInput().getText());
//        try {
//            spelC.getSender().sendMessageObject(spelC.getUsername(), spelC.getLocalMessage());
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//        spelC.getTextInput().setText("");
    }

}

