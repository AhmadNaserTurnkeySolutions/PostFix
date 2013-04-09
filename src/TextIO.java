import java.io.*;
import java.util.Scanner;

public class TextIO {
public String text;
private File file;
String FileName="input.txt";

public TextIO(){
	this.file=new File(FileName);
	readFile();
}
public void readFile(){
	File f=file;
	
	String temp="";
	try {
		Scanner sc=new Scanner(f);
		while(sc.hasNext()){
			temp+=sc.nextLine()+"\n";
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	text=temp;;
}
public String[] stringToArray(){
	String s=text;
	
	String []sp=s.split("\n");
	
	return sp;
}
	

	
	public void WiteFile(String data)throws Exception{
		File f=new File("output.txt");
		PrintWriter wr=new PrintWriter(f);
		wr.print(data);
		wr.close();
	}
}
