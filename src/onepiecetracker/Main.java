package onepiecetracker;

import java.io.*;
import java.net.*;


public class Main {

    public static void main (String args[]) {
    	URL site;
    	URLConnection connection;
    	
    	try {
    		URL u = new URL("https://onepiecechapters.com/mangas/5/one-piece?&date=8-3-2023-13");
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
    			
    			for(int i=0;i<400;i++) {
    				System.out.println(line+"UWU");
    				line=br.readLine();
    			}
    		}
    	}catch(Exception a) {
    		a.printStackTrace();
    	}
    }
}