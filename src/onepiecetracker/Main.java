package onepiecetracker;

import java.io.*;
import java.net.*;


public class Main {

    public static void main (String args[]) {
    	URL site;
    	URLConnection connection;
    	String fullhtml ="";
    	String oldhtml ="";
    	
    	try {
    		URL u = new URL("https://onepiecechapters.com/mangas/5/one-piece?&date=8-3-2023-13");

    		while(true) {
    			fullhtml ="";
        		HttpURLConnection hr =(HttpURLConnection)u.openConnection();
    			if(hr.getResponseCode()==200) {
        			InputStream im =hr.getInputStream();
        			StringBuffer sb = new StringBuffer();
        			BufferedReader br=new BufferedReader(new InputStreamReader(im));
        			String line =br.readLine();

        			while(true) {
        				if(line.contains("List of Chapters")) {
        					
        					break;
        				}
        				else {
        					line=br.readLine();
        				}
        			}
        			
        			for(int i=0;i<5;i++) {
        				fullhtml+=line;
        				line=br.readLine();
        			}
        			
        		}
    			if(oldhtml.equals(fullhtml)) {

    				continue;
    			}
    			else {
    				SendNotification();
    				oldhtml = fullhtml;
    				
    			}
    		}
    		
    	}catch(Exception a) {
    		a.printStackTrace();
    	}
    }
    private static void SendNotification() {
		// TODO Auto-generated method stub
            try {
            	System.out.println("updated");
            	//TODO impliment notificiation stuff
            	
            } catch (Exception e) {
                e.printStackTrace();
            }
		
	}
	
}