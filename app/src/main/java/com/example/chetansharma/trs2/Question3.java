package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {
    private RadioGroup rg1, rg2, rg3, rg4;
    private int m_score_rs,r_score_rs,b_score_rs,s_score_rs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        rg1 = findViewById(R.id.radioGroup);
        rg2 = findViewById(R.id.radioGroup2);
        rg3 = findViewById(R.id.radioGroup3);
        rg4 = findViewById(R.id.radioGroup4);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    m_score_rs = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    m_score_rs = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    m_score_rs = 2;
                } else {
                    m_score_rs = 1;
                }
            }
        });

        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    r_score_rs = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    r_score_rs = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    r_score_rs = 2;
                } else {
                    r_score_rs = 1;
                }
            }
        });

        rg3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    b_score_rs = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    b_score_rs = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    b_score_rs = 2;
                } else {
                    b_score_rs = 1;
                }
            }
        });
        rg4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Strongly Agree")) {
                    s_score_rs = 5;
                } else if (checkedRadioButton.getText().equals("Agree")) {

                    s_score_rs = 4;
                } else if (checkedRadioButton.getText().equals("Disagree")) {
                    s_score_rs = 2;
                } else {
                    s_score_rs = 1;
                }
            }
        });
    }

    public void ques4(View view) {
        if (rg1.getCheckedRadioButtonId() == -1 || rg2.getCheckedRadioButtonId() == -1 || rg3.getCheckedRadioButtonId() == -1 || rg4.getCheckedRadioButtonId() == -1) {
            Toast.makeText(getApplicationContext(), "Please answer all the questions.", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent intent= getIntent();
            Bundle bundle = intent.getExtras();
            Integer msk=bundle.getInt("m_score_sk");
            Integer rsk=bundle.getInt("r_score_sk");
            Integer bsk=bundle.getInt("b_score_sk");
            Integer ssk=bundle.getInt("s_score_sk");
            Integer mtm=bundle.getInt("m_score_tm");
            Integer rtm=bundle.getInt("r_score_tm");
            Integer btm=bundle.getInt("b_score_tm");
            Integer stm=bundle.getInt("s_score_tm");

            Intent intent3= new Intent(Question3.this, Question4.class);
            intent3.putExtra("m_score_rs",m_score_rs);
            intent3.putExtra("r_score_rs",r_score_rs);
            intent3.putExtra("b_score_rs",b_score_rs);
            intent3.putExtra("s_score_rs",s_score_rs);
            intent3.putExtra("m_score_tm",mtm);
            intent3.putExtra("r_score_tm",rtm);
            intent3.putExtra("b_score_tm",btm);
            intent3.putExtra("s_score_tm",stm);
            intent3.putExtra("m_score_sk",msk);
            intent3.putExtra("r_score_sk",rsk);
            intent3.putExtra("b_score_sk",bsk);
            intent3.putExtra("s_score_sk",ssk);
            startActivity(intent3);

        }
    }
}
