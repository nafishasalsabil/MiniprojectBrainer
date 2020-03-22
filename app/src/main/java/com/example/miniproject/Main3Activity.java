package com.example.miniproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private EditText editText;
    private TextView questionNo,count,score;
    int pos = 0;
    int c = 0;
    private ProgressBar progressBar;
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
        progressBar= findViewById(R.id.progressBar2);
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
            new SweetAlertDialog(Main3Activity.this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good Job!")
                    .setContentText("Right Answer")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            pos++;
                            setData();
                            editText.setText("");
                            sweetAlertDialog.dismiss();
                        }
                    })
                    .show();


        }
        else
        {
            new SweetAlertDialog(Main3Activity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Wrong Answer")
                    .setConfirmText("OK")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            sweetAlertDialog.dismiss();
                            pos++;
                            setData();
                            editText.setText("");

                        }
                    })
                    .show();

        }


        int x = ((pos+1)*100)/questionModelArrayList.size();
        progressBar.setProgress(x);
    }
    public void setupQ()
    {
        questionModelArrayList.add(new QuestionModel("what is (10*2)/5?","4"));
        questionModelArrayList.add(new QuestionModel("what is 10*3?","30"));
        questionModelArrayList.add(new QuestionModel("what is 20/5?","4"));
        questionModelArrayList.add(new QuestionModel("what is (10-7)/3?","1"));
        questionModelArrayList.add(new QuestionModel("what is 17*6?","102"));
    }
    public void setData()
    {
        if(questionModelArrayList.size()>pos)
        {
            count.setText(questionModelArrayList.get(pos).getQuestionstring());
            questionNo.setText("Question No: "+ (pos+1));
            score.setText("Score : " + c + "/" + questionModelArrayList.size());
        }
        else
        {
            new SweetAlertDialog(Main3Activity.this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Quiz Completed!")
                    .setConfirmText("Restart")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            pos = 0;
                            c = 0;
                            progressBar.setProgress(0);
                            setData();
                        }
                    })
                    .setCancelText("See Answers")
                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {

                            sDialog.dismissWithAnimation();
                            openActivity4();

                        }
                    })
                    .show();

        }


    }


    private void openActivity4() {
        Intent intent = new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
