package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import service.DatabaseService;
import service.FXMLService;
import service.TransitionService;

public class LoginController extends FXMLController {

    /*
	 * FXML (identifier) created to be manipulated (check FXML file, it contains all the
	 * id's) and it has to be the same name and same type of control or custom
	 * control
     */
    @FXML
    private TextField emailField;

    @FXML
    private JFXButton connectButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Hyperlink hyperlink;

    @FXML
    private BorderPane borderLogin;

    /*
	 * Initialize check if database exists or connection is not null (change to errordatabase.fxml if it is not correct)
	 * 
     */
    @FXML
    protected void initialize() throws SQLException, IOException, InterruptedException {

        if (DatabaseService.getDBConnection() == null) {
            BorderPane borderTransitionError = FXMLLoaderInit(borderLogin, FXMLService.ERROR_DATABASE_SCREEN, true);

            TransitionService.PauseTransitionAndSetElement(borderLogin, borderTransitionError, 2);
        }

    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
    }

    /*
	 * Handle button method created to be used when somebody clicks on it and goes
	 * onto a signup screen
     */
    @FXML
    protected void handleCreateButtonAction(ActionEvent event) throws IOException {

        BorderPane border = FXMLLoaderInit(borderLogin, FXMLService.TRANSITION_SCREEN, true);
        
        /*
         * Check later 
         */
        final BorderPane borderSignup = FXMLLoaderInit(border, FXMLService.SIGNUP_SCREEN, false);
        

        /*
		 * Pause transition while change all the components FXML
         */
        TransitionService.PauseTransitionAndSetElement(border, borderSignup, 1);

    }

}
