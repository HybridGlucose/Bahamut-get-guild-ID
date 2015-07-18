package main;
/*
 	巴哈姆特私信抓帳號v0.1.2
 	本程式由HybridGlucose（a07051226@gmail.com，巴哈ID：aa07051226）撰寫，特別寫給「巴哈姆特《歷史の紳士公會<ゝω・》」專用
	本程式用於抓取私信串帳號，目前功能尚未完整
 	
 	本程式具有以下功能：
 	1.可指定關鍵字
 	2.利用關鍵字抓該留言者帳號
 	3.自動產生私信用帳號格式
 	4.每20個帳號分行
	5.顯示出私信人數
 	
 	本程式不具有以下功能，預計未來推出
	3.最後尾的「,」須手動刪除
	4.圖形化界面
 	
 	 //版權聲明
 	 * 請勿改最此程式，本人(HybridGlucose)具有本程式著作權
	 * 請勿進行任何改作
	 * 非經本人同意請勿散發本程式
	
	2015/07/18
*/
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class StartHere {

	public static void main(String[] args) throws IOException 
	{
		// TODO 自動產生的方法 Stub
		Scanner scn = new Scanner(System.in);
		System.out.print("請輸入檔案路徑（例如C://ID.txt）：");
		String filePath = scn.next();
		System.out.print("請輸入篩選關鍵字：");
		String keyWord = scn.next();
		System.out.print("請輸出檔案路徑（例如C://out.txt，請注意，檔案會直接複寫）：");
		String outPath = scn.next();
		String outputID = "";
		Set<String> idList = new HashSet<String>();
		scn.close();
		try
		{
			//接收原始檔輸入
			FileReader fr = new FileReader(filePath);
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
			Iterator<String> listViewer = idList.iterator();
			BufferedWriter outFile = new BufferedWriter(new FileWriter(outPath));
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
				outFile.write(outputID);
				outputID = "";
				outFile.newLine();
			}
			outFile.close();
			System.out.println("\n\n此次私信串人數為："+idList.size());
			System.out.println("檔案輸出位置為"+outPath);
			System.out.println("最後尾的「,」不會自動刪除，請手動刪除它");
		}
	}

}
