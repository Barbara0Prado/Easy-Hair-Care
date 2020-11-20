package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import service.FXMLService;
import service.TransitionService;

public class ConfirmedController extends GeneralController {

	@FXML
	private BorderPane borderConfirmed;

	@FXML
	protected void handleLogoutButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderConfirmed, FXMLService.LOGIN_SCREEN);

	}

	@FXML
	protected void handleNewBookingButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderConfirmed, FXMLService.LOCATION_SCREEN);

	}

	@FXML
	protected void handleBookingButtonAction(ActionEvent event) throws IOException {
		LoadFXML(borderConfirmed, FXMLService.CANCELDATEANDTIME);

	}

}
