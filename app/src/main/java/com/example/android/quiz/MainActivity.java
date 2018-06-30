package com.example.android.quiz;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //initializing the scores
    int score = 0;
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    int score5 = 0;
    int score6 = 0;
    int score7 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    /*
    Submission of quiz validates answers provided and provides score
     */
    public void submitQuiz(View view) {
        //checks if user chose raila and jomo
        CheckBox railaCheckBox = (CheckBox) findViewById(R.id.choice_raila);
        CheckBox mzeeCheckBox = (CheckBox) findViewById(R.id.choice_mzee);

        //asks for user input
        EditText edit = (EditText) findViewById(R.id.user_input); //labels the edit text
        String result = edit.getText().toString(); //stores the user input

        //true or false of the checkboxes have been checked
        boolean railaChoice = railaCheckBox.isChecked();
        boolean mzeeChoice = mzeeCheckBox.isChecked();

        if (railaChoice && mzeeChoice == true) {
            score4 = 1;
        } else {
            score4 = 0;
        }

        if (result.equalsIgnoreCase("English")||result.equalsIgnoreCase("Kiswahili")||result.equalsIgnoreCase("Swahili")){
            score7 =1;
        }
        else {
            score7 =0;
        }

        score = score1 + score2 + score3 + score4+ score5 + score6+ score7; //updating general score

        //Displays score of Quiz
        if (score>=4){
            Toast.makeText(this,"Your Final Score is: "+score+"\n Congratulations for making it this far!", Toast.LENGTH_LONG).show();
        }
        if (score==7){
            Toast.makeText(this,"Your Final Score is: "+score+"\n Congratulations for getting all the questions correct!", Toast.LENGTH_LONG).show();
        }
        else if(score <4){
            Toast.makeText(this,"Your Final Score is: "+score+"\n Try again!", Toast.LENGTH_LONG).show();
        }

    }
    /*
    Handles revealing of answers upon clicked by user
     */
    public void revealAnswers(View view){
        String priceMessage="Answers: ";
        priceMessage+="\n1. 1963 ";
        priceMessage+="\n2. Mzee Jomo Kenyatta ";
        priceMessage+= "\n3. Mombasa ";
        priceMessage+="\n4.  Raila Odinga and Mzee Jomo Kenyatta";
        priceMessage+="\n5. 2010";
        priceMessage+="\n6. Mombasa";
        priceMessage+="\n7. English or Kiswahili or Swahili";
        displayAnswers(priceMessage);
    }

    /*
    Checks if the various radio buttons are clicked and update scores where necessary
     */
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {

            // Qn 1
            case R.id.choice_1957:
                if (checked)
                    score1 = 0;
                break;

            case R.id.choice_1964:
                if (checked)
                    score1 = 0;
                break;

            case R.id.choice_1963:
                if (checked)
                    score1 += 1;
                break;

            case R.id.choice_1994:
                if (checked)
                    score = 0;
                break;

            //Qn 2
            case R.id.choice_moi:
                if (checked)
                    score2 = 0;
                break;

            case R.id.choice_kenyatta:
                if (checked)
                    score2 = 0;
                break;

            case R.id.choice_jomo:
                if (checked)
                    score2 += 1;
                break;

            case R.id.choice_kibaki:
                if (checked)
                    score2 = 0;
                break;


            //Question 3
            case R.id.choice_nairobi:
                if (checked)
                    score3 = 0;
                break;

            case R.id.choice_kakamega:
                if (checked)
                    score3 = 0;
                break;

            case R.id.choice_kisumu:
                if (checked)
                    score3 = 0;
                break;

            case R.id.choice_mombasa:
                if (checked)
                    score3 += 1;
                break;


            //Question 5
            case R.id.choice_2010:
                if (checked)
                    score5 += 1;
                break;

            case R.id.choice_2007:
                if (checked)
                    score5 = 0;
                break;

            case R.id.choice_2008:
                if (checked)
                    score5 = 0;
                break;

            case R.id.choice_2012:
                if (checked)
                    score5 = 0;
                break;
            //End of question 5

            //Question 6
            case R.id.choice_ksm:
                if (checked)
                    score6 = 0;
                break;

            case R.id.choice_mld:
                if (checked)
                    score6 = 0;
                break;

            case R.id.choice_msa:
                if (checked)
                    score6 = 1;
                break;

            case R.id.choice_lm:
                if (checked)
                    score6 = 0;
                break;

        }
    }
    //Displays Final Score
    private void displayAnswers(String msg) {
        TextView answersTextView = (TextView) findViewById(R.id.ans_text_view);
        answersTextView.setText("" + msg);
    }
}

