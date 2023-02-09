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
    public String getRed() {return Res;
    }

    public FoodHomeModel(String name, String rated, int image, String des, String res) {
        Name = name;
        Rated = rated;
        Image = image;
        Des = des;
        Res = res;

    }

    String Name;
    String Rated;
    String Des;
    String Res;
    int Image;
}
