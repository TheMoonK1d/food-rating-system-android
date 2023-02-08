package com.example.rate;

public class FoodHomeModel {
    public String getName() {
        return Name;
    }

    public String getRated() {
        return Rated;
    }

    public int getImage() {
        return Image;
    }

    public FoodHomeModel(String name, String rated, int image) {
        Name = name;
        Rated = rated;
        Image = image;
    }

    String Name;
    String Rated;
    int Image;
}
