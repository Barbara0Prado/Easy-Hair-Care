package controller;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import model.AccountLogged;
import service.FXMLService;
import service.TransitionService;

public class DublinController extends GeneralController {
	
	@FXML
	private BorderPane borderDublin;
	
    @FXML
    private ComboBox<String> comboBoxHairBarber;
    
    @FXML
    private ImageView star1;
    
    @FXML
    private ImageView star2;
    
    @FXML
    private ImageView star3;
    
    @FXML
    private ImageView star4;
    
    @FXML
    private ImageView star5;
    
    @FXML
    private JFXButton buttonChoose;
    
    private ObservableList<String> options = FXCollections.observableArrayList();
    
    @FXML
    protected void initialize() throws SQLException, IOException, InterruptedException {
    	
<<<<<<< HEAD
    	options.clear();
    	
    	comboBoxHairBarber.valueProperty().set(null);
    	
=======
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
    	providerDAOService.selectAllProviders(AccountLogged.accountLocation);
    	
    	for(int i = 0; i < AccountLogged.providers.size(); i++)
    	{
		    options.add(AccountLogged.providers.get(i).getName());
    	}
    	
    	comboBoxHairBarber.setItems(options);
    	
    }
    
    @FXML
    protected void handleHairBarberAction(ActionEvent event)
    {
		this.star1.setVisible(false);
		this.star2.setVisible(false);
		this.star3.setVisible(false);
		this.star4.setVisible(false);	
		this.star5.setVisible(false);
		
    	for(int i = 0; i < AccountLogged.providers.size(); i++)
    	{
        	if(comboBoxHairBarber.getValue().equalsIgnoreCase(AccountLogged.providers.get(i).getName())) 
        	{
        		buttonChoose.setVisible(true);
        		
        		if(AccountLogged.providers.get(i).getStar() == 1)
        		{
        			this.star1.setVisible(true);
        		}
        		if(AccountLogged.providers.get(i).getStar() == 2)
        		{
        			this.star1.setVisible(true);
        			this.star2.setVisible(true);
        		}
        		if(AccountLogged.providers.get(i).getStar() == 3)
        		{
        			this.star1.setVisible(true);
        			this.star2.setVisible(true);
        			this.star3.setVisible(true);
        		}
        		if(AccountLogged.providers.get(i).getStar() == 4)
        		{
        			this.star1.setVisible(true);
        			this.star2.setVisible(true);
        			this.star3.setVisible(true);
        			this.star4.setVisible(true);
        		}
        		if(AccountLogged.providers.get(i).getStar() == 5)
        		{
        			this.star1.setVisible(true);
        			this.star2.setVisible(true);
        			this.star3.setVisible(true);
        			this.star4.setVisible(true);	
        			this.star5.setVisible(true);	
        		}
        	}
    	}
  
    }
    
	@FXML
	protected void handleChooseButtonAction(ActionEvent event) throws IOException{
		
    	for(int i = 0; i < AccountLogged.providers.size(); i++)
    	{
        	if(comboBoxHairBarber.getValue().equalsIgnoreCase(AccountLogged.providers.get(i).getName())) 
        	{
        		idProvider = AccountLogged.providers.get(i).getIdProvider();
        	}
        }
		
<<<<<<< HEAD
    	LoadFXML(borderDublin, FXMLService.DATETIME_SCREEN);
	}
	
    @FXML
    protected void handleLogoutButtonAction(ActionEvent event) throws IOException {
    	LoadFXML(borderDublin, FXMLService.LOGIN_SCREEN);
    	
    }
    
    @FXML
    protected void handleBackButtonAction(ActionEvent event) throws IOException {
    	LoadFXML(borderDublin, FXMLService.LOCATION_SCREEN);
    	
    }
    
    @FXML
    protected void handleBookingButtonAction(ActionEvent event) throws IOException {
    	LoadFXML(borderDublin, FXMLService.CANCELDATEANDTIME);
    	
    }
=======
        BorderPane border = FXMLLoaderInit(borderDublin, FXMLService.TRANSITION_SCREEN, true);
        
        /*
         * Check later 
         */
        final BorderPane borderSignup = FXMLLoaderInit(border, FXMLService.DATETIME_SCREEN, false);
        
        TransitionService.PauseTransitionAndSetElement(border, borderSignup, 1);
	}
>>>>>>> f9d2338dbf78c078c22c386fa38fd32dcfdef2d5
 
}