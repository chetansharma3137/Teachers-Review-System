package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Questions extends AppCompatActivity {
    private RadioGroup rg1, rg2, rg3, rg4;
    private Button btn1;
    private int m_score_sk,r_score_sk,b_score_sk,s_score_sk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);


        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    m_score_sk = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    m_score_sk = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    m_score_sk = 2;
                } else {
                    m_score_sk = 1;
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    r_score_sk = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    r_score_sk = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    r_score_sk = 2;
                } else {
                    r_score_sk = 1;
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    b_score_sk = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    b_score_sk = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    b_score_sk = 2;
                } else {
                    b_score_sk = 1;
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    s_score_sk = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    s_score_sk = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    s_score_sk = 2;
                } else {
                    s_score_sk = 1;
                }
            }
        });




    }



    public void qs1(View view) {
        if (rg1.getCheckedRadioButtonId() == -1 || rg2.getCheckedRadioButtonId() == -1 || rg3.getCheckedRadioButtonId() == -1 || rg4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer all the questions.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent1= new Intent(Questions.this, Question2.class);

            intent1.putExtra("m_score_sk",m_score_sk);
            intent1.putExtra("r_score_sk",r_score_sk);
            intent1.putExtra("b_score_sk",b_score_sk);
            intent1.putExtra("s_score_sk",s_score_sk);
            startActivity(intent1);
        }
    }
}










