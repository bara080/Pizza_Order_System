package com.example.eventhandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.io.IOException;
import java.sql.Connection;


/**
 * Controller class for managing scenes related to user authentication.
 * Handles buttons, labels, and text fields for login and signup operations.
 */
public class SceneController {

    /**
     * Button for canceling an operation.
     */
    @FXML
    private Button cancelButton;

    /**
     * Button for initiating the login operation.
     */
    @FXML
    private Button loginButton;

    /**
     * Button for initiating the signup operation.
     */
    @FXML
    private Button signupButton;

    /**
     * Button for submitting a form or operation.
     */
    @FXML
    private Button submitButton;

    /**
     * Label for displaying login-related messages.
     */
    @FXML
    private Label loginMessageLabel;

    /**
     * Label for displaying signup-related messages.
     */
    @FXML
    private Label singupMessageLabel;

    /**
     * Text field for entering a username.
     */
    @FXML
    private TextField usernameTextField;

    /**
     * Password field for entering a password.
     */
    @FXML
    private PasswordField passwordTextField;

    /**
     * Stage for the current window.
     */
    private Stage stage;

    /**
     * Scene representing the visual elements of the application.
     */
    private Scene scene;

    /**
     * Parent node representing the root of the user interface.
     */
    private Parent root;

    // Additional methods and logic can be added as needed




    /**
     * Controller method for handling user login attempts.
     * Displays user login entry status and performs user validation.
     *
     * @param e The event triggered by the login button click.
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException Signals that an SQL exception has occurred.
     */

    public void loginButtonOnAction(ActionEvent e) throws IOException, SQLException {
        loginMessageLabel.setText("You tried to login!");

        //  TODO: User login validation goes here

        if (usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
        {
            try
            {
                validateLogin(e);
            }
            catch (IOException ex)
            {
                throw new RuntimeException(ex);
            }
            catch (SQLException ex)
            {
                throw new RuntimeException(ex);
            }
            //loginMessageLabel.setText("You tried to login!");
        }

        else
        {
            loginMessageLabel.setText("Please Enter User Info!");
        }
    }

    /**
     * Cancels the user login process by closing the current window.
     *
     * @param e The event triggered by the cancel button click.
     */
    public void cancelButtonOnAction(ActionEvent e){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }




    /**
     * Validates user login information against the database.
     * If the provided username and password match a record in the "users" table,
     * opens the main pizza store interface; otherwise, displays an error message.
     *
     * @param event The event triggered by the login button click.
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws SQLException Signals that an SQL exception has occurred.
     */

    public void validateLogin(ActionEvent event) throws IOException, SQLException {


        DBConnection connect = new DBConnection();

        Connection conn = connect.getConn();

        String verifyLogin = "SELECT count(1) FROM users WHERE username = '" + usernameTextField.getText() + "' AND pass = '" + passwordTextField.getText() +  "'" +
                ";";


        Statement statement = conn.createStatement();

        ResultSet queryResult = statement.executeQuery(verifyLogin);

        while (queryResult.next()){
            if(queryResult.getInt(1) == 1)
            {


                //ActionEvent event  = new ActionEvent();

                Parent root = FXMLLoader.load(getClass().getResource("pizza.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene (root);
                    stage.setScene(scene);
                    stage.show();



                //loginMessageLabel.setText("Welcome");
            }
            else
            {
                loginMessageLabel.setText("invalid Login. Please try again.");

            }
        }

    }





    /**
     * Switches the current scene from login to signup.
     * Loads the SignUp.fxml file and updates the current stage with the new scene.
     *
     * @param event The event triggered by the button click to switch scenes.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void switchToScene1(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();

    }


    /**
     * Switches the current scene from login to signup.
     * Loads the login.fxml file and updates the current stage with the new scene.
     *
     * @param event The event triggered by the button click to switch scenes.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void switchToScene2(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }



    /**
     * Switches the current scene from login to signup.
     * Loads the pizza.fxml file and updates the current stage with the new scene.
     *
     * @param event The event triggered by the button click to switch scenes.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void switchToScene3(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("pizza.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene (root);
        stage.setScene(scene);
        stage.show();
    }








}
