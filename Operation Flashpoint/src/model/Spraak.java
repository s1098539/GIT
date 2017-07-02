package model;

import java.io.File;

public class Spraak {

    public Spraak() {
    }
    //Calvin, De methodes die dit model aanroepen vind u in de spraakcontroller klasse

    //Hier zijn de Guide User Interface ondersteunde geluiden te vinden.
    //Dit model bevat de paden naar de audio bestanden.
    // De view kan getallen(ook wel counters) uitlezen door middel van de onderstaande geluiden.
    // De view kan ook actieknoppen uilezen, bijvoorbeeld: bewegen, oppakken en blussen.


    // Counters op de view
    private String schade0 = "./src/resources/audio/0schade.wav";
    private String schade1 = "./src/resources/audio/1schade.wav";
    private String schade2 = "./src/resources/audio/2schade.wav";
    private String schade3 = "./src/resources/audio/3schade.wav";
    private String schade4 = "./src/resources/audio/4schade.wav";
    private String schade5 = "./src/resources/audio/5schade.wav";
    private String schade6 = "./src/resources/audio/6schade.wav";
    private String schade7 = "./src/resources/audio/7schade.wav";
    private String schade8 = "./src/resources/audio/8schade.wav";
    private String schade9 = "./src/resources/audio/9schade.wav";
    private String schade10 = "./src/resources/audio/10schade.wav";
    private String schade11 = "./src/resources/audio/11schade.wav";
    private String schade12 = "./src/resources/audio/12schade.wav";
    private String schade13 = "./src/resources/audio/13schade.wav";
    private String schade14 = "./src/resources/audio/14schade.wav";
    private String schade15 = "./src/resources/audio/15schade.wav";
    private String schade16 = "./src/resources/audio/16schade.wav";
    private String schade17 = "./src/resources/audio/17schade.wav";
    private String schade18 = "./src/resources/audio/18schade.wav";
    private String schade19 = "./src/resources/audio/19schade.wav";
    private String schade20 = "./src/resources/audio/20schade.wav";
    private String schade21 = "./src/resources/audio/21schade.wav";
    private String schade22 = "./src/resources/audio/22schade.wav";
    private String schade23 = "./src/resources/audio/23schade.wav";
    private String schade24 = "./src/resources/audio/24schade.wav";
    private String eindig1 = "./src/resources/audio/EindigtZetKnop.wav";
    private String eindig2 = "./src/resources/audio/EindigZetAPOvergebleven.wav";
    private String eindig3 = "./src/resources/audio/EindigZetVolgendeSpelerKrijgtBeurt.wav";
    private String ap0 = "./src/resources/audio/0AP.wav";
    private String ap1 = "./src/resources/audio/1AP.wav";
    private String ap2 = "./src/resources/audio/2AP.wav";
    private String ap3 = "./src/resources/audio/3AP.wav";
    private String ap4 = "./src/resources/audio/4AP.wav";
    private String ap5 = "./src/resources/audio/5AP.wav";
    private String ap6 = "./src/resources/audio/6AP.wav";
    private String ap7 = "./src/resources/audio/7AP.wav";
    private String ap8 = "./src/resources/audio/8AP.wav";
    private String ap9 = "./src/resources/audio/9AP.wav";
    private String ep0 = "./src/resources/audio/0EP.wav";
    private String ep1 = "./src/resources/audio/1EP.wav";
    private String ep2 = "./src/resources/audio/2EP.wav";
    private String ep3 = "./src/resources/audio/3EP.wav";
    private String pva0 = "./src/resources/audio/0pva.wav";
    private String pva1 = "./src/resources/audio/1pva.wav";
    private String pva2 = "./src/resources/audio/2pva.wav";
    private String pva3 = "./src/resources/audio/3pva.wav";
    private String pva4 = "./src/resources/audio/4pva.wav";
    private String pva5 = "./src/resources/audio/5pva.wav";
    private String pva6 = "./src/resources/audio/6pva.wav";
    private String pva7 = "./src/resources/audio/7pva.wav";
    private String vermist0 = "./src/resources/audio/0vermist.wav";
    private String vermist1 = "./src/resources/audio/1vermist.wav";
    private String vermist2 = "./src/resources/audio/2vermist.wav";
    private String vermist3 = "./src/resources/audio/3vermist.wav";
    private String brandhaarden1 = "./src/resources/audio/1Haard.wav";
    private String brandhaarden2 = "./src/resources/audio/2haard.wav";
    private String brandhaarden3 = "./src/resources/audio/3haard.wav";
    private String brandhaarden4 = "./src/resources/audio/4haard.wav";
    private String brandhaarden5 = "./src/resources/audio/5haard.wav";
    private String brandhaarden6 = "./src/resources/audio/6haard.wav";

