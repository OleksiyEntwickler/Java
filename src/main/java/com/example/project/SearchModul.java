package com.example.project;

public class SearchModul {
    String titel;
    String land;
    String typen;
    String beschreibung;
    String bild;
    String link;
    String bild2;
    String bild3;

    public SearchModul(String titel, String land, String typen, String beschreibung, String bild, String bild2, String bild3, String link) {
        this.titel = titel;
        this.land = land;
        this.typen = typen;
        this.beschreibung = beschreibung;
        this.bild = bild;
        this.bild2 = bild2;
        this.bild3 = bild3;
        this.link = link;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getTypen() {
        return typen;
    }

    public void setTypen(String typen) {
        this.typen = typen;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getBild2() {return bild2;}

    public void setBild2(String bild2) {this.bild2 = bild2;}

    public String getBild3() {return bild3;}

    public void setBild3(String bild3) {this.bild3 = bild3;}
}
