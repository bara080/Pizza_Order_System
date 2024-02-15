package com.example.eventhandler;




import javafx.application.Application;

import javafx.scene.Scene;
import javafx.stage.Stage;


import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


import java.io.IOException;



public class landaEvent extends Application {

        private Label myLabel;
        @Override
        public void start(Stage stage) throws IOException {

            // Create a Label and a Button.
            myLabel = new Label("Click the button to see a message.");
            Button myButton = new Button("Click Me");
        // Register an event handler.
            myButton.setOnAction(e ->
            {

                    myLabel.setText("Thanks for clicking the button!");

            });
        // Put the Label and Button in a VBox with 10 pixels of spacing.
            VBox vbox = new VBox(10, myLabel, myButton);
            vbox.setAlignment(Pos.CENTER);
        // Create a Scene and display it.
            Scene scene = new Scene(vbox, 300, 100);
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            launch();
        }
    }

