package com.example.takwa.test_vente.Model;

/**
 * Created by takwa on 11/01/2018.
 */

public class Post {
    String ref;
    String nom ;
    String prix ;
    String qt ;

    public Post() {
    }

    public Post(String ref, String nom, String prix, String qt) {
        this.ref = ref;
        this.nom = nom;
        this.prix = prix;
        this.qt = qt;}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQt() {
        return qt;
    }

    public void setQt(String qt) {
        this.qt = qt;
    }
}
