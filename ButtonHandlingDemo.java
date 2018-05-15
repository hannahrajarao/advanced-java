import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
public class ButtonHandlingDemo extends Application
{
	private Button on;
	private Button off;
	private Label status = new Label("Push a button");
	public void start(Stage myStage)
	{
		//create scene etc.
		myStage.setTitle("Button Handling Demo");
		FlowPane rootNode = new FlowPane(10,10);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode,300,200);
		//set text on buttons
		on = new Button("On");
		off = new Button("Off");
		//create and register event handlers
		OnButtonHandler onh = new OnButtonHandler();
		OffButtonHandler offh = new OffButtonHandler();
		on.setOnAction(onh);
		off.setOnAction(offh);
		//add to scene
		rootNode.getChildren().addAll(on,off,status);
		//set scene and show
		myStage.setScene(myScene);
		myStage.show();
	}
	class OnButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			status.setText("On button pushed");
		}
	}
	class OffButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			status.setText("Off button pushed");
		}
	}
}