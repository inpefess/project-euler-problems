package primeObsession;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem59 {
	private static String readFile (String filename) {
		String[] line;
		String fileContent = "";
		try{
			BufferedReader fin = new BufferedReader(new FileReader(filename));
			fileContent = fin.readLine();
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		line = fileContent.split(",");
		String text = "";
		for (int i = 0; i < line.length; i ++) {
			text += (char) (int) Integer.valueOf(line[i]);
		}
		return text;
	}
	
	private static String[] readWords (String filename) {
		String[] words;
		String fileContent = "00";
		try{
			BufferedReader fin = new BufferedReader(new FileReader(filename));
			fileContent = fin.readLine();
			fin.close();
		}catch (Exception e){
			//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		fileContent = fileContent.substring(1, fileContent.length() - 2);
		words = fileContent.split("\",\"");
		return words;
	}
	
	private static int wordCount (String text, String[] words) {
		int count = 0;
		String upperText = text.toUpperCase();
		for (int i = 0; i < words.length; i ++) {
			if (upperText.indexOf(words[i]) > 0) {
				count ++;
			}
		}
		return count;
	}
	
	private static String applyCipher(String text, String cipher) {
		char[] charText = text.toCharArray();
		char[] charCipher = cipher.toCharArray();
		int j = 0;
		for (int i = 0; i < text.length(); i ++) {
			charText[i] ^= charCipher[j]; 
			j = (j + 1) % cipher.length();
		}
		return new String(charText);
	}
	
	public static int solve () {
		String text = readFile("cipher1.txt");
		String[] words = readWords("words.txt");
		String maxCipher = "";
		int maxCount = 0;
		for (int i = (int) 'a'; i <= (int) 'z'; i ++) {
			for (int j = (int) 'a'; j <= (int) 'z'; j ++) {
				for (int k = (int) 'a'; k <= (int) 'z'; k ++) {
					String cipher = String.valueOf(((char) i)) + String.valueOf(((char) j)) + String.valueOf(((char) k));
					String cryptedText = applyCipher(text, cipher);
					int count = wordCount(cryptedText, words);
					if (count > maxCount) {
						maxCount = count;
						maxCipher = cipher;
					}
				}	
			}
		}
		System.out.println(maxCipher);		
		String originalText = applyCipher(text, maxCipher);
		System.out.println(originalText);
		char[] charText = originalText.toCharArray();
		int sum = 0;
		for (int i = 0; i < text.length(); i ++) {
			sum += (int) charText[i];
		}
		return sum;
	}
}