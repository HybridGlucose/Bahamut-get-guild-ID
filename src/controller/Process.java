package controller;

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
		String status = "V0.2.2   2015/07/20";
		return status;
	}
	
	
}
