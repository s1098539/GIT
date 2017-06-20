package Model;

import Controller.SpraakController;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Spraak {

    public Spraak() {
    }

    private void audioPlayer(String s) throws Exception {
        InputStream in = new FileInputStream(s);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);
    }

    //GUI WAV

    public void playSchade1() throws Exception {
        String schade1 = "./src/Resources/Audio/1schade.wav";
        audioPlayer(schade1);
    }

    public void playSchade2() throws Exception {
        String schade2 = "./src/Resources/Audio/2schade.wav";
        audioPlayer(schade2);
    }

    public void playSchade3() throws Exception {
        String schade3 = "./src/Resources/Audio/3schade.wav";
        audioPlayer(schade3);
    }

    public void playSchade4() throws Exception {
        String schade4 = "./src/Resources/Audio/4schade.wav";
        audioPlayer(schade4);
    }

    public void playSchade5() throws Exception {
        String schade5 = "./src/Resources/Audio/5schade.wav";
        audioPlayer(schade5);
    }

    public void playSchade6() throws Exception {
        String schade6 = "./src/Resources/Audio/6schade.wav";
        audioPlayer(schade6);
    }

    public void playSchade7() throws Exception {

        String schade7 = "./src/Resources/Audio/7schade.wav";
        audioPlayer(schade7);
    }

    public void playSchade8() throws Exception {
        String schade8 = "./src/Resources/Audio/8schade.wav";
        audioPlayer(schade8);
    }

    public void playSchade9() throws Exception {

        String schade9 = "./src/Resources/Audio/9schade.wav";
        audioPlayer(schade9);
    }

    public void playSchade10() throws Exception {

        String schade10 = "./src/Resources/Audio/10schade.wav";
        audioPlayer(schade10);
    }

    public void playSchade11() throws Exception {

        String schade11 = "./src/Resources/Audio/11schade.wav";
        audioPlayer(schade11);
    }

    public void playSchade12() throws Exception {

        String schade12 = "./src/Resources/Audio/12schade.wav";
        audioPlayer(schade12);
    }

    public void playSchade13() throws Exception {

        String schade13 = "./src/Resources/Audio/13schade.wav";
        audioPlayer(schade13);
    }

    public void playSchade14() throws Exception {

        String schade14 = "./src/Resources/Audio/14schade.wav";
        audioPlayer(schade14);
    }

    public void playSchade15() throws Exception {

        String schade15 = "./src/Resources/Audio/15schade.wav";
        audioPlayer(schade15);
    }

    public void playSchade16() throws Exception {

        String schade16 = "./src/Resources/Audio/16schade.wav";
        audioPlayer(schade16);
    }

    public void playSchade17() throws Exception {

        String schade17 = "./src/Resources/Audio/17schade.wav";
        audioPlayer(schade17);
    }

    public void playSchade18() throws Exception {

        String schade18 = "./src/Resources/Audio/18schade.wav";
        audioPlayer(schade18);
    }

    public void playSchade19() throws Exception {

        String schade19 = "./src/Resources/Audio/19schade.wav";
        audioPlayer(schade19);
    }

    public void playSchade20() throws Exception {

        String schade20 = "./src/Resources/Audio/20schade.wav";
        audioPlayer(schade20);
    }

    public void playSchade21() throws Exception {

        String schade21 = "./src/Resources/Audio/21schade.wav";
        audioPlayer(schade21);
    }

    public void playSchade22() throws Exception {

        String schade22 = "./src/Resources/Audio/22schade.wav";
        audioPlayer(schade22);

    }

    public void playSchade23() throws Exception {

        String schade23 = "./src/Resources/Audio/23schade.wav";
        audioPlayer(schade23);
    }

    public void playSchade24() throws Exception {
        String schade24 = "./src/Resources/Audio/24schade.wav";
        audioPlayer(schade24);
    }

    public void playAp1() throws Exception {
        String ap1 = "./src/Resources/Audio/1AP.wav";
        audioPlayer(ap1);
    }

    public void playAp2() throws Exception {
        String ap2 = "./src/Resources/Audio/2AP.wav";
        audioPlayer(ap2);
    }

    public void playAp3() throws Exception {
        String ap3 = "./src/Resources/Audio/3AP.wav";
        audioPlayer(ap3);
    }

    public void playAp4() throws Exception {
        String ap4 = "./src/Resources/Audio/4AP.wav";
        audioPlayer(ap4);
    }

    public void playAp5() throws Exception {
        String ap5 = "./src/Resources/Audio/5AP.wav";
        audioPlayer(ap5);
    }

    public void playAp6() throws Exception {
        String ap6 = "./src/Resources/Audio/6AP.wav";
        audioPlayer(ap6);
    }

    public void playAp7() throws Exception {
        String ap7 = "./src/Resources/Audio/7AP.wav";
        audioPlayer(ap7);
    }

    public void playAp8() throws Exception {
        String ap8 = "./src/Resources/Audio/8AP.wav";
        audioPlayer(ap8);
    }

    public void playAp9() throws Exception {
        String ap9 = "./src/Resources/Audio/9AP.wav";
        audioPlayer(ap9);
    }

    public void playEp1() throws Exception {
        String ep1 = "./src/Resources/Audio/1EP.wav";
        audioPlayer(ep1);
    }

    public void playEp2() throws Exception {
        String ep2 = "./src/Resources/Audio/2EP.wav";
        audioPlayer(ep2);
    }

    public void playEp3() throws Exception {
        String ep3 = "./src/Resources/Audio/3EP.wav";
        audioPlayer(ep3);
    }

    public void playPva1() throws Exception {
        String pva1 = "./src/Resources/Audio/1pva.wav";
        audioPlayer(pva1);
    }

    public void playPva2() throws Exception {
        String pva2 = "./src/Resources/Audio/2pva.wav";
        audioPlayer(pva2);
    }

    public void playPva3() throws Exception {
        String pva3 = "./src/Resources/Audio/3pva.wav";
        audioPlayer(pva3);
    }

    public void playPva4() throws Exception {

        String pva4 = "./src/Resources/Audio/4pva.wav";
        audioPlayer(pva4);
    }

    public void playPva5() throws Exception {

        String pva5 = "./src/Resources/Audio/5pva.wav";
        audioPlayer(pva5);
    }

    public void playPva6() throws Exception {

        String pva6 = "./src/Resources/Audio/6pva.wav";
        audioPlayer(pva6);
    }

    public void playPva7() throws Exception {

        String pva7 = "./src/Resources/Audio/7pva.wav";
        audioPlayer(pva7);
    }

    public void playPva8() throws Exception {

        String pva8 = "./src/Resources/Audio/8pva.wav";
        audioPlayer(pva8);
    }

    public void playPva9() throws Exception {

        String pva9 = "./src/Resources/Audio/9pva.wav";
        audioPlayer(pva9);
    }

    public void playPva10() throws Exception {

        String pva10 = "./src/Resources/Audio/10pva.wav";
        audioPlayer(pva10);
    }

    public void playBrandhaarden1() throws Exception {

        String brandhaarden1 = "./src/Resources/Audio/1Haard.wav";
        audioPlayer(brandhaarden1);
    }

    public void playBrandhaarden2() throws Exception {

        String brandhaarden2 = "./src/Resources/Audio/2haard.wav";
        InputStream in = new FileInputStream(brandhaarden2);
        audioPlayer(brandhaarden2);
    }

    public void playBrandhaarden3() throws Exception {

        String brandhaarden3 = "./src/Resources/Audio/3haard.wav";
        audioPlayer(brandhaarden3);
    }

    public void playBrandhaarden4() throws Exception {

        String brandhaarden4 = "./src/Resources/Audio/4haard.wav";
        audioPlayer(brandhaarden4);
    }

    public void playBrandhaarden5() throws Exception {

        String brandhaarden5 = "./src/Resources/Audio/5haard.wav";
        audioPlayer(brandhaarden5);
    }

    public void playBrandhaarden6() throws Exception {

        String brandhaarden6 = "./src/Resources/Audio/6haard.wav";
        audioPlayer(brandhaarden6);
    }

    public void playBewegen1AP() throws Exception {

        String bewegen1 = "./src/Resources/Audio/Bewegen1AP.wav";
        audioPlayer(bewegen1);
    }

    public void playBewegenPvaGS2AP() throws Exception {

        String bewegen2 = "./src/Resources/Audio/BewegenPvaGS2AP.wav";
        audioPlayer(bewegen2);
    }


    public void playBewegenReddingsspecialist3EP() throws Exception {

        String bewegen3 = "./src/Resources/Audio/BewegenReddingsspecialist3EP.wav";
        audioPlayer(bewegen3);
    }


    public void playBrandspuitBedienen4AP() throws Exception {

        String brandspuit1 = "./src/Resources/Audio/BrandspuitBedienen4AP.wav";
        audioPlayer(brandspuit1);
    }

    public void playBrandspuitbedienerKost2AP() throws Exception {

        String brandspuit2 = "./src/Resources/Audio/BrandspuitbedienerKost2AP.wav";
        audioPlayer(brandspuit2);

    }

    public void playBrandspuitbedienerReroll() throws Exception {

        String brandspuit3 = "./src/Resources/Audio/BrandspuitbedienerReroll.wav";
        audioPlayer(brandspuit3);

    }

    public void playDeurOpenenSluiten1AP() throws Exception {

        String deur = "./src/Resources/Audio/DeurOpenenSluiten1AP.wav";
        audioPlayer(deur);
    }

    public void playRolWisselen2AP() throws Exception {
        String rolWissel = "./src/Resources/Audio/RolWisselen2AP.wav";
        audioPlayer(rolWissel);
    }

    public void playDokterBehandelenBewegenGeenExtraAP() throws Exception
    {

        String dokterBehandeld = "./src/Resources/Audio/DokterBehandelenBewegenGeenExtraAP.wav";
        audioPlayer(dokterBehandeld);
    }


    public void playDokterBlussenBetaaltDubbelAP() throws Exception
    {

        String dokterBlussen = "./src/Resources/Audio/DokterBlussenBetaaltDubbelAP.wav";
        audioPlayer(dokterBlussen);

    }

    public void playEindigtZetKnop() throws Exception
    {

        String eindig1 = "./src/Resources/Audio/EindigtZetKnop.wav";
        audioPlayer(eindig1);

    }

    public void playEindigZetAPOvergebleven() throws Exception
    {

        String eindig2 = "./src/Resources/Audio/EindigZetAPOvergebleven.wav";
        audioPlayer(eindig2);
    }

    public void playEindigZetVolgendeSpelerKrijgtBeurt() throws Exception
    {

        String eindig3 = "./src/Resources/Audio/EindigZetVolgendeSpelerKrijgtBeurt.wav";
        audioPlayer(eindig3);

    }

    public void playHakken1APReddingsspecialist() throws Exception
    {

        String hakken1 = "./src/Resources/Audio/Hakken1APReddingsspecialist.wav";
        audioPlayer(hakken1);

    }

    public void playHakken2AP() throws Exception
    {

        String hakken2 = "./src/Resources/Audio/Hakken2AP.wav";
        audioPlayer(hakken2);

    }

    public void playKlasseSpecial() throws Exception
    {
        String klasse = "./src/Resources/Audio/KlasseSpecial.wav";
        audioPlayer(klasse);
    }


    public void playOppakkenKostGeenAP() throws Exception
    {
        String oppakken = "./src/Resources/Audio/OppakkenKostGeenAP.wav";
        audioPlayer(oppakken);

    }

    public void playRijdenMeerijdenKostGeenAP() throws Exception
    {
        String rijden1  = "./src/Resources/Audio/RijdenMeerijdenKostGeenAP.wav";
        audioPlayer(rijden1);
    }

    public void playRijdenKost2AP() throws Exception
    {

        String rijden2 = "./src/Resources/Audio/RijdenKost2AP.wav";
        audioPlayer(rijden2);

    }


    public void playRookBlussen1AP() throws Exception
    {

        String rookBlussen = "./src/Resources/Audio/RookBlussen1AP.wav";
        audioPlayer(rookBlussen);

    }

    public void playVuurNaarRook1AP() throws Exception
    {

        String vuurNaarRook = "./src/Resources/Audio/VuurNaarRook1AP.wav";
        audioPlayer(vuurNaarRook);

    }

    public void playVuurBewegen2AP() throws Exception
    {

        String vuurBewegen = "./src/Resources/Audio/VuurBewegen2AP.wav";
        audioPlayer(vuurBewegen);

    }

    public void playVuurBlussen2AP() throws Exception
    {

        String vuurBlussen = "./src/Resources/Audio/VuurBlussen2AP.wav";
        audioPlayer(vuurBlussen);

    }

    // Specialisten WAV

    public void playDokterSpecialist() throws Exception
    {

        String dokterSpecialist = "./src/Resources/Audio/DokterKlasse.wav";
        audioPlayer(dokterSpecialist);
    }

    public void playBrandspuitbedienerSpecialist() throws Exception
    {

        String brandspuitbedienerSpecialist = "./src/Resources/Audio/BrandspuitbedienerKlasse.wav";
        audioPlayer(brandspuitbedienerSpecialist);
    }

    public void playKapiteinSpecialist() throws Exception
    {

        String kapiteinSpecialist = "./src/Resources/Audio/KapiteinKlasse.wav";
        audioPlayer(kapiteinSpecialist);
    }

    public void playVerkennerSpecialist() throws Exception
    {

        String verkennerSpecialist  = "./src/Resources/Audio/Verkenner.wav";
        audioPlayer(verkennerSpecialist);
    }

    public void playMannetjesputterSpecialist() throws Exception
    {

        String mannetjesputterSpecialist= "./src/Resources/Audio/MannetjesputterKlasse.wav";
        audioPlayer(mannetjesputterSpecialist);
    }

    public void playGevaarlijkestokkenSpecialist() throws Exception
    {

        String gevaarlijkestoffenSpecialist = "./src/Resources/Audio/GevaarlijkeStoffenKlasse.wav";
        audioPlayer(gevaarlijkestoffenSpecialist);
    }

    public void playGaspakdragerSpecialist() throws Exception
    {

        String gaspakdragerSpecialist = "./src/Resources/Audio/GaspakdragerKlasse.wav";
        audioPlayer(gaspakdragerSpecialist);
    }

    public void playReddingsspecialistSpecialist() throws Exception
    {

        String reddingsspecialistSpecialist = "./src/Resources/Audio/ReddingsspecialistKlasse.wav";
        audioPlayer(reddingsspecialistSpecialist);
    }

    // Spelregels WAV

    public void playAangrenzendeVakken() throws Exception
    {

        String aangrenzendeVakken = "./src/Resources/Audio/AangrenzendeVakken.wav";
        audioPlayer(aangrenzendeVakken);
    }

    public void playActieOndernemen() throws Exception
    {

        String actieOndernemen = "./src/Resources/Audio/ActieOndernemen.wav";
        audioPlayer(actieOndernemen);
    }

    public void playBewegenSpel1() throws Exception
    {

        String bewegenSpel1 = "./src/Resources/Audio/BewegenSpel1.wav";
        audioPlayer(bewegenSpel1);
    }

    public void playBewegenSpel2() throws Exception
    {

        String bewegenSpel2 = "./src/Resources/Audio/BewegenSpel2.wav";
        audioPlayer(bewegenSpel2);
    }

    public void playBewegenSpel3() throws Exception
    {
        String bewegenSpel3 = "./src/Resources/Audio/BewegenSpel3.wav";
        audioPlayer(bewegenSpel3);
    }

    public void playDeurRegels() throws Exception
    {
        String deurActies = "./src/Resources/Audio/DeurOpenenSluiten1AP.wav";
        audioPlayer(deurActies);
    }

    public void playDoelVanHetSpel() throws Exception
    {
        String doelSpel = "./src/Resources/Audio/DoelVanHetSpel.wav";
        audioPlayer(doelSpel);
    }

    public void playDoven() throws Exception
    {
        String doven  = "./src/Resources/Audio/Doven.wav";
        audioPlayer(doven);
    }

    public void playHetSpeleinde() throws Exception
    {
        String spelEinde = "./src/Resources/Audio/HetSpeleinde.wav";
        audioPlayer(spelEinde);
    }

    public void playHouwen() throws Exception
    {
        String houwen = "./src/Resources/Audio/Houwen.wav";
        audioPlayer(houwen);
    }


    public void playOmvergeblazenBrandweermannen() throws Exception
    {
        String omvergeblazenBrandweermannen = "./src/Resources/Audio/OmvergeblazenBrandweermannen.wav";
        audioPlayer(omvergeblazenBrandweermannen);
    }

    public void playOntploffingen1() throws Exception
    {

        String ontploffingen1 = "./src/Resources/Audio/Ontploffingen1.wav";
        audioPlayer(ontploffingen1);
    }

    public void playOntploffingen2() throws Exception
    {

        String ontploffingen2  = "./src/Resources/Audio/Ontploffingen2.wav";
        audioPlayer(ontploffingen2);
    }

    public void playOntploffingenGevolgSchokgolf() throws Exception
    {

        String gevolgSchokgolf = "./src/Resources/Audio/OntploffingenGevolgSchokgolf.wav";
        audioPlayer(gevolgSchokgolf);
    }

    public void playOverslaandeBrand() throws Exception
    {

        String overslaandeBrand = "./src/Resources/Audio/OverslaandeBrand.wav";
        audioPlayer(overslaandeBrand);
    }
}





