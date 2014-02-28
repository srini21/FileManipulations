
import java.io.*;
public class NLPAtisToMallet {

	    public static void main (String[] args) throws IOException 
	    {

	        FileReader dataFile = new FileReader("C:\\Users\\User\\Desktop\\atis.pos");
	        File malletFile=new File("C:\\Users\\User\\Desktop\\atis.mallet");
	        FileWriter malletWriter = new FileWriter(malletFile);
	        if(!malletFile.exists()){
	            malletFile.createNewFile();
	        }  
	        BufferedReader buffer=new BufferedReader(dataFile);
	        BufferedWriter fileWriter=new BufferedWriter(malletWriter);
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
	        		for(String i:words)
	        		{
	        			if(i.trim().length()>0)
	        			{	i=i.trim();
	        				i=i.replace("/", " ");
	        				fileWriter.write(i);
	        				fileWriter.newLine();
	        			}
	        			
	        		}
	        		
	        			
	        	}
	        	temp=buffer.readLine();
	        }
	        buffer.close();
	        fileWriter.close();
	    }
	    
}
