package model;

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
	static String outputID = "";
	static String outputFile;
	static String OutputList;
	static int FilterMode;
	
	public static void inputSource(String inputData,String keyWord,int FilterMode) throws IOException
	{
		StringReader fr = new StringReader(inputData);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine())!= null)//逐行讀取
		{
			if (line.startsWith("all +=buildReply"))//判斷開頭文字
			{
				String[] aryS = line.split("\\'*\\'");
				if (FilterMode == 0)
				{
					if (aryS[5].equals(keyWord))
					{
						idList.add(aryS[1]);//[1]為id位置，[5]為內容位置
						//System.out.print(aryS[5]);
						//System.out.print(aryS[1]+",");
					}
				}else if (FilterMode == 1)
				{
					idList.add(aryS[1]);
				}
			}
		}
		
		//寫入List
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
				//else
					//break;
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
		String status = "V0.3   2015/07/31";
		return status;
	}
	
	
}
