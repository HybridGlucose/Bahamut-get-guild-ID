package main;

/*
	巴哈姆特私信抓帳號v0.2
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
3.最後尾的「,」須手動刪除
	
	 //版權聲明
	 * 請勿改最此程式，本人(HybridGlucose)具有本程式著作權
 * 請勿進行任何改作
 * 非經本人同意請勿散發本程式

2015/07/19
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



public class Process {

	static Set<String> idList = new HashSet<String>();
	static String keyWord;
	static String outputID;
	static String outputFile;
	static String OutputList;
	
	public static void inputSource(String inputData,String keyWord) throws IOException
	{
		StringReader fr = new StringReader(inputData);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine())!= null)
		{
			String[] aryS = line.split("\\'*\\'");
			if (aryS[5].equals(keyWord))
			{
				idList.add(aryS[1]);//[1]為id位置，[5]為內容位置
				//System.out.print(aryS[5]);
				//System.out.print(aryS[1]+",");
			}
		}
		Iterator<String> listViewer = idList.iterator();
		StringWriter outputFile = new StringWriter();
		while (listViewer.hasNext())
		{
			for (int i = 0; i < 20; i++)
			{
				if (listViewer.hasNext())
				{
					outputID += listViewer.next() + ",";
				}
				else
					break;
			}
			outputFile.append(outputID + "\n");
			outputID = "";
		}
		OutputList = outputFile.toString();
	}
	
	public static String getOutput()
	{
		return OutputList;
	}
	
	public static String countID()
	{
		String IDs = Integer.toString(idList.size());
		return IDs;
	}
	
	public static String getStatus()
	{
		String status = "V0.2   2015/07/19";
		return status;
	}
	
	
}
