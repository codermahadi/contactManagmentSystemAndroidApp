package com.example.contactmanagementsystem.models;

public class Contact {

    private String name;
    private String phn;
    private int photo;

    public Contact(String name, String phn, int photo) {
        this.name = name;
        this.phn = phn;
        this.photo = photo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
