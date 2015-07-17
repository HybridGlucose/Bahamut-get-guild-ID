package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StartHere {

	public static void main(String[] args) 
	{
		// TODO 自動產生的方法 Stub
		System.out.print("請輸入檔案路徑：");
		Scanner scn = new Scanner(System.in);
		String filePath = scn.next();
		/*System.out.print("請輸入行數：");
		String lineNum = scn.next();
		int num = Integer.parseInt(lineNum);*/
		try
		{
			//String str = "all +=buildReply(75152391,'calaylee2023','アッカリ〜ン蒔六夜','calaylee2023,','8小時前',0,21705604,13,'');";
			//String[] arrStr0 = str.split("\\'");
			//System.out.println(arrStr0[5].toString());
			//接收原始檔輸入
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			String line,tempString;
			//String[] tempArray = new String[num];
			int i = 0;
			while((line = br.readLine())!= null)
			{
							String[] aryS = line.split("\\'*\\'"); 
							System.out.println(aryS[5].trim()); 
			}
		} catch (FileNotFoundException e)
		{
			// TODO: handle exception
			System.out.print("檔案路徑錯誤。");
		} catch (IOException e)
		{
			System.out.print("！");
		}
		finally
		{
			
		}
	}

}
