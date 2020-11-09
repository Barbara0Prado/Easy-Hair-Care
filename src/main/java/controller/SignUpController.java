package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToggleButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class SignUpController {

	/*
	 * FXML annotation to be able to indetify the id's on fxml
	 */
	@FXML
	private JFXButton signUpButton;

	@FXML
	private TextField nameField;

	@FXML
	private TextField emailField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private TextField phoneField;

	@FXML
	private JFXToggleButton toggleField;

	@FXML
	private ComboBox<String> comboField;

	@FXML
	private Label nameLabel;

	@FXML
	private Label emailLabel;

	@FXML
	private Label numberLabel;

	@FXML
	private Label passwordLabel;

	@FXML
	private Label locationLabel;

	/*
	 * Pattern email (validation)
	 */
	private Pattern pattern = Pattern.compile("^(.+)@(.+)$");
	private Matcher matcher = null;

	/*
	 * Initialize added to check some changes on fields and set warning alert
	 */
	@FXML
	private void initialize() {
		nameField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (nameField.getLength() > 10) {
					nameLabel.setVisible(false);
				} else {
					nameLabel.setVisible(true);
				}

			}
		});
		emailField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				Pattern pattern = Pattern.compile("^(.+)@(.+)$");
				Matcher matcher = pattern.matcher(emailField.getText());

				if (emailField.getLength() < 10 || !matcher.matches()) {
					emailLabel.setVisible(true);
				} else {
					emailLabel.setVisible(false);
				}

			}
		});
		phoneField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (phoneField.getLength() > 10) {
					numberLabel.setVisible(false);
				} else {
					numberLabel.setVisible(true);
				}

			}
		});
		passwordField.textProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (passwordField.getLength() > 10) {
					passwordLabel.setVisible(false);
				} else {
					passwordLabel.setVisible(true);
				}

			}
		});
		comboField.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (comboField.getValue().equalsIgnoreCase("Location")) {
					locationLabel.setVisible(true);
				} else {
					locationLabel.setVisible(false);
				}

			}
		});
	}

	/*
	 * Set warning in case of the field does not have more than 10 characters
	 */
	@FXML
	protected void handlenameFieldAction(ActionEvent event) throws IOException {
		if (nameField.getLength() > 10) {
			this.nameLabel.setVisible(false);
		}
	}

	/*
	 * Set warning to the user select the location
	 */
	@FXML
	protected void handleToggleButtonAction(ActionEvent event) throws IOException {

		if (toggleField.isSelected()) {

			ObservableList<String> options = FXCollections.observableArrayList("DUBLIN SOUTH", "DUBLIN NORTH");

			comboField.setValue("Location");
			comboField.setItems(options);

			comboField.setVisible(true);
			signUpButton.relocate(81, 357);

		} else {
			this.locationLabel.setVisible(false);
			comboField.setVisible(false);
			signUpButton.relocate(83, 322);
		}

	}

	/*
	 * Set warning to the user if the fields are empty
	 */
	@FXML
	protected void handleSignUpButtonAction(ActionEvent event) throws IOException {
		if (nameField.getLength() < 10) {
			this.nameLabel.setVisible(true);
		}
		if (emailField.getLength() < 10) {
			this.emailLabel.setVisible(true);
		}
		if (phoneField.getLength() < 10) {
			this.numberLabel.setVisible(true);
		}
		if (passwordField.getLength() < 10) {
			this.passwordLabel.setVisible(true);
		}
		if (comboField.getValue().equalsIgnoreCase("Location")) {
			this.locationLabel.setVisible(true);
		}
	}

}
