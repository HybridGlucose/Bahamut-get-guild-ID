package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	@FXML
	private RadioButton keyWordRadioBtn;
	@FXML
	private RadioButton noFiliterRadioBtn;
	@FXML
	private CheckBox wrapLineCheckBox;
	@FXML
	private RadioButton idOutRadioBtn;
	@FXML
	private RadioButton nameOutRadioBtn;
	
	private Launcher launcher;
	private int FilterModeValue = 0;
	private int OutPutMode = 1;
	
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
		versionText.setText(model.Process.getStatus());
		outputMode();
	}

	@FXML
	private void exec()
	{
		try
		{
			model.Process.inputSource(inputArea.getText(),filterField.getText(),FilterModeValue,OutPutMode);
			outputArea.setText(model.Process.getOutput());
			counterText.setText(model.Process.countID());
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
		model.Process.clear();
	}
	
	@FXML
	private int filterMode()
	{
		if (keyWordRadioBtn.isSelected())
		{
			FilterModeValue = 0;
			filterField.setDisable(false);
		}
		else if (noFiliterRadioBtn.isSelected()) {
			FilterModeValue = 1;
			filterField.setDisable(true);
		}
		return FilterModeValue;
	}
	
	@FXML
	private int outputMode()
	{
		if (idOutRadioBtn.isSelected())
		{
			OutPutMode = 1;
		}else if (nameOutRadioBtn.isSelected())
		{
			OutPutMode = 3;
		}
		return OutPutMode;
	}
	
	@FXML
	private void autoWrapLine()
	{
		if (wrapLineCheckBox.isSelected())
		{
			outputArea.setWrapText(true);
		}else
		{
			outputArea.setWrapText(false);
		}
	}

}
