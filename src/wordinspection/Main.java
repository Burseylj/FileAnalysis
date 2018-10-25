package wordinspection;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		String[] filenames = {"GinsbergBeatHowl.txt","GlobeAndMail.txt","MedievalGreenKnight.txt","MTV-Online.txt","Ozymandias.txt","RenaisanceTheFlea.txt","RomanticPoeTheRaven.txt"};
		for (String filename : filenames){
			try {
				File file = new File("Texts/"+filename);
				WordInspection fInspect = new WordInspection(file);
				System.out.println("Alliterations in " + filename + ":\n" +fInspect.alliterations());
				String percent = String.format("%.02f", fInspect.percentAlliteration());
				System.out.println(filename+" has " + percent + "% words that participate in alliteration\n");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.print(e.getLocalizedMessage());
			}
		}
	}

}
