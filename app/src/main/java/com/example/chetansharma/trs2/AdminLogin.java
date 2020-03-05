package com.example.chetansharma.trs2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
    private SharedPreferenceConfigAdmin preferenceConfigAdmin;
    private Button submit;
    private EditText username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        submit = findViewById(R.id.button);
        username = findViewById(R.id.user);
        password = findViewById(R.id.pwd);
        preferenceConfigAdmin = new SharedPreferenceConfigAdmin(getApplicationContext());


        if (preferenceConfigAdmin.readLoginStatusAdmin()) {
            startActivity(new Intent(this, Admin_screen.class));
            finish();

        }

    }

    public void adminLogin(View view) {
        String User = username.getText().toString();
        String Pass = password.getText().toString();


        if (User.equals(getResources().getString(R.string.username)) && Pass.equals(getResources().getString(R.string.password))) {
            startActivity(new Intent(this, Admin_screen.class));
            preferenceConfigAdmin.writeLoginStatusAdmin(true);
            finish();
        } else {
            Toast.makeText(this, "Login Failed.Try Again", Toast.LENGTH_SHORT).show();
            username.setText("");
            password.setText("");
        }
    }
}
