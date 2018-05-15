import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
public class CheckBoxDemo extends Application
{
	private CheckBox byMail;
	private CheckBox byEMail;
	private CheckBox noThanks;
	private Label response; //full line of text that will be manipulated; label is like a wrapper for receipts
	private String receipts; //will change with each selection
	
	public void start(Stage myStage)
	{
		myStage.setTitle("CheckBox Demo");
		FlowPane rootNode = new FlowPane(10,10);
		Scene myScene = new Scene(rootNode,300,200);
		rootNode.setAlignment(Pos.CENTER);
		
		byMail = new CheckBox("Mail");
		byEMail = new CheckBox("Email");
		noThanks = new CheckBox("No receipt needed");
		response = new Label("");
		Label ques = new Label("How would you like to receive your receipt?");
		byMail.setOnAction(new ReceiptHandler());
		byEMail.setOnAction(new ReceiptHandler());
		noThanks.setOnAction(new NoReceiptHandler());
		rootNode.getChildren().addAll(ques, byMail,byEMail,noThanks, response);
		myStage.setScene(myScene);
		myStage.show();
	}
	class ReceiptHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			showAll();
		}
	}
	class NoReceiptHandler implements EventHandler<ActionEvent>
	//same showAll method is used, however, other options are deselected first
	{
		public void handle(ActionEvent e)
		{
			byMail.setSelected(false);
			byEMail.setSelected(false);
			showAll();
		}
	}
	public void showAll()
	{
		receipts = "Receipts will be send via: ";
		if(byMail.isSelected()) receipts += "Mail: ";
		if(byEMail.isSelected()) receipts += "Email: ";
		if(noThanks.isSelected()) receipts += "No Receipt Needed";
		response.setText(receipts);
	}
}