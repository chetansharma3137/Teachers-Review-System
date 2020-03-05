package com.example.chetansharma.trs2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Admin_screen extends AppCompatActivity {
    private SharedPreferenceConfigAdmin preferenceConfigAdmin;
    RadioGroup rg;
    TextView tv;
    float score_avg;
    DatabaseHelper3 databaseHelper3;
    SQLiteDatabase database;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_screen);
        preferenceConfigAdmin= new SharedPreferenceConfigAdmin(getApplicationContext());
        tv=findViewById(R.id.textView27);
        databaseHelper3=new DatabaseHelper3(getApplicationContext());
        database=databaseHelper3.getReadableDatabase();
        String res=" ";
        Cursor cursor= databaseHelper3.getScore(database);
        rg= findViewById(R.id.RadioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                if (checkedRadioButton.getText().equals("Srinivas")) {
                    startActivity(new Intent(Admin_screen.this,s_res.class));
                } else if (checkedRadioButton.getText().equals("Ramakrishna")) {

                    startActivity(new Intent(Admin_screen.this,r_res.class));
                } else if (checkedRadioButton.getText().equals("Bhasker Rao")) {
                    startActivity(new Intent(Admin_screen.this,b_res.class));
                } else {
                    startActivity(new Intent(Admin_screen.this,ma_res.class));
                }
            }
        });
        while (cursor.moveToNext())
        {
            float score=cursor.getInt(cursor.getColumnIndex(databaseHelper3.COL_1));
            score_avg=score_avg+score;
            count=count+1;


        }
        res="Our Ratings : "+score_avg/count;
        tv.setText(res);
    }

    public void adminLogout(View view) {
        preferenceConfigAdmin.writeLoginStatusAdmin(false);
        startActivity(new Intent(this,LoginActivity.class));
    }
}
