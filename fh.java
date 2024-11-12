package idk;
import java.io.*;
public class fh {

	public static void main(String[] args) {
		String ReadFileName="C:\\Users\\AKSHAY\\OneDrive\\Desktop\\Whatever\\JAVAExp\\src\\idk\\Input.txt";
		String WriteFileName="C:\\Users\\AKSHAY\\OneDrive\\Desktop\\Whatever\\JAVAExp\\src\\idk\\Output.txt";
		
		String s;
		int char_count=0,word_count=0,line_count=0;
		try {
			FileReader fr=new FileReader(ReadFileName);
			BufferedReader br=new BufferedReader(fr);
			
			while((s=br.readLine())!=null) {
				String[] words=s.split(" ");
				word_count+=words.length;
				line_count++;
				for(String word:words) {
					char_count+=word.length();
				}
			}
			System.out.println("Reading finished");
			fr.close();
			FileWriter fw=new FileWriter(WriteFileName);
			String content="Words:"+word_count+"\nCharacters:"+char_count+"\nLines:"+line_count;
			fw.write(content);
			System.out.println("Writing finished");
			fw.close();
		}
		catch(IOException e) {
			System.out.println("An error occured:"+e);
		}
		
		

	}

}
