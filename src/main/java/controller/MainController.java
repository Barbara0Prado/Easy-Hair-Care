package controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import animatefx.animation.Bounce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import service.GeneralAnimationService;
import service.PathFXMLService;

public class MainController extends PublicClassController {

	/*
	 * FXML variables
	 */
	@FXML
	private VBox vbox1;
	
	@FXML
	private VBox vbox2;

	@FXML
	private ImageView imageView;

	@FXML
	protected void initialize() throws SQLException, IOException, InterruptedException {
		/*
		 * Rotation effect
		 */
		GeneralAnimationService.Rotation(imageView, 3000);
		
		LoadFXMLWithSpinner(vbox2,PathFXMLService.LOGIN_SCREEN);
	}
	
	@FXML
	protected void handleMinButtonAction(ActionEvent event){
		Stage stage = (Stage)border.getScene().getWindow();
		stage = (Stage)((Button)event.getSource()).getScene().getWindow();
		stage.setIconified(true);
	}
	
	@FXML
	protected void handleCloseButtonAction(ActionEvent event){
		System.exit(1);
	}
}
