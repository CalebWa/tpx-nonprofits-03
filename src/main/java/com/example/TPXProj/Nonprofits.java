package com.example.TPXProj;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Nonprofits {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
