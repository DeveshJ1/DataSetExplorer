
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class DataIsPlural {
	public static void main(String [] args) 
	{  
		File dataFile= FileProcess.validateFile(args);
		Scanner inData = FileProcess.readData(dataFile); 
		
		DataSetList list= new DataSetList();
		CSV input = new CSV(inData);
		FileProcess.processData(list,input);
		UserInterface.Welcome();
        QueryHandler queryHandler = new QueryHandler(list);
		Scanner userInput= new Scanner(System.in);
		String userVal= "";
		do 
		{
            userVal = UserInterface.getUserInput(userInput);
			if(!userVal.equalsIgnoreCase("quit")) 
			{
				String result=queryHandler.processQuery(userVal);
                UserInterface.displayResult(result);
			//	QueryHandler.processQuery(userVal);
				
				}
			}
		while(!userVal.equalsIgnoreCase("quit"));
		userInput.close();	
	}
}
