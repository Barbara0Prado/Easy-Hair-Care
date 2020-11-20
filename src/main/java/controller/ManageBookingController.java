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

public class ManageBookingController extends GeneralController {
	
	@FXML
	private BorderPane borderManage;
	
    @FXML
    private ComboBox<String> comboBoxManage;
    
    @FXML
    private JFXButton buttonAccept;
    
    @FXML
    private JFXButton buttonDeny;
    
    private ObservableList<String> options = FXCollections.observableArrayList();
    
    @FXML
    protected void initialize() throws SQLException, IOException, InterruptedException {
    	
    	options.clear();
    	
    	comboBoxManage.valueProperty().set(null);
    	
    	dateTimeProviderDAO.selectAllProviderBookings(AccountLogged.accountId);
    	
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
    	
    	comboBoxManage.setItems(options);
    	
    	comboBoxManage.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				
				if (comboBoxManage.getValue() != null) {
					buttonAccept.setVisible(true);
					buttonDeny.setVisible(true);

				} else {
					buttonAccept.setVisible(false);
					buttonDeny.setVisible(false);
				}

			}
		});
    	
    }
    
    @FXML
	protected void handleAcceptButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {
		
		if (comboBoxManage.getValue() != null) {

			for (int i = 0; i < AccountLogged.datetimeproviders.size(); i++) 
			{
				if(options.get(i).equalsIgnoreCase(comboBoxManage.getValue()))
				{
					if(dateTimeProviderDAO.updateAcceptProvider(AccountLogged.datetimeproviders.get(i).getId()) == true)
					{
					    initialize();
					}
				}
			}
		}
	}
    
    @FXML
	protected void handleCancelButtonAction(ActionEvent event) throws IOException, SQLException, InterruptedException {
		
		if (comboBoxManage.getValue() != null) {

			for (int i = 0; i < AccountLogged.datetimeproviders.size(); i++) 
			{
				if(options.get(i).equalsIgnoreCase(comboBoxManage.getValue()))
				{
					if(dateTimeProviderDAO.updateDenyProvider(AccountLogged.datetimeproviders.get(i).getId()) == true)
					{
					    initialize();
					}
				}
			}
		}
	}
    
    
	

	@FXML
	protected void handlelogoutButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderManage, FXMLService.LOGIN_SCREEN);

	}
}