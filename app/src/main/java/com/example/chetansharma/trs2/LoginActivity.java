package com.example.chetansharma.trs2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText rollno, dateofbirth;
    private TextView tv;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv = findViewById(R.id.admin);
        rollno = findViewById(R.id.rno);

        dateofbirth = findViewById(R.id.dob);
        login = findViewById(R.id.Login);

        databaseHelper = new DatabaseHelper(LoginActivity.this);


        String text = "Click HERE for Admin Login";
        SpannableString ss = new SpannableString(text);
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(LoginActivity.this, "Admin login", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, AdminLogin.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };
        ss.setSpan(clickableSpan, 6, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isExist = databaseHelper.checkUserExist(rollno.getText().toString(), dateofbirth.getText().toString());
                if (isExist) {
                    Intent intent = new Intent(LoginActivity.this, SuccessActivity.class);
                    intent.putExtra("Rollno", rollno.getText().toString());

                    startActivity(intent);
                } else {
                    dateofbirth.setText(null);
                    Toast.makeText(LoginActivity.this, "Login failed.Please try Again", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}


