import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.event.*;
import java.text.DecimalFormat;
public class FinalProject extends Application
{
	private CheckBox song1;
	private CheckBox song2;
	private CheckBox song3;
	private CheckBox song4;
	private CheckBox song5;
	private Label songsSelected;
	private TextField amount;
	double counter;
	
	public void start(Stage myStage)
	{
		myStage.setTitle("CheckoutPage");
        //FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 10,10);
		GridPane rootNode = new GridPane();
        Scene myScene = new Scene(rootNode,400,450);
		rootNode.setAlignment(Pos.CENTER);
		rootNode.setHgap(20);
		rootNode.setVgap(10);
		rootNode.setPadding(new Insets(0));
		
		//input name
		//input email address
		//radio button payment forms (visa mastercard amex)
		//checkbox songs
		//display songs (5)
		//calculate button
		//exit button
		
		Label name = new Label("Name:");
		Label emailAddress = new Label("Email Address: ");
		Label selectPaymentForm = new Label("Payment Form:");
		songsSelected = new Label("");
		Label totalAmount = new Label("Final price:");
		Label chooseSongs = new Label("Choose what songs \nyou would like: ");
		
		//name and email textfields
		TextField nameInput = new TextField();
		TextField email = new TextField();
		
		RadioButton visa = new RadioButton("VISA");
		RadioButton masterCard = new RadioButton("MasterCard");
		RadioButton amex = new RadioButton("AMEX");
		ToggleGroup paymentForms = new ToggleGroup();
		visa.setToggleGroup(paymentForms);
		masterCard.setToggleGroup(paymentForms);
		amex.setToggleGroup(paymentForms);
		visa.setSelected(true);
		
		song1 = new CheckBox("Hungarian Rhapsody No. 2");
		song2 = new CheckBox("Bolero");
		song3 = new CheckBox("1812 Overture");
		song4 = new CheckBox("Fur Elise");
		song5 = new CheckBox("Pachbel's Canon");
		song1.setOnAction(new SongHandler());
		song2.setOnAction(new SongHandler());
		song3.setOnAction(new SongHandler());
		song4.setOnAction(new SongHandler());
		song5.setOnAction(new SongHandler());
		
		amount = new TextField();
		amount.setEditable(false);
		
		Button calculate = new Button("Calculate");
		Button exit = new Button("Exit");
		calculate.setOnAction(new CalculateHandler());
		exit.setOnAction(new ExitHandler());
		
		//events to add
		//name(label), nameInput, email(label), email input, payment label,
		//radio buttons that show payment forms, songs to be selected, song labels
		//amount and buttons
		/*rootNode.getChildren().addAll(name, nameInput, emailAddress, email,
		selectPaymentForm, visa, masterCard, amex, chooseSongs, song1,song2,
		song3,song4,song5, songsSelected, totalAmount, amount, calculate, exit);
		*/
		rootNode.add(name,0,0);
		rootNode.add(nameInput,1,0);
		rootNode.add(emailAddress,0,1);
		rootNode.add(email,1,1);
		rootNode.add(selectPaymentForm,0,2);
		rootNode.add(visa,0,3);
		rootNode.add(masterCard,0,4);
		rootNode.add(amex,0,5);
		rootNode.add(chooseSongs,1,2);
		rootNode.add(song1,1,3);
		rootNode.add(song2,1,4);
		rootNode.add(song3,1,5);
		rootNode.add(song4,1,6);
		rootNode.add(song5,1,7);
		rootNode.add(songsSelected,1,8);
		rootNode.add(totalAmount,0,6);
		rootNode.add(amount,0,7);
		rootNode.add(calculate,0,8);
		rootNode.add(exit,0,9);
		
		myStage.setScene(myScene);
		myStage.show();
	}
	class SongHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			counter = 0;
			String selected = "Your shopping cart contains: ";
			if(song1.isSelected()) {selected += "\nHungarian Rhapsody No. 2"; counter += 2.5;}
			if(song2.isSelected()) {selected += "\nBolero"; counter += 1.75;}
			if(song3.isSelected()) {selected += "\n1812 Overture"; counter += 3.5;}
			if(song4.isSelected()) {selected += "\nFur Elise"; counter += 4;}
			if(song5.isSelected()) {selected += "\nPachbel's Canon"; counter += 5;}
			songsSelected.setText(selected);
		}
	}
	class CalculateHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			String pattern = "0.00";
			DecimalFormat df = new DecimalFormat(pattern);
			amount.setText("$"+df.format(counter));
		}
	}
	class ExitHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent e)
		{
			try
			{
				Platform.exit();
			}
			catch(Exception ex){}
		}
	}
}