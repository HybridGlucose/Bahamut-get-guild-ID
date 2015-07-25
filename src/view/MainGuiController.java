package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import view.Launcher;

public class MainGuiController implements Initializable {
	@FXML
	private TextArea inputArea;
	@FXML
	private TextArea outputArea;
	@FXML
	private Label versionText;
	@FXML
	private Button execBtn;
	@FXML
	private Button clearBtn;
	@FXML
	private TextField filterField;
	@FXML
	private Text counterText;
	
	private Launcher launcher;
	
	public MainGuiController() 
	{
	}
	
	public void setLauncher(Launcher launcher)
	{
		this.launcher = launcher;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		counterText.setText("0");
		versionText.setText(controller.Process.getStatus());
	}

	@FXML
	private void exec()
	{
		try
		{
			controller.Process.inputSource(inputArea.getText(),filterField.getText());
			outputArea.setText(controller.Process.getOutput());
			counterText.setText(controller.Process.countID());
		} catch (IOException e)
		{
			// TODO 自動產生的 catch 區塊
			e.printStackTrace();
		}
	}
	
	@FXML
	private void clear()
	{
		inputArea.setText("");
		outputArea.setText("");
		counterText.setText("0");
	}
	

}
