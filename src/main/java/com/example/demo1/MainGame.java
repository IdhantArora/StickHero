package com.example.demo1;

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class MainGame  {
    @FXML
    private Parent root;
    @FXML
    private AnchorPane myPane;
    @FXML
    private Stage stage = new Stage();
    @FXML
    private Scene scene;
    @FXML
    private ImageView IntroBg;
    @FXML
    private ImageView IntroBhai;
    @FXML
    private Rectangle StartingBlock;
    @FXML
    private Rectangle runningStick;
    private Timeline stickTimeline;
    @FXML
    private ImageView Fruit;
    @FXML
    private Label ScoreBox;
    @FXML
    private Label FruitBox;

    private int score=0,fruitCount=0;
    ImageView cherry = new ImageView();

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getFruitCount() {
        return fruitCount;
    }

    public void setFruitCount(int fruitCount) {
        this.fruitCount = fruitCount;
    }

    public Rectangle rect = new Rectangle();
    public int widthOfRect, coordinateOfRect;

//    @Override
    public void start(Stage stage) throws Exception {

    }

    public void setStickHeight(){
        runningStick.setHeight(100);
    }
    public double getStickHeight(){
        return runningStick.getHeight();
    }

//    double initX = StartingBlock.getX();
//    double initY = StartingBlock.getY();
//    double initW = StartingBlock.getWidth();
//    double initH = StartingBlock.getHeight();

    public void appearMovingBlock() {
        ScoreBox.setText(String.valueOf(this.getScore()));
        FruitBox.setText(String.valueOf(this.getFruitCount()));
        Random rand = new Random();
        Rectangle rect0 = new Rectangle();
        widthOfRect = (20 + rand.nextInt(100));
        coordinateOfRect = (130 + rand.nextInt(260));
        rect0.setHeight(120);
        rect0.setLayoutY(0);
        rect0.setWidth(widthOfRect);
        rect0.setLayoutX(coordinateOfRect);
        rect = rect0;
        myPane.getChildren().add(rect);
//        System.out.println("Coordinates: " + coordinateOfRect + " " + widthOfRect);
        rect.setFill(Color.BLACK);
        TranslateTransition tt = new TranslateTransition(Duration.seconds(3), rect);
        tt.setToY(280);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);
        FadeTransition ft = new FadeTransition(Duration.millis(3000), rect);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ParallelTransition pt = new ParallelTransition(tt, ft);
        pt.setOnFinished((ActionEvent event1) -> {
            addCherry();
        });
        pt.play();
    }

    public void addCherry() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("CherryBg1.png")));
        ImageView image2 = new ImageView();
        image2.setImage(image);
        image2.setFitHeight(20);
        image2.setFitWidth(20);
        image2.setY(260);
