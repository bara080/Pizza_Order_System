
////////////////////////////////////////////////////////////////////////////////////////\\
//                                                                                      \\
//          ONLINE PIZZA PROJECT STORE                                                  \\
//                                                                                      \\
//          CREATED BY: BARA AHMAD MOHAMMED                                             \\
//                                                                                      \\
//                      AND                                                             \\
//                                                                                      \\
//                  YILIN GU                                                            \\
//                                                                                      \\
//                     SUBMITTED TO PROF. COLIN. P                                      \\
//                                                                                      \\
//             25TH DECEMBER, 2023                                                      \\
//////////////////////////////////////////////////////////////////////////////////////////

package com.example.eventhandler;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        primaryStage.setTitle("Pizza");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
