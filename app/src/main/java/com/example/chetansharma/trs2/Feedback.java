package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    private RadioGroup rg1;
    private int Our_Score;
    DatabaseHelper3 databaseHelper3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        rg1=findViewById(R.id.radioGroup);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        databaseHelper3=new DatabaseHelper3(getApplicationContext());
        rg1=findViewById(R.id.radioGroup);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Really Liked it")) {
                    Our_Score = 5;
                } else if (checkedRadioButton.getText().equals("It is helpful")) {

                    Our_Score = 4;
                } else if (checkedRadioButton.getText().equals("Can be improved")) {
                    Our_Score = 2;
                } else {
                    Our_Score = 1;
                }
            }
        });
    }

    public void studLogout(View view) {
        if(rg1.getCheckedRadioButtonId()==-1  ) {
            Toast.makeText(getApplicationContext(), "Please give us a feedback!", Toast.LENGTH_SHORT).show();
        }
        else {
            databaseHelper3.insertScore(Our_Score);

            Toast.makeText(getApplicationContext(), "Thank you for the feedback.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
