package com.example.student.navigationdrawerfiles;

public class NavigationDrawerItems {
    String name, profile;
    int img;

    public NavigationDrawerItems(String name, String profile, int img){
        this.name = name;
        this.profile = profile;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
