package com.example.Summative1MoritaSara.controller.Magic8BallController;

import com.example.Summative1MoritaSara.models.Magic8BallModel.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class AnswerController {

        /*
    * at least 6 different questions and answers
    * ID/ Qs / Answer
    * URI: /magic
      Method: POST
      Request Body: Question
      Response Body: Answer
    * */

    private List<Answer> answerList;

    private static int idCounter = 1;

    public AnswerController() {
        answerList = new ArrayList<>();


        //add 6 answers to the list by creating new answer object and setting answer and setting ID

        answerList.add(new Answer(idCounter++, "Magic Ball says Yes!"));
        answerList.add(new Answer(idCounter++, "Magic Ball says def NOT!"));
        answerList.add(new Answer(idCounter++,  "Magic Ball says absolutely!"));
        answerList.add(new Answer(idCounter++, "Magic Ball says most likely :D"));
        answerList.add(new Answer(idCounter++, "Magic Ball says outlook is not good :("));
        answerList.add(new Answer(idCounter++, "Magic Ball says ask again later. "));

    }
    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody String question){


        //get a random ID from the list
        Random random = new Random();
        int randomID = random.nextInt(answerList.size());

        //set question to the answer object
        answerList.get(randomID).setQuestion(question);

        //return the answer object
        return answerList.get(randomID);


    }




}