    // De audiobestanden van de kosten van alle acties kunt u hier vinden.
    private String bewegen1 = "./src/resources/audio/Bewegen1AP.wav";
    private String bewegen2 = "./src/resources/audio/BewegenPvaGS2AP.wav";
    private String bewegenReddingsSpecialist = "./src/resources/audio/BewegenReddingsspecialist3EP.wav";
    private String brandspuit1 = "./src/resources/audio/BrandspuitBedienen4AP.wav";
    private String brandspuit2 = "./src/resources/audio/BrandspuitbedienerKost2AP.wav";
    private String brandspuit3 = "./src/resources/audio/BrandspuitbedienerReroll.wav";
    private String deur = "./src/resources/audio/DeurOpenenSluiten1AP.wav";
    private String rolWissel = "./src/resources/audio/RolWisselen2AP.wav";
    private String dokterBehandeld = "./src/resources/audio/DokterBehandelenBewegenGeenExtraAP.wav";
    private String dokterBlussen = "./src/resources/audio/DokterBlussenBetaaltDubbelAP.wav";
    private String reddingsSpecialistBlussen = "./src/resources/audio/ReddingsspecialistBlussenBetaaltDubbelAP.wav";
    private String hakken1 = "./src/resources/audio/Hakken1APReddingsspecialist.wav";
    private String hakken2 = "./src/resources/audio/Hakken2AP.wav";
    private String klasse = "./src/resources/audio/KlasseSpecial.wav";
    private String oppakken = "./src/resources/audio/OppakkenKostGeenAP.wav";
    private String rijden1 = "./src/resources/audio/RijdenKost2AP.wav";
    private String rijden2  = "./src/resources/audio/RijdenMeerijdenKostGeenAP.wav";
    private String rookBlussen = "./src/resources/audio/RookBlussen1AP.wav";
    private String vuurNaarRook = "./src/resources/audio/VuurNaarRook1AP.wav";
    private String vuurBewegen = "./src/resources/audio/VuurBewegen2AP.wav";

    // De audiobestanden van de unieke mogelijkheden van de verschillende specialisten stan hier.

    private String dokterSpecialist = "./src/resources/audio/DokterKlasse.wav";
    private String brandspuitbedienerSpecialist = "./src/resources/audio/BrandspuitbedienerKlasse.wav";
    private String kapiteinSpecialist = "./src/resources/audio/KapiteinKlasse.wav";
    private String verkennerSpecialist  = "./src/resources/audio/VerkennerKlasse.wav";
    private String mannetjesputterSpecialist= "./src/resources/audio/MannetjesputterKlasse.wav";
    private String gevaarlijkestoffenSpecialist = "./src/resources/audio/GevaarlijkeStoffenKlasse.wav";
    private String gaspakdragerSpecialist = "./src/resources/audio/GaspakdragerKlasse.wav";
    private String reddingsspecialistSpecialist = "./src/resources/audio/ReddingsspecialistKlasse.wav";

    // Hier staan de audiobestanden van de relevante spelregels van onze versie van het spel.
    // Deze dienen als ondersteuning van slechtziende die de regels niet kunnen lezen.

    private String aangrenzendeVakken = "./src/resources/audio/AangrenzendeVakken.wav";
    private String actieOndernemen = "./src/resources/audio/ActieOndernemen.wav";
    private String bewegenSpel1 = "./src/resources/audio/BewegenSpel1.wav";
    private String bewegenSpel2 = "./src/resources/audio/BewegenSpel2.wav";
    private String bewegenSpel3 = "./src/resources/audio/BewegenSpel3.wav";
    private String deurRegels = "./src/resources/audio/DeurOpenenSluiten1AP.wav";
    private String doelSpel = "./src/resources/audio/DoelVanHetSpel.wav";
    private String doven  = "./src/resources/audio/Doven.wav";
    private String spelEinde = "./src/resources/audio/HetSpeleinde.wav";
    private String houwen = "./src/resources/audio/Houwen.wav";
    private String omvergeblazenBrandweermannen = "./src/resources/audio/OmvergeblazenBrandweermannen.wav";
    private String ontploffingen1 = "./src/resources/audio/Ontploffingen1.wav";
    private String ontploffingen2  = "./src/resources/audio/Ontploffingen2.wav";
    private String gevolgSchokgolf = "./src/resources/audio/OntploffingenGevolgSchokgolf.wav";
    private String overslaandeBrand = "./src/resources/audio/OverslaandeBrand.wav";

