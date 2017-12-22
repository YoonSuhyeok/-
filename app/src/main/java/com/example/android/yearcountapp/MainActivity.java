package com.example.android.yearcountapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText frist;
    EditText second;
    TextView result;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frist  = findViewById(R.id.first);
        second = findViewById(R.id.second);
        result = findViewById(R.id.resultButton);
        button = (Button)findViewById(R.id.result);
        button.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {

                String first_text = frist.getText().toString();
                String second_text = second.getText().toString();

                // 4444 22 11 0123 45 67

                int first_year = Integer.parseInt(first_text.substring(0,4));
                int second_year = Integer.parseInt(second_text.substring(0,4));

                int first_month = Integer.parseInt(first_text.substring(4,6));
                int second_month = Integer.parseInt(second_text.substring(4,6));

                int first_day = Integer.parseInt(first_text.substring(6,8));
                int second_day = Integer.parseInt(second_text.substring(6,8));

                // 살아온 날짜를 구하고 거기서 태어난 날짜부터 살아온 날짜를 구하자
                Calendar aDate = Calendar.getInstance();
                Calendar bDate = Calendar.getInstance();
                Calendar cDate = Calendar.getInstance();

                long frist_days = 0;
                long second_days = 0;

                aDate.set(first_year,first_month,first_day);
                bDate.set(second_year,second_month,second_day);

                frist_days = (cDate.getTimeInMillis()-aDate.getTimeInMillis())/(24*60*60*1000);
                second_days = (cDate.getTimeInMillis()-bDate.getTimeInMillis())/(24*60*60*1000);

                if(frist_days>second_days){
                    long result_day = frist_days-second_days;
                    result.setText(Long.toString(result_day*24));
//                    result.setText(Long.toString(result_day));
                }
                else{
                    long result_day = second_days-frist_days;
                    result.setText(Long.toString(result_day*24));
//                    result.setText(Long.toString(result_day));
                }
            }

        });
    }


}
