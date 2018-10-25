package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
	
	private File file;
	
	public Analysis(File file) {
		this.file = file;
	}
	
	public int lines() throws Exception {
		Scanner scanner = new Scanner(this.file);
		int acc = 0;
		while(scanner.hasNextLine()) {
			scanner.nextLine();
			acc++;
		}
		scanner.close();
		return acc;
	}
	
	public int characters() throws Exception{
		Scanner scanner = new Scanner(this.file);
		int chars = 0;
		while (scanner.hasNext()) {
			String readString = scanner.nextLine();
			chars+= readString.length();
		}
		scanner.close();
		return chars;
	}
}
