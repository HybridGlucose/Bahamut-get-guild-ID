package view;

/*
	巴哈姆特私信抓帳號v0.2.2
	本程式由HybridGlucose（a07051226@gmail.com，巴哈ID：aa07051226）撰寫，特別寫給「巴哈姆特《歷史の紳士公會<ゝω・》」專用
本程式用於抓取私信串帳號，目前功能尚未完整
	
	本程式具有以下功能：
	1.可指定關鍵字
	2.利用關鍵字抓該留言者帳號
	3.自動產生私信用帳號格式
	4.每20個帳號分行
	5.顯示出私信人數
	6.圖形化界面
	
	本程式不具有以下功能，預計未來推出
	1.最後尾的「,」須手動刪除
	
	 //版權聲明
	 * 請勿改最此程式，本人(HybridGlucose)具有本程式著作權
 * 請勿進行任何改作
 * 非經本人同意請勿散發本程式

 2015/07/20
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;




class StartGUI extends JFrame implements ActionListener
{
	private JPanel contentPane;
	private JButton startBtn = new JButton("執行");
	private JButton clearBtn = new JButton("清除");
	private JButton aboutBtn = new JButton("關於本程式");
	private JTextArea inputArea = new JTextArea();
	private JTextArea outputArea = new JTextArea();
	private JTextField filterField = new JTextField();
	private JTextField counterField = new JTextField();
	
	public StartGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("巴哈私信抓帳號");
		setVisible(true);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JButton startBtn = new JButton("執行");
		startBtn.setBounds(120, 400, 90, 30);
		startBtn.addActionListener(this);
		contentPane.add(startBtn);
		
		//JButton clearBtn = new JButton("清除");
		clearBtn.setBounds(300, 400, 90, 30);
		clearBtn.addActionListener(this);
		contentPane.add(clearBtn);
		
		//JButton aboutBtn = new JButton("關於本程式");
		aboutBtn.setBounds(480, 400, 120, 30);
		aboutBtn.addActionListener(this);
		contentPane.add(aboutBtn);
		
		//JTextArea inputArea = new JTextArea();
		inputArea.setBounds(30, 65, 180, 120);
		inputArea.setBorder(BorderFactory.createLineBorder(Color.pink));
		contentPane.add(inputArea);
		
		//JTextArea outputArea = new JTextArea();
		outputArea.setBounds(30, 230, 640, 120);
		outputArea.setBorder(BorderFactory.createLineBorder(Color.yellow));
		outputArea.setLineWrap(true);
		contentPane.add(outputArea);
		
		//JTextField filterField = new JTextField();
		filterField.setBounds(250, 65, 120, 30);
		filterField.setBorder(BorderFactory.createLineBorder(Color.blue));
		contentPane.add(filterField);
		
		//JTextField counterField = new JTextField();
		counterField.setBounds(450, 65, 120, 30);
		counterField.setBorder(BorderFactory.createLineBorder(Color.blue));
		contentPane.add(counterField);
		
		JLabel inputTitle = new JLabel("來源原始碼：");
		inputTitle.setBounds(30, 45, 180, 20);
		contentPane.add(inputTitle);
		
		JLabel outTitle = new JLabel("輸出資料：");
		outTitle.setBounds(30, 205, 180, 20);
		contentPane.add(outTitle);
		
		JLabel filterTitle = new JLabel("篩選關鍵字：");
		filterTitle.setBounds(255, 45, 180, 20);
		contentPane.add(filterTitle);
		
		JLabel counterTitle = new JLabel("本次私信人數：");
		counterTitle.setBounds(455, 45, 180, 20);
		contentPane.add(counterTitle);
		
		JLabel status = new JLabel(controller.Process.getStatus());
		status.setBounds(480, 440, 180, 20);
		contentPane.add(status);
		
		
	}
	

class AboutProgram extends JFrame
{
	private JPanel contentPane; 
	public AboutProgram() throws MalformedURLException
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("關於本程式");
		setVisible(true);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel contextTitle = new JLabel("巴哈姆特公會私信帳號整理",JLabel.CENTER);
		contextTitle.setFont(new Font(null, Font.BOLD, 18));
		contextTitle.setBounds(0, 10, 400, 23);
		contentPane.add(contextTitle);
		
		JTextArea context = new JTextArea();
		context.setBounds(30, 40, 350, 150);
		context.setText("本程式由葡萄糖專門為《歷史の紳士公會<ゝω・》公會撰寫\n");
		context.append("如果喜歡不妨給我顆紅心\n或是想要寫信給我也可以<ゝω・");
		context.setFont(new Font(null, Font.PLAIN, 14));
		context.setLineWrap(true);
		context.setEditable(false);
		contentPane.add(context);
		
		JLabel author = new JLabel("作者：葡萄糖(HybridGlucose)");
		author.setBounds(30, 250, 350, 20);
		contentPane.add(author);
		
		JLabel mail = new JLabel("電子郵件：a07051226@gmail.com");
		mail.setBounds(30, 280, 350, 20);
		contentPane.add(mail);
		
		JLabel bahaHome = new JLabel("巴哈小屋：");
		bahaHome.setBounds(30, 310, 350, 20);
		contentPane.add(bahaHome);
		
		JLabel bahaHomeurl = new JLabel("http://home.gamer.com.tw/homeindex.php?owner=aa07051226");
		bahaHomeurl.setFont(new Font(null, Font.PLAIN, 12));
		bahaHomeurl.setBounds(30, 330, 350, 20);
		contentPane.add(bahaHomeurl);
		
		JLabel icon = new JLabel(new ImageIcon(new URL("http://avatar2.bahamut.com.tw/avataruserpic/a/a/aa07051226/aa07051226.png")));
		icon.setBounds(10, 350, 110, 160);
		contentPane.add(icon);
		
		JLabel status = new JLabel(controller.Process.getStatus(), JLabel.CENTER);
		status.setFont(new Font(null, Font.ITALIC, 14));
		status.setBounds(150, 380, 300, 20);
		contentPane.add(status);
	}
}

public void actionPerformed(ActionEvent e)
{
	if (e.getSource() == startBtn)
	{
		try
		{ 
			controller.Process.inputSource(inputArea.getText(),filterField.getText());
			outputArea.setText(controller.Process.getOutput());
			counterField.setText(controller.Process.countID());
		} catch (IOException e1)
		{
			// TODO 自動產生的 catch 區塊
			e1.printStackTrace();
		}
	}
	
	if (e.getSource() == clearBtn)
	{
		inputArea.setText("");
		outputArea.setText("");
		counterField.setText("");
	}
	
	if (e.getSource() == aboutBtn)
	{
		try
		{
			AboutProgram ab = new AboutProgram();
		} catch (MalformedURLException e1)
		{
			// TODO 自動產生的 catch 區塊
			e1.printStackTrace();
		}
	}
}
}

public class SwingMainGUI  {
	public static void main(String[] args)
	{
		StartGUI mainGUI = new StartGUI();
	}

}
