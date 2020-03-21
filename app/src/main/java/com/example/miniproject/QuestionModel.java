package com.example.miniproject;

public class QuestionModel {
    private  String questionstring;
    private String answer;
    public QuestionModel(String QuestionString, String Answer)
    {
        questionstring = QuestionString;
        answer = Answer;
    }

    public String getQuestionstring() {
        return questionstring;
    }

    public void setQuestionstring(String questionstring) {
        this.questionstring = questionstring;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
