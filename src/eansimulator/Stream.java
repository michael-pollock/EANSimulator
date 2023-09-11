package eansimulator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Stream {
	
	public static List<String> characters(String fileName) throws IOException{
		Set<String> characterNames = new HashSet<String>();
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(fileName));
			input.useDelimiter("[\r\n\t,!\\.\\?\\-]+");
			while (input.hasNext()) {
				characterNames.add(input.next());
			}
			
			List<String> characters = new ArrayList<String>(characterNames.size());
			for (String eachWord : characterNames) {
				characters.add(eachWord);
			}
			return characters;			
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}
	
	public static List<String> quotes(String fileName) throws IOException{
		Set<String> allQuotes = new HashSet<String>();
		Scanner input = null;
		try {
			input = new Scanner(new FileInputStream(fileName));
			input.useDelimiter("\n");
			while (input.hasNext()) {
				allQuotes.add(input.next());
			}
			
			List<String> quotes = new ArrayList<String>(allQuotes.size());
			for (String eachQuote : allQuotes) {
				quotes.add(eachQuote);
			}
			return quotes;			
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}

}
