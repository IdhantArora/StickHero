package com.example.demo1;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class ReviveScreen {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;
    @FXML
    private ImageView IntroBhai;

    @FXML
    private Button reviveButton;
    @FXML
    private Button quitButton;

    private int score,cherries;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    TranslateTransition transition = new TranslateTransition();

    public void tillRevive(){
            transition.setNode(IntroBhai);
            transition.setDuration(Duration.seconds(2));
            transition.setByY(-150);
            transition.setAutoReverse(true);
            transition.setCycleCount(TranslateTransition.INDEFINITE);
            transition.play();

    }

    public void quit(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGamePage.fxml")));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }

    public void revive(ActionEvent event) throws IOException {
            if (getCherries() >= 3) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGame.fxml"));
                root = loader.load();

                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                MainGame gameController = loader.getController();
                gameController.setFruitCount((getCherries())-3);
                gameController.setScore(getScore());
                gameController.appearMovingBlock();

                stage.setScene(scene);
                stage.show();
//                return true;
            }

            else{
                reviveButton.setText("CAN'T");
//                return false;
            }
    }
}
