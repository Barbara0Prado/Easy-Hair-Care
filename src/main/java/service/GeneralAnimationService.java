package service;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXNodesList;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/*
 * Class fade effect added to be used on all transitions screens and loading screen
 */
public class GeneralAnimationService {

	private FadeTransition fade = new FadeTransition();

	public static void Rotation(ImageView imageViewScissors, int millis) {
		RotateTransition rotate = new RotateTransition(Duration.millis(millis));
		rotate.setByAngle(10f);
		rotate.setCycleCount(1000);
		rotate.setAutoReverse(true);
		rotate.setNode(imageViewScissors);
		rotate.play();
	}
	
	public static void TranslationLabel(Label label, int millis) {

		TranslateTransition translateTransition = new TranslateTransition();
		
		translateTransition.setDuration(Duration.millis(millis));
		translateTransition.setNode(label);
		translateTransition.setToY(500);
		translateTransition.setCycleCount(999999999);
		translateTransition.setAutoReverse(false);
		translateTransition.play();
	}

	public static void TranslationHourButton(JFXButton button, int millis) {

		TranslateTransition translateTransition = new TranslateTransition();
		
		translateTransition.setDuration(Duration.millis(millis));
		translateTransition.setNode(button);
		translateTransition.setToY(500);
		translateTransition.setCycleCount(1);
		translateTransition.setAutoReverse(false);
		translateTransition.play();
		
		RotateTransition rotate = new RotateTransition();
		
		rotate.setDuration(Duration.millis(millis));
		rotate.setNode(button);
		rotate.setByAngle(360);
		rotate.setCycleCount(1);
		rotate.setAutoReverse(false);
		rotate.play();
	}

	public static void TranslationBack(JFXButton button, int millis) {

		TranslateTransition translateTransition = new TranslateTransition();

		translateTransition.setDuration(Duration.millis(millis));
		translateTransition.setNode(button);
		translateTransition.setToY(0);
		translateTransition.setCycleCount(1);
		translateTransition.setAutoReverse(false);
		translateTransition.play();
	}

}
