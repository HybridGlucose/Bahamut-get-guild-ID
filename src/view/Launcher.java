package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application 
{

	private static Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) 
	{
		/*
		try
		{
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGui.fxml"));
			Parent rootLayout = FXMLLoader.load(getClass().getResource("MainGui.fxml"));
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("巴哈私信抓帳號");
			primaryStage.getIcons().add(new Image("/icon/icon.JPG"));
			primaryStage.show();
			
			
			
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}*/
		Launcher.primaryStage = primaryStage;
		primaryStage.setTitle("巴哈私信抓帳號");
		primaryStage.setResizable(false);
		primaryStage.getIcons().add(new Image("/icon/icon.JPG"));
		initRootLayout();
		showMainGui();
		
	}
	
	public void initRootLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("RootPane.fxml"));
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
		Scene scene = new Scene(rootLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showMainGui()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Launcher.class.getResource("MainGui.fxml"));
			BorderPane MainGui = (BorderPane) loader.load();
			rootLayout.setCenter(MainGui);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public static void exit()
	{
		primaryStage.close();
	}

    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }
    
	public static void main(String[] args) 
	{
		launch(args);
	}
}