    // Eenvoudige samenvoeging van alle audiobestanden tot één bestand zodat deze met gemak
    // volledig beluisterd kan worden.
    // Audiobestand bevat de bovenstaande audio spelregelaudio.
    // Hiermee is de mogelijkheid om specifieke stukken af te spelen, en het geheel.
    // Dit moet echter nog geïmplementeerd worden.

    private String spelRegels = "./src/resources/audio/Spelregels.wav";

    private File spelregels = new File("./src/resources/audio/Spelregels.wav");

    public File getSpelregels() {
        return spelregels;
    }

    // Vanaf hier staan de getters.
    // In dit bestand zal u geen setters vinden, omdat deze niet nodig zijn.
    // In een ergere situatie kan het gebeuren dat de audiopaden worden aangepast en hier mee
    // deze functionaliteit wegvalt.
    // Hierom zijn alleen getters van belang.
    // Je wil alleen aan het systeem melden waar deze heen de audio kan vinden.

    // Getters van de SchadeCounter
    // Hier kan je de audio getten wat uitleest hoeveel schadeblokjes op het speelveld staan

    public String getSchade0() {
        return schade0;
    }

    public String getSchade1() {
        return schade1;
    }

    public String getSchade2() {
        return schade2;
    }

    public String getSchade3() {
        return schade3;
    }

    public String getSchade4() {
        return schade4;
    }

    public String getSchade5() {
        return schade5;
    }

    public String getSchade6() {
        return schade6;
    }

    public String getSchade7() {
        return schade7;
    }

    public String getSchade8() {
        return schade8;
    }

    public String getSchade9() {
        return schade9;
    }

    public String getSchade10() {
        return schade10;
    }

    public String getSchade11() {
        return schade11;
    }

    public String getSchade12() {
        return schade12;
    }

    public String getSchade13() {
        return schade13;
    }

    public String getSchade14() {
        return schade14;
    }

    public String getSchade15() {
        return schade15;
    }

    public String getSchade16() {
        return schade16;
    }

    public String getSchade17() {
        return schade17;
    }

    public String getSchade18() {
        return schade18;
    }

    public String getSchade19() {
        return schade19;
    }

    public String getSchade20() {
        return schade20;
    }

    public String getSchade21() {
        return schade21;
    }

    public String getSchade22() {
        return schade22;
    }

    public String getSchade23() {
        return schade23;
    }

    public String getSchade24() {
        return schade24;
    }

    // Getters van de Eindig zet knop
    // Hier kan je de audio getten wat uitleest wat de eindig zet knop onder andere doet.

    public String getEindig1() {
        return eindig1;
    }

    public String getEindig2() {
        return eindig2;
    }

    public String getEindig3() {
        return eindig3;
    }

    // Getters van de Actiepunten Counter
    // Hier kan je de audio getten wat uitleest hoeveel actiepunten je speler

    public String getAp0() { return ap0; }

    public String getAp1() {
        return ap1;
    }

    public String getAp2() {
        return ap2;
    }

    public String getAp3() {
        return ap3;
    }

    public String getAp4() {
        return ap4;
    }

    public String getAp5() {
        return ap5;
    }

    public String getAp6() {
        return ap6;
    }

    public String getAp7() {
        return ap7;
    }

    public String getAp8() {
        return ap8;
    }

    public String getAp9() {
        return ap9;
    }

    // Getters van de Extrapunten
    // Hier kan je de audio getten wat uitleest hoeveel extrapunten een speler bezit

    public String getEp0() {
        return ep0;
    }

    public String getEp1() {
        return ep1;
    }

    public String getEp2() {
        return ep2;
    }

    public String getEp3() {
        return ep3;
    }

    // Getters van de geredde personen van aandacht Counter
    // Hier kan je de audio getten wat uitleest hoeveel personen van aandacht gered zijn.

    public String getPva0() {
        return pva0;
    }

    public String getPva1() {
        return pva1;
    }

    public String getPva2() {
        return pva2;
    }

    public String getPva3() {
        return pva3;
    }

    public String getPva4() {
        return pva4;
    }

    public String getPva5() {
        return pva5;
    }

    public String getPva6() {
        return pva6;
    }

    public String getPva7() {
        return pva7;
    }

    public String getVermist0() {
        return vermist0;
    }

