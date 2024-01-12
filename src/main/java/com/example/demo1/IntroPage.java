package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class IntroPage {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root;

    @FXML
    private TextField MemberIdInput,MemberPassInput;

    @FXML
    private Button LoginButton,ForgetPassButton,NewAccountButton;

    @FXML
    public void switchToPlayGamePage(ActionEvent event) throws IOException {
        if (MemberIdInput.getText().equals("admin") && MemberPassInput.getText().equals("admin123")) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PlayGamePage.fxml")));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            MemberIdInput.setText("admin");
            MemberPassInput.setText("admin123");
        }

    }
}
