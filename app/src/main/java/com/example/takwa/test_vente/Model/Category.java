package com.example.takwa.test_vente.Model;

import java.io.Serializable;

/**
 * Created by takwa on 10/01/2018.
 */

public class Category implements Serializable {

    int id;
    String label;

    // Constructor
//    public Category(int id, String label) {
//        this.id = id;
//        this.label = label;
//    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}

