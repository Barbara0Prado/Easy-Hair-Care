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

public class AdminAcceptController extends GeneralController {

	@FXML
	private BorderPane borderAdminAccept;
	
	@FXML 
	private JFXButton acceptButton;
	
	@FXML 
	private JFXButton denyButton;
	
	@FXML
	private ComboBox<String> comboBoxProvider;
	
	private ObservableList<String> options = FXCollections.observableArrayList();
	
	@FXML
	protected void initialize() throws SQLException {
		
		
		
		providerDAOService.selectAllProviders();
		
		options.clear();
		
		comboBoxProvider.valueProperty().set(null);
		
		for(int i = 0; i < AccountLogged.adminAcceptProviders.size(); i++) 
		{
			options.add(i, AccountLogged.adminAcceptProviders.get(i).getName());
		}

		comboBoxProvider.setItems(options);
		
		comboBoxProvider.valueProperty().addListener(new ChangeListener<String>() {

			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (comboBoxProvider.getValue() != null) {
					acceptButton.setVisible(true);
					denyButton.setVisible(true);

				} else {
					acceptButton.setVisible(false);
					denyButton.setVisible(false);
				}

			}
		});
	
	}
	
	@FXML
	protected void handleAcceptButtonAction(ActionEvent event) throws IOException, SQLException {
		
		if (comboBoxProvider.getValue() != null) {

			for (int i = 0; i < AccountLogged.adminAcceptProviders.size(); i++) 
			{
				if(comboBoxProvider.getValue() == options.get(i))
				{
					if(providerDAOService.updateProvider(AccountLogged.adminAcceptProviders.get(i).getId(),AccountLogged.adminAcceptProviders.get(i).getLocation()) == true)
					{
						initialize();
					}
				}
			}
		}
	}
	
	@FXML
	protected void handleDenyButtonAction(ActionEvent event) throws IOException, SQLException {
		if (comboBoxProvider.getValue() != null) {
			for (int i = 0; i < AccountLogged.adminAcceptProviders.size(); i++) 
			{
				if(comboBoxProvider.getValue() == options.get(i))
				{
					if(providerDAOService.removeProvider(AccountLogged.adminAcceptProviders.get(i).getId()) == true)
					{
						initialize();
					}
				}
			}
		}
	}
	

	@FXML
	protected void handlelogoutButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderAdminAccept, FXMLService.LOGIN_SCREEN);

	}

}

