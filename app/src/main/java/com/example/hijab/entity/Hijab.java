package com.example.hijab.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hijab {

    private String name;
    private String image;

    @PrimaryKey(autoGenerate = true)
    private long id;

    public Hijab(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Hijab() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
