package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import service.Database;
import service.Transition;

public class LoginController {

	/*
	 * FXML variable created to be manipulated (check FXML file, it contains all the
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

		if (Database.getDBConnection() == null) {
			BorderPane borderTransition = FXMLLoader.load(getClass().getResource("..\\view\\transition.fxml"));
			borderLogin.getChildren().setAll(borderTransition);

			Transition.PauseTransitionAndSetElement(borderLogin, borderTransition, 2);

			BorderPane borderTransitionError = FXMLLoader.load(getClass().getResource("..\\view\\errordatabase.fxml"));
			borderLogin.getChildren().setAll(borderTransitionError);

			Transition.PauseTransitionAndSetElement(borderLogin, borderTransitionError, 2);
		}

	}

	@FXML
	protected void handleSubmitButtonAction(ActionEvent event) {
	}

	/*
	 * Handle button method created to be used when somebody clicks on it and goes
	 * onto a signup screen
	 *
	 */
	@FXML
	protected void handleCreateButtonAction(ActionEvent event) throws IOException {

		BorderPane border = FXMLLoader.load(getClass().getResource("..\\view\\transition.fxml"));
		final BorderPane borderSignup = FXMLLoader.load(getClass().getResource("..\\view\\signup.fxml"));
		borderLogin.getChildren().setAll(border);

		/*
		 * Pause transition while change all the components FXML
		 */
		Transition.PauseTransitionAndSetElement(borderLogin, borderSignup, 1);

	}

}
