package com.example.Summative1MoritaSara.controller.WordController;

import com.example.Summative1MoritaSara.models.WordModel.Definition;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DefinitionController {

        /*
    *  at least 10 definitions and at random
    *
    * ID/ Word / Definition
    *
    * URI: /word
      Method: GET
      Request Body: None
      Response Body: Definition
    * */

    private static int idCounter = 1;
    public List<Definition> definitionList;

    public DefinitionController(){

        definitionList = new ArrayList<>();

        definitionList.add(new Definition(idCounter++, "Atrocity", "An act of shocking cruelty."));
        definitionList.add(new Definition(idCounter++, "Fanatical", "Marked by excessive enthusiasm for a cause or idea."));
        definitionList.add(new Definition(idCounter++, "Pensive", "Deeply or seriously thoughtful."));
        definitionList.add(new Definition(idCounter++, "Respite", "A pause from doing something."));
        definitionList.add(new Definition(idCounter++, "Discordant", "Not in agreement or harmony."));
        definitionList.add(new Definition(idCounter++, "Eloquent", "Expressing yourself readily, clearly, effectively."));
        definitionList.add(new Definition(idCounter++, "Imperceptible", "Impossible or difficult to sense."));
        definitionList.add(new Definition(idCounter++, "Insuperable", "Incapable of being surpassed or excelled."));
        definitionList.add(new Definition(idCounter++, "Lethargy", "Inactivity; showing an unusual lack of energy."));
        definitionList.add(new Definition(idCounter++, "Lucid", "Transparently clear; easily understandable."));
    }

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Definition definitionResponse(){

        Random random = new Random();
        int index = random.nextInt(definitionList.size());
        Definition definitionOutput = definitionList.get(index);

        return definitionOutput;

    }
}
