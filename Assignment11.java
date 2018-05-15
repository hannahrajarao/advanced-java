import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import java.math.*;
public class Assignment11 extends Application
{
	TextField tf1;
	TextField tf2;
	TextField tf3;
	TextField tf4;
	TextField tf5;
	
	public void start(Stage myStage)
	{
		myStage.setTitle("Loan Calculator");
		//set up GridPane and Scene
		GridPane rootNode = new GridPane();
		rootNode.setPadding(new Insets(30));
		rootNode.setHgap(5);
		rootNode.setVgap(5);
		rootNode.setAlignment(Pos.CENTER);
		Scene myScene = new Scene(rootNode, 350, 200);
		
		//create textfields
		tf1 = new TextField();
		tf1.setAlignment(Pos.CENTER_RIGHT);
		tf2 = new TextField();
		tf2.setAlignment(Pos.CENTER_RIGHT);
		tf3 = new TextField();
		tf3.setAlignment(Pos.CENTER_RIGHT);
		tf4 = new TextField();
		tf4.setAlignment(Pos.CENTER_RIGHT);
		tf5 = new TextField();
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
		
		tf4.setEditable(false); //these textfields are set to uneditable because they display the result of the calculations
		tf5.setEditable(false);
		//make button
		Button calculate = new Button("Calculate");
		rootNode.add(calculate,1,5);
		rootNode.setHalignment(calculate, HPos.RIGHT);
		calculate.setOnAction(new Calculator());
		
		myStage.setScene(myScene);
		myStage.show();
	}
	//when calculate button is pressed, this class will read textfields and take over calculation
	class Calculator implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			double interest = Double.parseDouble(tf1.getText())/12; //i = periodic interest rate
			double years = Double.parseDouble(tf2.getText())*12; //n
			double amount = Double.parseDouble(tf3.getText()); //A
			double monthlyPayment;
			double totalPayment;
			
			double exponent = Math.pow(1+interest,-years);
			monthlyPayment = interest*amount/(1-exponent);
			totalPayment = years*monthlyPayment;
			
			BigDecimal val1 = BigDecimal.valueOf(monthlyPayment);
			BigDecimal val2 = BigDecimal.valueOf(totalPayment);
			val1 = val1.setScale(2,BigDecimal.ROUND_HALF_UP);
			val2 = val2.setScale(2,BigDecimal.ROUND_HALF_UP);
			tf4.setText(val1.toString());
			tf5.setText(val2.toString());
		}
	}
}