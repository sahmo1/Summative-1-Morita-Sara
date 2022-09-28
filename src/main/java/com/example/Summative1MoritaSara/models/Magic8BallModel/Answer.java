package com.example.Summative1MoritaSara.models.Magic8BallModel;

public class Answer {

    int id;
    String question;
    String answer;

    public Answer(){}

    public Answer(int id, String answer){
        this.id = id;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
