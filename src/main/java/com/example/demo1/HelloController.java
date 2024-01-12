package com.example.demo1;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

import static javafx.fxml.FXMLLoader.load;
//import javax.swing.text.html.ImageView;

public class HelloController implements Initializable {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private Label welcomeText;

    @FXML
    private Rectangle StartingBlock;

    @FXML
    private ImageView newGameButton;

    @FXML
    private ImageView SavedGameButton;

    @FXML
    ImageView IntroBhai;


    @FXML
    ImageView IntroBgSet;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private String testInt;

    public void setTestInt(String testint) {
        testInt = testint;
    }

    public String getTestInt(){
        return this.testInt;
    }

    public void textWrite(ActionEvent event){
        System.out.println("Button pressed.");
    }

    public void starting(){
        newGameButton.setVisible(false);
        SavedGameButton.setVisible(false);
    }
    public void playClick(MouseEvent event){
//        playButton.setVisible(false);
        newGameButton.setVisible(true);
        SavedGameButton.setVisible(true);

    }
    public void startNewGame(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGame.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//        System.out.println("one");
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("AmongUsBhai.png")));
////        System.out.println("two");
//        IntroBhai.setImage(image);
//        System.out.println("three");
        System.out.println(testInt);
//        System.out.println("four");
//        setTestInt("Hello");
        System.out.println(testInt);
        mainPane.getChildren().remove(newGameButton);
        mainPane.getChildren().remove(SavedGameButton);

        TranslateTransition BhaiMove = new TranslateTransition();
        BhaiMove.setNode(IntroBhai);
        BhaiMove.setDuration(Duration.seconds(2));
        BhaiMove.setByX(-252);
        TranslateTransition RectangleMove = new TranslateTransition();
        RectangleMove.setNode(StartingBlock);
        RectangleMove.setDuration(Duration.seconds(2));
        RectangleMove.setByX(-252);
//        translate.play();
        ParallelTransition pt = new ParallelTransition(BhaiMove, RectangleMove);
        pt.setOnFinished((ActionEvent event1) -> {
            try {
                switchToMainGame(scene,stage,loader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        pt.play();

    }

    private void switchToMainGame(Scene scene, Stage stage, FXMLLoader loader) throws IOException {
        scene = new Scene(root);
        MainGame gameController = loader.getController();
        gameController.appearMovingBlock();

        stage.setScene(scene);
        stage.show();
    }

    public void SavedGame(MouseEvent event) throws IOException {
        int score = 0;
        Scanner sc = new Scanner(new File("output.txt"));
//        while (sc.hasNext()) {
////            score = Integer.parseInt(sc.next());
//        }
        sc.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGame.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        MainGame gameController = loader.getController();
        gameController.setScore(4);
        gameController.appearMovingBlock();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
//
//
//    public void changeImage(){
//        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Cherry.jpeg")));
//        IntroBhai.setImage(image);
//    }
}

