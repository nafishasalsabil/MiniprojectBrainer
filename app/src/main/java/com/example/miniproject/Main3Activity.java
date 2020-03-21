package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private TextView questionNo,count,score;
    int pos = 0;
    int c = 0;
    ArrayList<QuestionModel>questionModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        editText = findViewById(R.id.edittext);
        questionNo = findViewById(R.id.questionno);
        count = findViewById(R.id.count);
        score = findViewById(R.id.score);
        questionModelArrayList = new ArrayList<>();
        setupQ();
        setData();


    }

    @Override
    public void onClick(View v) {
    checkAnswer();

    }
    public void checkAnswer()
    {
        String answer = editText.getText().toString().trim();
        if(answer.equalsIgnoreCase(questionModelArrayList.get(pos).getAnswer()))
        {
            c++;
            pos++;
            setData();
            editText.setText("");
        }
        else
        {
            pos++;
            setData();
            editText.setText("");
        }
        if(pos==5)
        {
            openActivity4();
        }
    }
    public void setupQ()
    {
        questionModelArrayList.add(new QuestionModel("what is 1+2?","3"));
        questionModelArrayList.add(new QuestionModel("what is 10*3?","30"));
        questionModelArrayList.add(new QuestionModel("what is 20/5?","4"));
        questionModelArrayList.add(new QuestionModel("what is 10-7?","3"));
        questionModelArrayList.add(new QuestionModel("what is 17+6?","23"));
    }
    public void setData()
    {
        if(questionModelArrayList.size()>pos)
        {
            count.setText(questionModelArrayList.get(pos).getQuestionstring());
            questionNo.setText("Question No: "+ (pos+1));
            score.setText("Score : " + c + "/" + questionModelArrayList.size());
        }

    }
    private void openActivity4() {
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
