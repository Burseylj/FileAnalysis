package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {

	private List<String> words;

	public WordInspection(File file) throws Exception {
		this.words = getWordList(file);
	}

	private List<String> getWordList(File file) throws Exception {
		Scanner scanner = new Scanner(file, "UTF-8");
		List<String> words = new ArrayList<String>();

		while (scanner.hasNext()) {
			words.add(scanner.next());
		}
		scanner.close();
		return words;
	}

	public int wordCount() throws Exception {
		return this.words.size();
	}

	public List<String> wordsContaining(String letter) {
		List<String> wordsContaining = new ArrayList<String>();
		for (String word : this.words) {
			word = word.toLowerCase();
			if (word.contains(letter)) {
				wordsContaining.add(word);
			}
		}

		return wordsContaining;
	}

	public List<String> alliterations() {
		List<String> allits = new ArrayList<String>();
		int listIndex = 0;
		while (listIndex < words.size() - 1) {
			String word = this.words.get(listIndex);

			boolean repeat = false;

			while (true) {
				String first = word.substring(0, 1);

				if (words.get(listIndex + 1).startsWith(first)) {
					repeat = true;
					listIndex++;
					word += " " + words.get(listIndex);
				} else {
					if (repeat) {
						word += "|";
						allits.add(word);
					}
					break;
				}
			}
			listIndex++;
		}
		return allits;
	}

	public int alliterationNumber() {
		int allitCount = 0;
		int listIndex = 0;
		while (listIndex < words.size() - 1) {
			String word = this.words.get(listIndex);

			int AllitChain = 1;

			while (true) {
				String first = word.substring(0, 1);

				if (words.get(listIndex + 1).startsWith(first)) {
					AllitChain++;
					listIndex++;
					word += " " + words.get(listIndex);
				} else {
					if (AllitChain > 1) {
						word += " (" + AllitChain + ")";
						allitCount+= AllitChain;
					}
					break;
				}
			}
			listIndex++;
		}
		return allitCount;
	}
	
	
	
	public double percentAlliteration() throws Exception {
		return (double)alliterationNumber()/wordCount() *100;
	}
}
