package controller.provider;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;

import controller.PublicClassController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import model.UserLogged;
import service.PathFXMLService;
import service.GeneralAnimationService;

public class ProviderViewCustumerBooking extends PublicClassController {

	/*
	 * FXML variables
	 */
	@FXML
	private VBox vbox;

	@FXML
	private ComboBox<String> comboBox;

	@FXML
	private JFXButton buttonAccept;

	@FXML
	private JFXButton buttonDeny;

	@FXML
	private Label labelNoCustumer;

	private ObservableList<String> options = FXCollections.observableArrayList();

	@FXML
	protected void initialize() throws SQLException, IOException, InterruptedException {

		options.clear();

		comboBox.valueProperty().set(null);

		dateTimeProviderDAO.selectAllProviderBookings(UserLogged.userId);

		/*
		 * Check if there is dates to accept
		 */
		if (UserLogged.dates.size() < 1) {
			labelNoCustumer.setVisible(true);
			comboBox.setVisible(false);
			return;
		}

		/*
		 * Compose string according to day and name
		 */
		for (int i = 0; i < UserLogged.dates.size(); i++) {
			int hour = UserLogged.dates.get(i).getHour();
			int minute = UserLogged.dates.get(i).getMinute();
			int year = UserLogged.dates.get(i).getYear();
			int month = UserLogged.dates.get(i).getMonth();
			int day = UserLogged.dates.get(i).getDay();

			String compose = "";

			compose = year + "/" + (month < 10 ? "0" + month : month) + "/" + (day < 10 ? "0" + day : day) + " - ";

			compose += hour < 10 ? "0" + hour + ":" : "" + hour + ":";
			compose += minute < 10 ? "0" + minute : "" + minute;

			compose += " - " + UserLogged.dates.get(i).getProviderName();

			options.add(i, compose);
		}

		comboBox.setItems(options);

		/*
		 * Update combobox
		 */
		comboBox.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

				if (comboBox.getValue() != null) {
					buttonAccept.setVisible(true);
					buttonDeny.setVisible(true);

				} else {
					buttonAccept.setVisible(false);
					buttonDeny.setVisible(false);
				}
				
				for (int i = 0; i < UserLogged.dates.size(); i++) {
					if(dateFormat.dateFormatString(LocalDate.now().minusDays(1).toString()) == true)
					{
						if(UserLogged.dates.get(i).getDay() == dateFormat.getDay())
						{
							System.out.print("fdfd");
						}
					}
				}

			}
		});
		/*
		 * Fixed white background
		 */
		comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
			@Override
			public ListCell<String> call(ListView<String> p) {
				return new ListCell<String>() {

					@Override
					protected void updateItem(String item, boolean empty) {
						super.updateItem(item, empty);
						setStyle("-fx-text-fill: WHITE;");
						setBackground(new Background(new BackgroundFill(Color.web("#1C1C1C"), CornerRadii.EMPTY, null)));
						setText(item);
					}

				};
			}

		});

	}

	/*
	 * Accept button
	 */
	@FXML
	protected void handleAcceptButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {

		if (comboBox.getValue() != null) {

			for (int i = 0; i < UserLogged.dates.size(); i++) {
				if (options.get(i).equalsIgnoreCase(comboBox.getValue())) {
					if (dateTimeProviderDAO.updateAcceptProvider(UserLogged.dates.get(i).getId()) == true) {
						initialize();
					}
				}
			}
		}
	}

	/*
	 * Deny button
	 */
	@FXML
	protected void handleDenyButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {

		if (comboBox.getValue() != null) {

			for (int i = 0; i < UserLogged.dates.size(); i++) {
				if (options.get(i).equalsIgnoreCase(comboBox.getValue())) {
					if (dateTimeProviderDAO.updateDenyProvider(UserLogged.dates.get(i).getId()) == true) {
						/*
						 * initialize method invoke
						 */
						initialize();
					}
				}
			}
		}
	}

	/*
	 * Logout button
	 */
	@FXML
	protected void handleLogoutButtonAction(ActionEvent event) throws IOException {
		LoadFXMLWithSpinner(vbox, PathFXMLService.LOGIN_SCREEN);
	}

	/*
	 * Remove button
	 */
	@FXML
	protected void handleRemoveButtonAction(ActionEvent event) throws IOException {
		LoadFXMLWithSpinner(vbox, PathFXMLService.PROVIDER_REMOVE_DATE_SCREEN);
	}

	/*
	 * Add date button
	 */
	@FXML
	protected void handleAddDateButtonAction(ActionEvent event) throws IOException {
		LoadFXMLWithSpinner(vbox, PathFXMLService.PROVIDER_ADD_DATE_SCREEN);
	}
}