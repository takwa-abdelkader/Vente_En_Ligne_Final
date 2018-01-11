package com.example.takwa.test_vente.Model;

/**
 * Created by takwa on 10/01/2018.
 */

public class Product
{

    public String Reference ;
    public String Nom;
    public String description;
    public float prix ;
    public int category;

    //   public Product(String reference, String nom, String description, float prix, int category)
    // {
    //       Reference = reference;
    //       Nom = nom;
    //       this.description = description;
    //       this.prix = prix;
    //      this.category = category;
    //   }


    public void setCategory(int category) {
        this.category = category;
    }

    public void setReference(String reference) {
        Reference = reference;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return Reference;
    }

    public String getNom() {
        return Nom;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public int getCategory() {
        return category;
    }

}
