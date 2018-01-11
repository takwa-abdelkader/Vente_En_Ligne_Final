package com.example.takwa.test_vente.Model;

/**
 * Created by takwa on 11/01/2018.
 */

public class Client
{
    Integer id;
    String  nom ;
    String prenom ;
    Integer  tel ;
    String  pm ;
    String email ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String adresse) {
        this.email = email;
    }
    public Client(int id, String nom, String prenom, int tel, String pm, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.pm = pm;
        this.email = email;
    }

    public Client(String pm, String email) {
        this.pm = pm;
        this.email = email;
    }

    public Client() {

    }
}
