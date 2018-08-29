/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz.application;

import quizLocalStorage.quizStorge;
/**
 *
 * @author workplace
 */
public class QuizApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new main_interface().setVisible(true);
        String data = "{\"response_code\":0,\"results\":[{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which one of the following actors did not voice a character in &quot;Saints Row: The Third&quot;?\",\"correct_answer\":\"Ron Jeremy\",\"incorrect_answers\":[\"Sasha Grey\",\"Burt Reynolds\",\"Hulk Hogan\"]},{\"category\":\"Entertainment: Cartoon & Animations\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"Which of the following films was Don Bluth both the writer, director, and producer for?\",\"correct_answer\":\"All Dogs Go To Heaven\",\"incorrect_answers\":[\"Titan A.E.\",\"Anastasia\",\"The Land Before Time\"]},{\"category\":\"Entertainment: Music\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"Which of these is NOT a song featured on the Lockjaw EP released in 2013 by Flume &amp; Chet Faker?\",\"correct_answer\":\"Left Alone\",\"incorrect_answers\":[\"What About Us\",\"This Song Is Not About A Girl\",\"Drop The Game\"]},{\"category\":\"Celebrities\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What was the cause of death for Freddie Mercury?\",\"correct_answer\":\"Pneumonia\",\"incorrect_answers\":[\"Stomach Cancer\",\"HIV\",\"Brain Hemorrhage\"]},{\"category\":\"Entertainment: Japanese Anime & Manga\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"In JoJo&#039;s Bizarre Adventure, winch character is able to accelerate time?\",\"correct_answer\":\"Enrico Pucci\",\"incorrect_answers\":[\"Jotaro Kujo\",\"Jolyne Cujoh\",\"Kujo Jotaro\"]},{\"category\":\"Entertainment: Video Games\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"Which of the following Elite Four members from the 6th Generation of Pok&eacute;mon was a member of Team Flare?\",\"correct_answer\":\"Malva\",\"incorrect_answers\":[\"Siebold\",\"Wikstrom\",\"Drasna\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"What is the Portuguese word for &quot;Brazil&quot;?\",\"correct_answer\":\"Brasil\",\"incorrect_answers\":[\"Brazil\",\"Brasilia\",\"Bras&iacute;l\"]},{\"category\":\"Entertainment: Comics\",\"type\":\"multiple\",\"difficulty\":\"hard\",\"question\":\"In the &quot;Archie&quot; comics, who was Jughead&#039;s first girlfriend?\",\"correct_answer\":\"Joani\",\"incorrect_answers\":[\"Ethel\",\"Debbi\",\"Margret\"]},{\"category\":\"Animals\",\"type\":\"multiple\",\"difficulty\":\"easy\",\"question\":\"What is the collective noun for a group of crows?\",\"correct_answer\":\"Murder\",\"incorrect_answers\":[\"Pack\",\"Gaggle\",\"Herd\"]},{\"category\":\"General Knowledge\",\"type\":\"multiple\",\"difficulty\":\"medium\",\"question\":\"Which item of clothing is usually worn by a Scotsman at a wedding?\",\"correct_answer\":\"Kilt\",\"incorrect_answers\":[\"Skirt\",\"Dress\",\"Rhobes\"]}]}";
        quizStorge qs = new quizStorge();
        for (Object ob : qs.parseJSON(data))
        {
            System.out.println(ob);
        }
    }
    
}
