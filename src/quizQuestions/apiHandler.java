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
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

/**
 *
 * @author workplace
 */
public class apiHandler {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    
    // HTTP GET request
    public static String sendGet(String url){
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
    
    private static void parseJSON(String data)
    {
        try{
            
            Object obj = new JSONParser().parse(data);

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            // Result array
            JSONArray result = (JSONArray) jo.get("results");
            
            List<String> questions = new ArrayList<String>();
            
            result.forEach(item -> {
                JSONObject obj1 = (JSONObject) item;
                questions.add(obj1.get("question").toString());
            });
            
            //System.out.println(result);
            
            /*
            // getting firstName and lastName
            String firstName = (String) jo.get("firstName");
            String lastName = (String) jo.get("lastName");

            System.out.println(firstName);
            System.out.println(lastName);

            // getting age
            long age = (long) jo.get("age");
            System.out.println(age);

            // getting address
            Map address = ((Map)jo.get("address"));

            // iterating address Map
            Iterator<Map.Entry> itr1 = address.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }

            // getting phoneNumbers
            JSONArray ja = (JSONArray) jo.get("phoneNumbers");

            // iterating phoneNumbers
            Iterator itr2 = ja.iterator();

            while (itr2.hasNext()) 
            {
                itr1 = ((Map) itr2.next()).entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    System.out.println(pair.getKey() + " : " + pair.getValue());
                }
            }
            */
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    public static void main(String[] args)
    {
        // @ TODO Changeing url according to the need 
        String url = "https://opentdb.com/api.php?amount=10&type=multiple";
        
        String receivedData = sendGet(url);
        
        parseJSON(receivedData);
        
        //System.out.print(receivedData);
    }
}
