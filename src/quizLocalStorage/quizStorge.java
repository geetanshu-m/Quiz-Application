/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizLocalStorage;

import java.util.List;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author workplace
 */
public class quizStorge {
   String ques,opt1,opt2,opt3,opt4,ans;
   
   public quizStorge(String ques,String opt1,String opt2,String opt3,String opt4, String ans)
   {
       this.ques = ques;
       this.opt1 = opt1;
       this.opt2 = opt2;
       this.opt3 = opt3;
       this.opt4 = opt4;
       this.ans = ans;
   }
   public String toString() {
        return this.ques + " " + this.opt1 + " " + this.opt2 + " " + this.opt3 + " "+ this.opt4;
   }
   
   public static List parseJSON(String data)
   {
       try{
            
            Object obj = new JSONParser().parse(data);

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;

            // Result array
            JSONArray result = (JSONArray) jo.get("results");
            
            List<quizStorge> questions = new ArrayList<quizStorge>();
            
            result.forEach(item -> {
                JSONObject obj1 = (JSONObject) item;
                List<String> options  = new ArrayList<String>();
                String correctAns = (String) obj1.get("correct_answer");
                JSONArray exclude = (JSONArray) obj1.get("incorrect_answers");
                exclude.forEach(opts -> {
                    options.add(opts.toString());
                });
                questions.add(new quizStorge(obj1.get("question").toString(), options.get(0), options.get(1), options.get(2), correctAns,correctAns));
            });
            
            return questions;
            
            /*
            for (quizStorge ques : questions)
                    System.out.println(ques);
            */
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
       return new ArrayList<String>();
   }
   
   public static void main(String args[])
   {
       String data = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which one of the following actors did not voice a character in &quot;Saints Row: The Third&quot;?\",\"correct_answer\":\"Ron Jeremy\",\"incorrect_answers\":[\"Sasha Grey\",\"Burt Reynolds\",\"Hulk Hogan\"]},{\"category\":\"Entertainment: Cartoon & Animations\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"Which of the following films was Don Bluth both the writer, director, and producer for?\",\"correct_answer\":\"All Dogs Go To Heaven\",\"incorrect_answers\":[\"Titan A.E.\",\"Anastasia\",\"The Land Before Time\"]},{\"category\":\"Entertainment: Music\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"Which of these is NOT a song featured on the Lockjaw EP released in 2013 by Flume &amp; Chet Faker?\",\"correct_answer\":\"Left Alone\",\"incorrect_answers\":[\"What About Us\",\"This Song Is Not About A Girl\",\"Drop The Game\"]},{\"category\":\"Celebrities\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What was the cause of death for Freddie Mercury?\",\"correct_answer\":\"Pneumonia\",\"incorrect_answers\":[\"Stomach Cancer\",\"HIV\",\"Brain Hemorrhage\"]},{\"category\":\"Entertainment: Japanese Anime & Manga\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In JoJo&#039;s Bizarre Adventure, winch character is able to accelerate time?\",\"correct_answer\":\"Enrico Pucci\",\"incorrect_answers\":[\"Jotaro Kujo\",\"Jolyne Cujoh\",\"Kujo Jotaro\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following Elite Four members from the 6th Generation of Pok&eacute;mon was a member of Team Flare?\",\"correct_answer\":\"Malva\",\"incorrect_answers\":[\"Siebold\",\"Wikstrom\",\"Drasna\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What is the Portuguese word for &quot;Brazil&quot;?\",\"correct_answer\":\"Brasil\",\"incorrect_answers\":[\"Brazil\",\"Brasilia\",\"Bras&iacute;l\"]},{\"category\":\"Entertainment: Comics\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"In the &quot;Archie&quot; comics, who was Jughead&#039;s first girlfriend?\",\"correct_answer\":\"Joani\",\"incorrect_answers\":[\"Ethel\",\"Debbi\",\"Margret\"]},{\"category\":\"Animals\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the collective noun for a group of crows?\",\"correct_answer\":\"Murder\",\"incorrect_answers\":[\"Pack\",\"Gaggle\",\"Herd\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which item of clothing is usually worn by a Scotsman at a wedding?\",\"correct_answer\":\"Kilt\",\"incorrect_answers\":[\"Skirt\",\"Dress\",\"Rhobes\"]}]}";
       
       for (Object qs : parseJSON(data))
       {
               System.out.println(qs);
       }
   }

}
