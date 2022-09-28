package com.example.Summative1MoritaSara.controller.QuoteAPIController;

import com.example.Summative1MoritaSara.models.QuoteAPIModel.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class QuoteController {

    /* ID / Author / Quote
    *  URI: /quote
       Method: GET
       Request Body: None
       Response Body: Quote
    *
    * At least 10 quotes and served at random.
    *
    *
    * */

    public List<Quote> quoteList;
    private static int idCounter = 1;

    public QuoteController() {

        quoteList = new ArrayList<>();

        quoteList.add(new Quote(idCounter++, "Lao Tzu", "The journey of a thousand miles begins with one step."));
        quoteList.add(new Quote(idCounter++, "Albert Einstein", "Strive not to be a success, but rather to be of value."));
        quoteList.add(new Quote(idCounter++, "Mark Twain", "Twenty years from now you will be more disappointed by the things that you didn’t do than by the ones you did do."));
        quoteList.add(new Quote(idCounter++, "Eleanor Roosevelt", "Great minds discuss ideas; average minds discuss events; small minds discuss people."));
        quoteList.add(new Quote(idCounter++, "Benjamin Franklin", "He that falls in love with himself will have no rivals."));
        quoteList.add(new Quote(idCounter++, "Charles Swindoll", "Life is ten percent what happens to you and ninety percent how you respond to it."));
        quoteList.add(new Quote(idCounter++, "Voltaire", "Every man is guilty of all the good he did not do."));
        quoteList.add(new Quote(idCounter++, "Mark Twain", "Sing like no one’s listening, love like you’ve never been hurt, dance like nobody’s watching, and live like it’s heaven on earth."));
        quoteList.add(new Quote(idCounter++, "Harriet Tubman", "Every great dream begins with a dreamer. Always remember, you have within you the strength, the patience, and the passion to reach for the stars to change the world."));
        quoteList.add(new Quote(idCounter++, "Winston Churchill", "Success is not final, failure is not fatal: it is the courage to continue that counts."));


    }

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote quoteResponse(){
        Random random = new Random();
        int index = random.nextInt(quoteList.size());

        Quote quoteResult = quoteList.get(index);

        return quoteResult;


    }
}
