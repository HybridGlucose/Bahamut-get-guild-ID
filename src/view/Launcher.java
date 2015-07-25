package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		try
		{
			//FXMLLoader loader = new FXMLLoader(getClass().getResource("MainGui.fxml"));
			Parent rootLayout = FXMLLoader.load(getClass().getResource("MainGui.fxml"));
			Scene scene = new Scene(rootLayout);
			primaryStage.setResizable(false);
			primaryStage.setScene(scene);
			primaryStage.setTitle("巴哈私信抓帳號");
			primaryStage.show();
			
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
