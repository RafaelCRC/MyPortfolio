package com.example.myportifolio.skills;

import java.io.Serializable;

public class SkillsItem implements Serializable {

    private int image;
    private String tittle,description;

    public SkillsItem() {
    }

    public SkillsItem(int image){
        this.image = image;
    }

    public SkillsItem(int image, String tittle) {
        this.image = image;
        this.tittle = tittle;
    }

    public SkillsItem(int image, String tittle, String description) {
        this.image = image;
        this.tittle = tittle;
        this.description = description;
    }


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
