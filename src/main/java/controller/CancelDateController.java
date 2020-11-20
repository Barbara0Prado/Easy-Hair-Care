package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import model.AccountLogged;
import service.FXMLService;
import service.TransitionService;

public class CancelDateController extends GeneralController {

	@FXML
	private BorderPane borderCancel;
	
	@FXML 
	private JFXButton dateButton;
	
	@FXML
	private ComboBox<String> comboBoxDate;
	
	private ObservableList<String> options = FXCollections.observableArrayList();
	
	@FXML
	protected void initialize() throws SQLException {
		
		dateTimeProviderDAO.selectAllBookings(AccountLogged.accountId);
		
		options.clear();
		
		comboBoxDate.valueProperty().set(null);
		
		for(int i = 0; i < AccountLogged.datetimeproviders.size(); i++) 
		{
			int hour = AccountLogged.datetimeproviders.get(i).getHour();
			int minute = AccountLogged.datetimeproviders.get(i).getMinute();
			int year = AccountLogged.datetimeproviders.get(i).getYear();
			int month = AccountLogged.datetimeproviders.get(i).getMonth();
			int day = AccountLogged.datetimeproviders.get(i).getDay();
			
			String compose = "";

			
			compose = year + "/" + (month < 10 ? "0"+month : month) + "/" + (day < 10 ? "0"+day : day) + " - ";
			
			compose += hour < 10 ? "0" + hour + ":" : "" + hour + ":";
			compose += minute < 10 ? "0" + minute : "" + minute;
			
			compose += " - " + AccountLogged.datetimeproviders.get(i).getProviderName();

			options.add(i, compose);
		}

		comboBoxDate.setItems(options);
		
		comboBoxDate.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				
				if (comboBoxDate.getValue() != null) {
					dateButton.setVisible(true);

				} else {
					dateButton.setVisible(false);
				}

			}
		});
	
	}
	
	@FXML
	protected void handleCancelButtonAction(ActionEvent event) throws IOException, SQLException {
		
		if (comboBoxDate.getValue() != null) {

			for (int i = 0; i < AccountLogged.datetimeproviders.size(); i++) 
			{
				if(options.get(i).equalsIgnoreCase(comboBoxDate.getValue()))
				{
					dateTimeProviderDAO.updateBooking(AccountLogged.datetimeproviders.get(i).getId());
					
					LoadFXML(borderCancel, FXMLService.BOOKINGCANCELLED);
				}
			}
		}
	}
	

	@FXML
	protected void handlelogoutButtonAction(ActionEvent event) throws IOException {
		BorderPane border = FXMLLoaderInit(borderCancel, FXMLService.TRANSITION_SCREEN, true);

		LoadFXML(borderCancel, FXMLService.LOGIN_SCREEN);

	}

	@FXML
	protected void handleNewBookingButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderCancel, FXMLService.LOCATION_SCREEN);

	}

}
