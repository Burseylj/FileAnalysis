package file;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File("C:/Users/anas/Documents/JavaLearning/EclipseFiles/Ozymandias.txt");
		File file2 = new File("C:/Users/anas/Documents/JavaLearning/EclipseFiles/test/PizzaBoy.txt");
		Analysis analysis = new Analysis(file);
		try {
		    System.out.println("Lines: " + analysis.lines());
		    System.out.println("Characters: " + analysis.characters());
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
