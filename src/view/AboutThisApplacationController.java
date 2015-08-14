package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.management.loading.PrivateClassLoader;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class AboutThisApplacationController implements Initializable {

	private static Stage AboutPageStage;
	private static AnchorPane aboutPageLayout;
	
	@FXML
	private static TextFlow TextFlow;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		// TODO 自動產生的方法 Stub
	}
	public AboutThisApplacationController() {
		// TODO 自動產生的建構子 Stub
	}

	public static void initAboutPageStage()
	{
		try
		{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(AboutThisApplacationController.class.getResource("AboutThisApplacation.fxml"));
		aboutPageLayout = (AnchorPane) loader.load();
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
		Scene scene = new Scene(aboutPageLayout);
		AboutPageStage.setScene(scene);
		initAboutPageText();
		AboutPageStage.setTitle("關於本程式");
		AboutPageStage.setResizable(false);
		AboutPageStage.show();
	}
	
	public static void initAboutPageText()
	{
		Text text1 = new Text ("    巴哈姆特私信抓帳號v0.4（a07051226@gmail.com，巴哈ID：aa07051226）撰寫\n特別寫給「巴哈姆特《歷史の紳士公會<ゝω・》」專用\n本程式用於抓取私信串帳號，目前功能接近完整");
		TextFlow.getChildren().addAll(text1);
	}

}