//        int n = (coordinateOfRect + (int) (widthOfRect / 2) - 5);
//        System.out.println("Coordinate = "
        image2.setX(coordinateOfRect + (int) (widthOfRect / 2) - 5);
        cherry = image2;
        myPane.getChildren().add(cherry);
    }


    public void startStick(MouseEvent event) {
//        System.out.println("Entering");
        stickTimeline = new Timeline(new KeyFrame(Duration.millis(25), event1 -> expandStick()));
        stickTimeline.setCycleCount(Animation.INDEFINITE);
        stickTimeline.play();
    }

    public void expandStick() {
        runningStick.setHeight((runningStick.getHeight()) + 4);
        runningStick.setY(runningStick.getY() - 4);           //check check
    }

    public void stopStick(MouseEvent event) {
//        System.out.println("Exiting");
//        System.out.println("Height = " + (110 + runningStick.getHeight()));
        stickTimeline.stop();
//        int height = runningStick.getHeight();
//        Rotate rotate = new Rotate(360, runningStick.getX(), runningStick.getY() );
//        runningStick.getTransforms().add(rotate);
        Timeline myTime = new Timeline(new KeyFrame(Duration.millis(7), event1 -> rotateStick()));
        myTime.setCycleCount(90);
        myTime.setOnFinished((ActionEvent event2) -> {
            moveBhai();
        });
        myTime.play();
    }

    public void rotateStick() {
        Rotate rotate = new Rotate(1, runningStick.getX(), (runningStick.getY() + runningStick.getHeight()));
        runningStick.getTransforms().add(rotate);
    }


    public void moveLeftMovingBlock(Rectangle rect) {
        TranslateTransition tt2 = new TranslateTransition(Duration.seconds(3), rect);
        tt2.setToX(-100);
        tt2.setCycleCount(1);
        tt2.setAutoReverse(false);
//        tt2.setOnFinished((ActionEvent event2) -> {
//            removeMovingBlock(rect);
//        });
        tt2.play();
    }

    public void removeMovingBlock(Rectangle rect) {
//        System.out.println("Going in doIt");

        myPane.getChildren().remove(rect);

    }

    public void moveBhai() {
//        System.out.println(("bhai bhai"));
//        System.out.println(runningStick.getHeight() + " " + coordinateOfRect);
        TranslateTransition moving = new TranslateTransition();
        moving.setDuration(Duration.seconds(2));
        moving.setToX(runningStick.getHeight());
        moving.setNode(IntroBhai);
        moving.setOnFinished((ActionEvent event2) -> {
            if (((runningStick.getHeight() + 115) > coordinateOfRect) && ((runningStick.getHeight() + 115) < (coordinateOfRect + widthOfRect))) {
//                System.out.println(cherry.getX()-3);
//                System.out.println(runningStick.getHeight() + 115);
//                System.out.println(cherry.getX()+ 23);
                if (((runningStick.getHeight() + 115) > (cherry.getX()) - 3) && ((runningStick.getHeight() + 115) < (cherry.getX() + 23))){
                    collectCherry();
                }
                else{
                    loseCherry();
                }
                ScoreBox.setText(String.valueOf(Integer.parseInt(ScoreBox.getText()) + 1));
                setScore(Integer.parseInt(ScoreBox.getText()));
                moveBhaiSuccessful();
            } else {
                moveBhaiFail();
            }
        });
        moving.play();

    }

    public void loseCherry(){
        TranslateTransition transition = new TranslateTransition ();
        transition.setDuration (Duration.seconds (3));
        transition.setNode(cherry);
        transition.setByY (250);
        transition.setOnFinished((ActionEvent event2) -> {
            removeCherry();
        });
        transition.play();
    }
    public void collectCherry(){
        TranslateTransition transition = new TranslateTransition ();
        transition.setDuration (Duration.seconds (3));
        transition.setNode(cherry);
        transition.setByX (260);
        transition.setByY (-250);
        transition.setOnFinished((ActionEvent event2) -> {
            removeCherry();
            updateCherryScore();
        });
        transition.play();

    }

    public void removeCherry(){
        myPane.getChildren().remove(cherry);
    }

    public void updateCherryScore(){
        FruitBox.setText(String.valueOf(Integer.parseInt(FruitBox.getText()) + 1));
        setFruitCount(Integer.parseInt(FruitBox.getText()));
    }

    public void moveBhaiSuccessful() {
//        System.out.println("Got it wow");
        double n = runningStick.getHeight();
        TranslateTransition moving = new TranslateTransition();
        moving.setDuration(Duration.seconds(2));
        moving.setByX(-n);
        moving.setNode(IntroBhai);
        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2),
                new KeyValue(rect.widthProperty(), 115),
                new KeyValue(rect.heightProperty(), 120));
        timeline.getKeyFrames().add(keyFrame);
        TranslateTransition t2 = new TranslateTransition();
        t2.setDuration(Duration.millis(2000));
        t2.setNode(rect);
        t2.setByX((-coordinateOfRect));
        TranslateTransition t3 = new TranslateTransition();
        t3.setDuration(Duration.seconds(2));
        t3.setNode(runningStick);
        t3.setByX(-n);
        TranslateTransition t4 = new TranslateTransition();
        t4.setDuration(Duration.seconds(2));
        t4.setNode(StartingBlock);
        t4.setByX(-n);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(moving, t2, timeline, t3, t4);
        parallelTransition.setOnFinished((ActionEvent event2) -> {
            try {
//                    stage =  MainGame.getPrimaryStage();
                resetAll();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        parallelTransition.play();
    }

    public void moveBhaiFail() {
        TranslateTransition tt = new TranslateTransition();
        tt.setDuration(Duration.millis(1500));
        tt.setNode(IntroBhai);
        tt.setByY(300);
        tt.setOnFinished((ActionEvent event2) -> {
            try {
                goToReviveScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        tt.play();
    }

    public void goToReviveScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Revive.fxml"));
        root = loader.load();
        // Create a new scene with the root node
        Scene scene = new Scene(root);
        ReviveScreen controller = loader.getController();
        controller.tillRevive();
        controller.setScore(score);
        controller.setCherries(fruitCount);
        Stage stage = (Stage) runningStick.getScene().getWindow();
        // Set the scene to the stage
        stage.setScene(scene);
        // Show the stage
        stage.show();
    }

    //    public void resetAll(Stage stage) throws IOException {
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGame.fxml"));
//        root = loader.load();
//        MainGame controller = loader.getController();
//        controller.appearMovingBlock();
//        scene = new Scene(root);
//        //Stage stage = new Stage();
//        //stage = (Stage) root.getScene().getWindow();
//
//        stage.setScene(scene);
//        stage.show();
//    }

    public void ChangeBhai(){
//        Image image = new Image();
//        System.out.println(image);
        Random rand = new Random();
        int i = (rand.nextInt(100));
        if (i%3 == 0){
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("AmongUsBhai.png")));
            IntroBhai.setImage(image);
            IntroBhai.setLayoutY(253);
            IntroBhai.setLayoutX(87);
            IntroBhai.setFitWidth(25);
            IntroBhai.setFitHeight(30);
        }
        else if (i%3 == 1){
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("MarioStillBhai.png")));
            IntroBhai.setImage(image);
            IntroBhai.setLayoutY(245);
            IntroBhai.setLayoutX(89);
            IntroBhai.setFitWidth(30);
            IntroBhai.setFitHeight(35);
        }
        else{
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("StickBhai-removebg.png")));
            IntroBhai.setImage(image);
            IntroBhai.setLayoutY(255);
            IntroBhai.setLayoutX(86);
            IntroBhai.setFitWidth(25);
            IntroBhai.setFitHeight(30);
        }
    }
    public void resetAll() throws IOException {
        myPane.getChildren().remove(rect);
//        for(int i=0;i<10000000;i++){
//            System.out.println(i);
//        }
        myPane.getChildren().remove(runningStick);
        Rectangle newRect0 = new Rectangle();
        newRect0.setX(110);
        newRect0.setY(280);
        newRect0.setWidth(3);
        newRect0.setHeight(0);
        runningStick = newRect0;
        myPane.getChildren().add(runningStick);
        myPane.getChildren().remove(StartingBlock);
        Rectangle newRect = new Rectangle();
        newRect.setX(0);
        newRect.setY(280);
        newRect.setWidth(115);
        newRect.setHeight(120);
        StartingBlock = newRect;
        myPane.getChildren().add(StartingBlock);
        appearMovingBlock();
    }

    public void SaveGameOption(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter("output.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(getScore());
        bw.close();
        fw.close();
    }
}
