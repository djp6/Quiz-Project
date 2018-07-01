package com.example.android.quizapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button submit;
    int correctAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.layout1);
        rl.setBackgroundColor(Color.WHITE);
        submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(submitButtonOnClickListener);
    }
    private void checkQuestionOneAnswers(){
        CheckBox questionOneYellow = (CheckBox) findViewById(R.id.checkboxQuest1AnswerYellow);
        CheckBox questionOneBlack = (CheckBox) findViewById(R.id.checkboxQuest1AnswerBlack);
        CheckBox questionOneBlue = (CheckBox) findViewById(R.id.checkboxQuest1AnswerBlue);
        boolean isQuestionOneYellowChecked = questionOneYellow.isChecked();
        boolean isQuestionOneBlackChecked = questionOneBlack.isChecked();
        boolean isQuestionOneBlueChecked = questionOneBlue.isChecked();

        if (isQuestionOneYellowChecked && isQuestionOneBlackChecked && !isQuestionOneBlueChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionTwoAnswers(){
        RadioButton radioButton2009 = (RadioButton) findViewById(R.id.radio_2009);
        boolean isQuestionTwo2009Checked = radioButton2009.isChecked();
        if (isQuestionTwo2009Checked){
            correctAnswers += 1;
        }
    }

    private String getQuestionThreeUserInput() {
        EditText userInputLastName = (EditText) findViewById(R.id.answerInputUserLastName);
        String name = userInputLastName.getText().toString();
        return name;
    }

    private void checkQuestionThreeAnswer(){
        String name = getQuestionThreeUserInput();
        if (name.trim().equalsIgnoreCase("Jordan")){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFourAnswers(){
        RadioButton radioButtonFear = (RadioButton) findViewById(R.id.radio_Fear);
        boolean isQuestionTwoFearChecked = radioButtonFear.isChecked();
        if (isQuestionTwoFearChecked){
            correctAnswers += 1;
        }
    }

    private void checkQuestionFiveAnswers(){
        CheckBox questionFiveGreen = (CheckBox) findViewById(R.id.checkboxQuestGreen);
        CheckBox questionFiveRed = (CheckBox) findViewById(R.id.checkboxQuestRed);
        CheckBox questionFiveBlue = (CheckBox) findViewById(R.id.checkboxQuestBlue);
        boolean isQuestionFiveGreenChecked = questionFiveGreen.isChecked();
        boolean isQuestionFiveRedChecked = questionFiveRed.isChecked();
        boolean isQuestionFiveBlueChecked = questionFiveBlue.isChecked();

        if (isQuestionFiveGreenChecked && !isQuestionFiveRedChecked && isQuestionFiveBlueChecked){
            correctAnswers += 1;
        }
    }

    private void checkAllQuestions(){
        checkQuestionOneAnswers();
        checkQuestionTwoAnswers();
        checkQuestionThreeAnswer();
        checkQuestionFourAnswers();
        checkQuestionFiveAnswers();
    }

    private void resetCounterCorrectAnswers(){
        correctAnswers = 0;
    }

    final View.OnClickListener submitButtonOnClickListener = new View.OnClickListener() {
        public void onClick(final View v){
            checkAllQuestions();
            Toast.makeText(MainActivity.this, "Correct Answers: " + correctAnswers + "/5",
                    Toast.LENGTH_SHORT).show();
            resetCounterCorrectAnswers();
        }
    };
}
