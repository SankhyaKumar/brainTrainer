package com.example.sankhya.braintrainer;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {
    Button btn,btn0,btn1,btn2,btn3,playAgain;

    TextView answertext,result,text,timer;

    RelativeLayout rel1,rel2;

    ArrayList<Integer> answers = new ArrayList<Integer>();

    Random rand = new Random();



    int locationOfCorrectAnswer,score,numberOfQuestion,b,j;
    public void start(View view){
        btn.setVisibility(View.INVISIBLE);
        rel2.setVisibility(View.VISIBLE);

    }

    public void playAgain(final View view){

        score=0;
        numberOfQuestion=0;
        result.setText(score+"/"+numberOfQuestion);

        playAgain.setVisibility(View.INVISIBLE);

        generate();
        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000));
            }

            @Override
            public void onFinish() {
                answertext.setText("your score   "+score);
                playAgain.setVisibility(View.VISIBLE);
            }
        }.start();

    }

    public void generate(){



        int a=rand.nextInt(21);
        int b=rand.nextInt(21);
        int incorrectAnswer,j;

        text.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationOfCorrectAnswer=rand.nextInt(4);

        for (int i=0;i<4;i++){

            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else{
                j=rand.nextInt(40);
                if(j!=(a+b)){
                    answers.add(j);
                }
                else{
                    answers.add(j+rand.nextInt(5));
                }
            }
        }

        btn0.setText(Integer.toString(answers.get(0)));
        btn1.setText(Integer.toString(answers.get(1)));
        btn2.setText(Integer.toString(answers.get(2)));
        btn3.setText(Integer.toString(answers.get(3)));


    }

    public void check(View view){
        Log.i("tag", (String) view.getTag());
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){
            answertext.setText("correct");
            score++;
        }
        else{
            answertext.setText("wrong!!!!!!");
        }
        answers.clear();
        generate();
        numberOfQuestion++;
        result.setText(score+"/"+numberOfQuestion);



    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button);
        btn0=(Button)findViewById(R.id.button0);
        btn1=(Button)findViewById(R.id.button1);
        btn2=(Button)findViewById(R.id.button2);
        btn3=(Button)findViewById(R.id.button3);
        playAgain=(Button)findViewById(R.id.button5);

        text = (TextView) findViewById(R.id.textView3);
        timer=(TextView)findViewById(R.id.textView);
        result=(TextView)findViewById(R.id.textView2);
        answertext = (TextView)findViewById(R.id.textView4);
        answertext.setText("start!!");
        rel1=(RelativeLayout)findViewById(R.id.layout1);
        rel2=(RelativeLayout)findViewById(R.id.layout2);


        playAgain(findViewById(R.id.button5));




    }
}
