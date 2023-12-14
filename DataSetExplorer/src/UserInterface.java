import java.util.Scanner;

public class UserInterface {
	public static void Welcome() 
	{
		System.out.println("Welcome to the Data Is Plural data explorer!\nYou can use the following queries to search"
				+ " through the data:\n\t title KEYWORD\n\t description KEYWORD\n\t url KEYWORD\n You can combine"
				+ " up to two queries to narrow down the results, for example:\n\t title KEYWORD1\t url KEYWORD2");
	}
	  public static String getUserInput(Scanner userInput) {
	        System.out.println("Enter query or \"quit\" to stop:");
	        return userInput.nextLine();
	    }
	  public static void displayResult(String result) {
	        System.out.println(result);
	    }
	  

}
