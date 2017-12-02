package com.example.philippe.lab02;

/**
 * Created by Philippe on 2017-11-30.
 */

public class Journee {

    private String nom;
    private int adresseImage;
    private String message;

    public Journee(String nom, int adresseImage, String message) {
        this.nom = nom;
        this.adresseImage = adresseImage;
        this.message = message;
    }

    public String getNom() {
        return nom;
    }

    public int getAdresseImage() {
        return adresseImage;
    }

    public Journee(String message) {
        this.message = message;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresseImage(int adresseImage) {
        this.adresseImage = adresseImage;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
