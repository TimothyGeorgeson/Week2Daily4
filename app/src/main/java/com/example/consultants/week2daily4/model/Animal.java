package com.example.consultants.week2daily4.model;

public class Animal {
    String category;
    String name;
    String weight;
    byte[] picture;
    int sound;

    public Animal(String category, String name, String weight, byte[] picture, int sound) {
        this.category = category;
        this.name = name;
        this.weight = weight;
        this.picture = picture;
        this.sound = sound;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }
}
