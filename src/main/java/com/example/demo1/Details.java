package com.example.demo1;

import javafx.scene.image.ImageView;

public class Details {
    private ImageView Hero,FruitImage;
    private int Score,Fruits;

    public ImageView getHero() {
        return Hero;
    }

    public void setHero(ImageView hero) {
        Hero = hero;
    }

    public ImageView getFruitImage() {
        return FruitImage;
    }

    public void setFruitImage(ImageView fruitImage) {
        FruitImage = fruitImage;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getFruits() {
        return Fruits;
    }

    public void setFruits(int fruits) {
        Fruits = fruits;
    }
}
