package com.example.rate;

public class FoodHomeModel {
    public String getName() {
        return Name;
    }

    public String getRated() {
        return Rated;
    }

    public String getDes() {
        return Des;
    }

    public int getImage() {
        return Image;
    }

    public FoodHomeModel(String name, String rated, int image, String des) {
        Name = name;
        Rated = rated;
        Image = image;
        Des = des;
    }

    String Name;
    String Rated;
    String Des;
    int Image;
}
