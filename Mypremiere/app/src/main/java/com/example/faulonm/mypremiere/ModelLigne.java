package com.example.faulonm.mypremiere;

public class ModelLigne {

    private String textPrenom;
    private String imagePath;
    private String textNom;

    public ModelLigne(String textPrenom, String imagePath, String textNom) {
        this.textPrenom = textPrenom;
        this.imagePath = imagePath;
        this.textNom = textNom;
    }

    public String getTextPrenom() {
        return textPrenom;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTextNom() {
        return textNom;
    }
}
