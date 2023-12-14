import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcess {
	public static File validateFile(String [] args) 
	{

		if(args.length==0) 
		{
			System.err.println("Usage Error:program expects file name as an input!");
			System.exit(1);
		}
		File dataFile= new File(args[0]);
		if(!dataFile.exists()) 
		{
			System.err.println("Error: the file " + dataFile.getAbsolutePath() + " does not exists!");
			System.exit(1);
		}
		if(!dataFile.canRead()) 
		{
			System.err.println("Error: the file " + dataFile.getAbsolutePath()+ " cannot be opened for reading!" );
			System.exit(1);
		}
		return dataFile;
	}
	public static Scanner readData(File dataFile) 
	{
		Scanner inData=null;
		try {
			inData = new Scanner (dataFile ) ;
		} catch (FileNotFoundException e) {
			System.err.println("Error: the file "+ dataFile.getAbsolutePath()+ " cannot be opened for reading!");
			System.exit(1);
		}
		return inData;
	}
	public static void processData(DataSetList list, CSV input) 
	{
		input.getNextRow();
		for(int i=0;i<input.getNumOfRows()-1;i++) 
		{
				ArrayList<String> temp= input.getNextRow();		
				DataSet present= null;
				String date= temp.get(0);
				String [] breakDate= date.split("\\.");
				String [] breakLinks=temp.get(4).split("\n");
				ArrayList<URL> ongoing= new ArrayList<URL>();
				for(int j=0;j<breakLinks.length;j++) 
				{
					URL url;
					try {
						url = new URL(breakLinks[j]);
						ongoing.add(url);
					} catch (MalformedURLException e) {
						System.err.println("Invalid URL!");
						System.exit(1);
					}
				}
				Date curr= new Date(Integer.parseInt(breakDate[0]),Integer.parseInt(breakDate[1]),Integer.parseInt(breakDate[2]));
				try 
				{
					present= new DataSet(temp.get(2),temp.get(3),ongoing);
				}
				catch(IllegalArgumentException e) 
				{
					continue;
				}
				present.setDate(curr);
				if(temp.size()==6) 
				{
					present.setHatTips(temp.get(5));
				}
				list.add(present);		
		}
	}
	
}
