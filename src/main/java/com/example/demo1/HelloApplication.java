package com.example.demo1;

// DESIGN PATTERNS USED:
//1) Singleton - We have used only one hero in the main game slide. When we change the hero when top left button is pressed, the same image gets updated and another object is not created.
//Also we have used only 1 block for standing, one block for moving and only one cherry which appears and disappears.
//2) Flyweight - We have used only one user at a time for playing game and checked for it that it doesn't get entered by another person.
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("IntroPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("STICK HERO");
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("StickBhai-removebg.png")));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();

    }
    public static void main(String[] args) {
        launch();
//        starting();
    }
}