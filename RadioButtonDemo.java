import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class RadioButtonDemo extends Application
{
	public void start(Stage myStage)
	{
		myStage.setTitle("RadioButton Demo");
		FlowPane rootNode = new FlowPane(10,10);
		Scene myScene = new Scene(rootNode,300,200);
		rootNode.setAlignment(Pos.CENTER);
		
		RadioButton usps = new RadioButton("USPS");
		RadioButton fedex = new RadioButton("FEDEX");
		RadioButton ups = new RadioButton("UPS");
		ToggleGroup myGroup = new ToggleGroup();
		usps.setToggleGroup(myGroup);
		fedex.setToggleGroup(myGroup);
		ups.setToggleGroup(myGroup);
		fedex.setSelected(true);
		rootNode.getChildren().addAll(usps, fedex, ups);
		myStage.setScene(myScene);
		myStage.show();
	}
}