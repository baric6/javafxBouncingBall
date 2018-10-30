package fxBouncingBall;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;;

public class MyBouncingBall extends Application
{

	@Override
	public void start(Stage stage) 
	{
		//Canvas type
		Pane getsvenrToWork = new Pane();
		
		//adding canvas to the screen
		Scene scene = new Scene (getsvenrToWork, 300, 300);
		
		//making a circle object
		Circle c = new Circle(30, Color.MEDIUMTURQUOISE);
		c.relocate(5, 5);
		
		//adding nodes to the pane witch is in the scene
		getsvenrToWork.getChildren().addAll(c);
	
		//set scene in stage
		stage.setScene(scene);
		
		//show stage
		stage.show();
		
		Timeline time = new Timeline(new KeyFrame(Duration.millis(20), new EventHandler<ActionEvent>() 
		{
			double velocityX = 7;//velocity
			double angleY = 9;//angel
			
			@Override
			public void handle(ActionEvent t) 
			{
			
				//move the ball
				c.setLayoutX(c.getLayoutX() + velocityX);
				c.setLayoutY(c.getLayoutY() + angleY);
				
				
				Bounds b = getsvenrToWork.getBoundsInLocal();
			
				//if circle reaches left or right side make the value negative, change directions
				if(c.getLayoutX() <= (b.getMinX() + c.getRadius()) 
						||//or statement for if
				   c.getLayoutX()  >= (b.getMaxX() - c.getRadius()) )
				{
					//sets values to negative if hits a wall
					velocityX = -velocityX;
					
				}
				//if the ball reaches the top or bottom make circle negative, change directions
				if((c.getLayoutY() >= (b.getMaxY() - c.getRadius()))
						||//or statement for if 
				   (c.getLayoutY()  <= (b.getMinY() + c.getRadius()) ))
				{
					//sets values to negative if hits a wall
					angleY = -angleY;
					
				}
				
			}//end handle
			
		}));//end time line
		
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
		
	}//end start
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
