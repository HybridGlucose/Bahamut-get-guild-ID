package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class MenuBarController implements Initializable {


	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO 自動產生的方法 Stub	
	}
	
	public MenuBarController()
	{	
	}

	public void closeApplacation()
	{
		Launcher.exit();
	}
	
	public void aboutThisApplacation()
	{
		
	}
}
