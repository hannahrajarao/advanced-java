import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
public class Assignment10 extends Application
{
	public void start(Stage myStage)
	{
		myStage.setTitle("Loan Calculator");
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(30));
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 350, 200);
		//create textfields
		TextField tf1 = new TextField();
		tf1.setAlignment(Pos.CENTER_RIGHT);
		TextField tf2 = new TextField();
		tf2.setAlignment(Pos.CENTER_RIGHT);
		TextField tf3 = new TextField();
		tf3.setAlignment(Pos.CENTER_RIGHT);
		TextField tf4 = new TextField();
		tf4.setAlignment(Pos.CENTER_RIGHT);
		TextField tf5 = new TextField();
		tf5.setAlignment(Pos.CENTER_RIGHT);
		//add labels and textfields
		rootNode.add(new Label("Annual Interest Rate:"),0,0);
		rootNode.add(tf1,1,0);
		rootNode.add(new Label("Number of Years:"),0,1);
		rootNode.add(tf2,1,1);
		rootNode.add(new Label("Loan Amount:"),0,2);
		rootNode.add(tf3,1,2);
		rootNode.add(new Label("Monthly Payment:"),0,3);
		rootNode.add(tf4,1,3);
		rootNode.add(new Label("Total Payment:"),0,4);
		rootNode.add(tf5,1,4);
		//make button
		Button calculate = new Button("Calculate");
		rootNode.add(calculate,1,5);
		rootNode.setHalignment(calculate, HPos.RIGHT);
		myStage.setScene(myScene);
		myStage.show();
	}
}