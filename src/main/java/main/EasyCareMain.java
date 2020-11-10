package main;

import javafx.application.Application;
import view.Loading;

public class EasyCareMain {

	public static void main(String[] args) {
		
		new Loading();
		/*
		 * Interface loading (first initial splash screen)
		 */
		Application.launch(Loading.class,args);
	}

}