    public String getVermist1() {
        return vermist1;
    }

    public String getVermist2() {
        return vermist2;
    }

    public String getVermist3() {
        return vermist3;
    }

    // Getters van de brandhaarden Counter
    // Hier kan je de audio getten wat uitleest hoeveel brandhaarden op het speelveld staan

    public String getBrandhaarden1() {
        return brandhaarden1;
    }

    public String getBrandhaarden2() {
        return brandhaarden2;
    }

    public String getBrandhaarden3() {
        return brandhaarden3;
    }

    public String getBrandhaarden4() {
        return brandhaarden4;
    }

    public String getBrandhaarden5() {
        return brandhaarden5;
    }

    public String getBrandhaarden6() {
        return brandhaarden6;
    }

    // Getters van de beweegknoppen
    // Hier kan je de audio getten wat de mogelijkheden van de beweegknoppen uitleest.

    public String getBewegen1() {
        return bewegen1;
    }

    public String getBewegen2() {
        return bewegen2;
    }

    public String getVuurBewegen() {
        return vuurBewegen;
    }

    public String getBewegenReddingsSpecialist() {
        return bewegenReddingsSpecialist;
    }

    // Getters van de knop brandspuit
    // Hier kan je de audio getten wat de mogelijkheden van de brandspuit uitleest.

    public String getBrandspuit1() {
        return brandspuit1;
    }

    public String getBrandspuit2() {
        return brandspuit2;
    }

    public String getBrandspuit3() {
        return brandspuit3;
    }

    // getters audio actiepunten kosten.

    public String getDeur() {
        return deur;
    }

    public String getRolWissel() {
        return rolWissel;
    }

    public String getHakken1() {
        return hakken1;
    }

    public String getHakken2() {
        return hakken2;
    }

    public String getKlasse() {
        return klasse;
    }

    public String getOppakken() {
        return oppakken;
    }

    public String getRijden1() {
        return rijden1;
    }

    public String getRijden2() {
        return rijden2;
    }

    public String getRookBlussen() {
        return rookBlussen;
    }

    public String getVuurNaarRook() {
        return vuurNaarRook;
    }

    // getters audio Klasseuitzonderingen wat het bedrag van de actiepunten beïnvoed.

    public String getDokterBehandeld() {
        return dokterBehandeld;
    }

    public String getDokterBlussen() {
        return dokterBlussen;
    }

    public String getReddingsSpecialistBlussen() {
        return reddingsSpecialistBlussen;
    }

    // Getters van de audio van de unieke en klassespecifieke handelingen

    public String getDokterSpecialist() {
        return dokterSpecialist;
    }

    public String getBrandspuitbedienerSpecialist() {
        return brandspuitbedienerSpecialist;
    }

    public String getKapiteinSpecialist() {
        return kapiteinSpecialist;
    }

    public String getVerkennerSpecialist() {
        return verkennerSpecialist;
    }

    public String getMannetjesputterSpecialist() {
        return mannetjesputterSpecialist;
    }

    public String getGevaarlijkestoffenSpecialist() {
        return gevaarlijkestoffenSpecialist;
    }

    public String getGaspakdragerSpecialist() {
        return gaspakdragerSpecialist;
    }

    public String getReddingsspecialistSpecialist() {
        return reddingsspecialistSpecialist;
    }

    // getters van de audio van de spelregels

    public String getAangrenzendeVakken() {
        return aangrenzendeVakken;
    }

    public String getActieOndernemen() {
        return actieOndernemen;
    }

    public String getBewegenSpel1() {
        return bewegenSpel1;
    }

    public String getBewegenSpel2() {
        return bewegenSpel2;
    }

    public String getBewegenSpel3() {
        return bewegenSpel3;
    }

    public String getDeurRegels() {
        return deurRegels;
    }

    public String getDoelSpel() {
        return doelSpel;
    }

    public String getDoven() {
        return doven;
    }

    public String getSpelEinde() {
        return spelEinde;
    }

    public String getHouwen() {
        return houwen;
    }

    public String getOmvergeblazenBrandweermannen() {
        return omvergeblazenBrandweermannen;
    }

    public String getOntploffingen1() {
        return ontploffingen1;
    }

    public String getOntploffingen2() {
        return ontploffingen2;
    }

    public String getGevolgSchokgolf() {
        return gevolgSchokgolf;
    }

    public String getOverslaandeBrand() {
        return overslaandeBrand;
    }

    public String getSpelRegels() {
        return spelRegels;
    }

}