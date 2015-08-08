import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MorseCode
{
	private static ArrayList<ArrayList<String>> table = new ArrayList<>();

	private static void buildMorseTable() throws IOException {
		File f = new File("morsetable.txt");
		Scanner input = new Scanner(f);
		String line, tokens[];

		ArrayList<String> row;
		while(input.hasNextLine()) {
			line = input.nextLine();
			tokens = line.split("[\\s+]");
		
			row = new ArrayList<String>();
			for(String token : tokens)
				row.add(token);

			table.add(row);
		}
	}

	public static String toMorse(String str) throws IOException {
		buildMorseTable();
		
		char[] chars = str.toCharArray();
		StringBuilder converted = new StringBuilder();

		for(int i = 0; i < chars.length; i++) {
			if(Character.isWhitespace(chars[i])) {
				converted.append(" ");
				continue;
			}
			for(ArrayList<String> row : table) {
				if(Character.isLetterOrDigit(chars[i]) && Character.toString(Character.toUpperCase(chars[i])).equals(row.get(0)))
					converted.append(row.get(1));
				else if(Character.toString(chars[i]).equals(row.get(0)))
					converted.append(row.get(1));
			 
			}		
		}

		return converted.toString();	
	}
}
