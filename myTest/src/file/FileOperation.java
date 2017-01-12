package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileOperation {
	public static void main(String args[]){
		dealData();
	}
	
	public static void dealData() {
		List<String> list = new ArrayList<String>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("E:/data/222.txt"), "UTF-8"));
			String line = null;
			for (; (line = reader.readLine()) != null;) {
				list.add(line);
				
			}
			reader.close();
			
			
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream("E:/data/111.txt"), "UTF-8"));
			for (; (line = reader.readLine()) != null;) {
				if(list.contains(line.toUpperCase())){
					
				}
				else{
					System.out.println(line);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


