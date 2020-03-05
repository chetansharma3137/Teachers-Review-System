package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessActivity extends AppCompatActivity {
    private SharedPreferenceConfig preferenceConfig;
    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        preferenceConfig = new SharedPreferenceConfig(getApplicationContext());
        btn = findViewById(R.id.ques1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SuccessActivity.this, Questions.class));

            }
        });
    }
}




