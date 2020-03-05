package com.example.chetansharma.trs2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

import java.util.ArrayList;
import java.util.List;

public class ma_res extends AppCompatActivity {
    DatabaseHelper2 databaseHelper2;
    TextView tv;
    int count = 0;
    float sk_avg, tm_avg, rs_avg, cm_avg;
    GraphView graph;
    BarGraphSeries<DataPoint> series;
    SQLiteDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_res);

        tv = findViewById(R.id.textView22);
        graph = findViewById(R.id.graph);



        databaseHelper2 = new DatabaseHelper2(getApplicationContext());
        database = databaseHelper2.getWritableDatabase();
        Cursor cursor = databaseHelper2.getInfoMahesh(database);
        String res = " ";
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);



        while (cursor.moveToNext()) {
            float sk = cursor.getInt(cursor.getColumnIndex(databaseHelper2.COL_1));
            float tm = cursor.getInt(cursor.getColumnIndex(databaseHelper2.COL_2));
            float rs = cursor.getInt(cursor.getColumnIndex(databaseHelper2.COL_3));
            float cm = cursor.getInt(cursor.getColumnIndex(databaseHelper2.COL_4));
            sk_avg = sk_avg + sk;
            tm_avg = tm_avg + tm;
            rs_avg = rs_avg + rs;
            cm_avg = cm_avg + cm;
            count = count + 1;


        }
        res = "\n\nAverage Subject Knowledge Credits:" + sk_avg / count + "\n\n Average Teaching Methodology Credits:" + tm_avg / count +
                "\n\n Average Student Rapport Credits :" + rs_avg / count + "\n\n Average Classroom Management Credits:" + cm_avg / count;


        tv.setText(res);
        series = new BarGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(2, sk_avg/count),
                new DataPoint(4, tm_avg/count),
                new DataPoint(6, rs_avg/count),
                new DataPoint(8, cm_avg/count),

        });
        series.setValueDependentColor(new ValueDependentColor<DataPoint>() {
            @Override
            public int get(DataPoint data) {
                return Color.rgb((int) data.getX()*255/4, (int) Math.abs(data.getY()*255/6), 100);
            }
        });

        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(10);
        graph.getViewport().setMinY(0);
        graph.getViewport().setMaxY(8);
        series.setSpacing(50);
        graph.getGridLabelRenderer().setVerticalLabelsVisible(false);
        graph.getGridLabelRenderer().setHorizontalLabelsVisible(false);




        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);






        series.setDrawValuesOnTop(true);
        series.setValuesOnTopColor(Color.BLUE);
        graph.addSeries(series);





    }



}
