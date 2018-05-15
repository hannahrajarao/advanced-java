import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
public class MyFirstFXApplication extends Application
{
	public void start(Stage st)
	{
		st.setTitle("My First Java FX Application");
		FlowPane rootNode = new FlowPane();
		Scene myScene = new Scene(rootNode, 300, 200);
		st.setScene(myScene);
		st.show();
		st.setResizable(false);
	}
}