/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizQuestions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author workplace
 */
public class apiHandler {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    // HTTP GET request
    private static String sendGet(String url){
        try{
            // String url = "https://opentdb.com/api.php?amount=10";
		
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            // add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = con.getResponseCode();
            //System.out.println("\nSending 'GET' request to URL : " + url);
            //System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
            }
            in.close();

            //print result
            //System.out.print(response.toString());
            return response.toString();
        }
        catch(Exception e)
        {
            return e.toString();
        }
    }
    
    public static void main(String[] args)
    {
        // @ TODO Changeing url according to the need 
        String url = "https://opentdb.com/api.php?amount=10";
        
        System.out.print(sendGet(url));
    }
}
