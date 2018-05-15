import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
public class ComboBoxDemo extends Application
{
	private Label response;
	private ComboBox<String> shipping;
	
	public void start(Stage myStage)
	{
		myStage.setTitle("Checkbox Demo");
		FlowPane rootNode = new FlowPane(10,10);
		Scene myScene = new Scene(rootNode,300,200);
		shipping.setOnAction(new ComboBoxHandler());
	}
	class ComboBoxHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			response.setText("You selected "+shipping.getValue());
		}
	}
}