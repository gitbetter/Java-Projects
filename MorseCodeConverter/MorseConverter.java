import java.io.*;
import java.util.Scanner;

public class MorseConverter
{
	public static void main(String[] args) throws IOException
	{
		String inputString, outputMorse;
		char another;

		System.out.println(" ---------------- MORSE CODE CONVERTER --------------------- \n");
		System.out.println("Input any line of text and it will be converted to morse code.");
		System.out.println("Most of the special characters have been omitted for the sake\n" + 
							"of simplicity. New characters can be added to the morsetable.txt\n" +
							"file. Enjoy!");
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Input the line of text you would like to convert:");
			inputString = input.nextLine();

			outputMorse = MorseCode.toMorse(inputString);

			System.out.println("Your originial string was:\n" + inputString);
			System.out.println("In morse, that's:\n" + outputMorse);

			System.out.println("Would you like to try another?(Y/N)");
			another = input.nextLine().charAt(0);
		} while(Character.toUpperCase(another) == 'Y');
	}
}
