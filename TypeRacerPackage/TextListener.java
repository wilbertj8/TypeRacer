package TypeRacerPackage;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Game consists of three different ways to play:
 * 1. Word by Word (firstOpt)
 * 2. Line by Line (secondOpt)
 * 3. Entire text (thirdOpt)
 */
public class TextListener {
	File filepath;
	BufferedReader read;
	boolean newWords;
	String line = "";
	String text;
	Queue<String> words; //used to pop off correctly typed words
	Scanner in;

	// constructor for accesing text from file
	public TextListener(File filelocation) {
		try {
			read = new BufferedReader(new FileReader(filelocation));
			in = new Scanner(new FileReader(filelocation));
		} catch (FileNotFoundException fnfe) {
			System.out.println("ERROR");
		}
		newWords = true;
		text = "";
		words = new LinkedList<String>();
		read();
	}

	private void read() {
		while (in.hasNext()) {
			String temp = in.next().trim();
			words.add(temp);
			text += temp + " ";
		}
	}

	// first option: word by word
	public String firstOpt() {
		System.out.println(words);
		if (words.size() > 0)
			return words.remove();
		return null;
	}

	// second option: line by line
	public String secondOpt() {
		String line = "";
		try {
			try {
				line = read.readLine().trim();
			} catch (IOException iox1) {
				System.out.println("ERROR");
				line = null; // whenever a null is returned to the main program the game is over
			}
		} catch (NullPointerException npe) {
			line = null;
		}
		return line;
	}

	public int getCharacterCount() {
		int characterCount = 0;
		try {
			String s;
			while ((s = read.readLine()) != null) {
				characterCount += s.length();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(characterCount);
		return characterCount;
	}

	// third option: entire text
	public String thirdOpt() {
		return text;
	}
}