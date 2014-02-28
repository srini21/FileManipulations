
import java.io.*;
public class WSJToMallet {

	    public static void main (String[] args) throws IOException 
	    {
	    	File malletFile=new File("C:\\Users\\User\\Desktop\\wsj.mallet");
	    	FileWriter malletWriter = new FileWriter(malletFile);
	        FileReader dataFile;
	        BufferedReader buffer;
	        File inputFile;
	    	if(!malletFile.exists()){
	            malletFile.createNewFile();
	        }  
	        BufferedWriter fileWriter=new BufferedWriter(malletWriter);
	        String filename;
	        String filepath="C:\\Users\\User\\Desktop\\wsjhw2\\";
	        for(int i=1;i<=2499;i++)
	        {
	        
	        filename="wsj_"+String.format("%04d", i)+".pos";	
	        inputFile=new File(filepath+filename);
	        if(!inputFile.exists())
	        {
	        	break;
	        }
	        dataFile = new FileReader(filepath+filename);
	        
	        buffer=new BufferedReader(dataFile);
	        
	        String temp=buffer.readLine();
	        String[] words;
	        while(temp!=null)
	        {	
	        	if(temp.startsWith("[ @")||temp.startsWith("=")||temp.trim().length()==0)
	        	{
	        		if(temp.startsWith("="))
	        		{
	        			fileWriter.newLine();
	        		}
	        	}
	        	else
	        	{	temp=temp.replace("[", " ");
	        		temp=temp.replace("]", " ");
	        		temp=temp.replace("./."," ");
	        		temp=temp.replace(",/,", " ");
	        		words=temp.split(" ");
	        		//Todo replace special characters
	        		for(String word:words)
	        		{
	        			if(word.trim().length()>0)
	        			{	word=word.trim();
	        				word=word.replace("/", " ");
	        				fileWriter.write(word);
	        				fileWriter.newLine();
	        			}
	        			
	        		}
	        		
	        			
	        	}
	        	temp=buffer.readLine();
	        }
	        
	        buffer.close();
	        }
	        fileWriter.close();
	    }
	    
}
