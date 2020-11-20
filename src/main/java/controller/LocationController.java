package controller;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import model.AccountLogged;
import service.FXMLService;
import service.TransitionService;

public class LocationController extends GeneralController {
	
    @FXML
    private JFXButton buttonSouth;
    
    @FXML
    private JFXButton buttonNorth;
    
    @FXML
    private BorderPane borderLocation;
    
    void Load() throws IOException
    {
    	LoadFXML(borderLocation, FXMLService.DUBLIN_SCREEN);
    }
    
    @FXML
    protected void handleSouthButtonAction(ActionEvent event) throws IOException {
    	AccountLogged.accountLocation = 0;
    	
    	Load();
 
    }
    
    @FXML
    protected void handleNorthButtonAction(ActionEvent event) throws IOException {
    	AccountLogged.accountLocation = 1;
    	
    	Load();
    }
    
    @FXML
    protected void handleLogoutButtonAction(ActionEvent event) throws IOException {
    	LoadFXML(borderLocation, FXMLService.LOGIN_SCREEN);
    	
    }
    
    @FXML
    protected void handleBookingButtonAction(ActionEvent event) throws IOException {
    	LoadFXML(borderLocation, FXMLService.CANCELDATEANDTIME);
    	
    }
}
