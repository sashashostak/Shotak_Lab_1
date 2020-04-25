package com.exa.lab_1_shostak;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.lang.*;

public class MainActivity extends AppCompatActivity
{
    Button buttonSum;
    private static Button buttonMinus;
    private static Button buttonMultiply;
    private static Button buttonDivide;
    private static EditText editText1;
    private static EditText editText2;
    private static TextView textView;
    private static Double a1;
    private static Double a2;
    private static boolean state = true;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSum = findViewById(R.id.buttonSum);
        buttonMinus = findViewById(R.id.button2);
        buttonMultiply = findViewById(R.id.button3);
        buttonDivide = findViewById(R.id.button4);
        editText1 = findViewById(R.id.editTextNumber);
        editText2 = findViewById(R.id.editTextNumber2);
        textView = findViewById(R.id.textView2);
        //Call listeners for program(in testing)
        listeners();
    }

    private void listeners()
    {
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parser();
                textView.setText(String.valueOf(a1 + a2));
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parser();
                textView.setText(String.valueOf(a1 - a2));
            }
        });


        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parser();
                textView.setText(String.valueOf(a1 * a2));
            }
        });


        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                parser();
                textView.setText(String.valueOf(a1 / a2));
            }
        });

    }

    private void parser()
    {
        a1 = Double.parseDouble(editText1.getText().toString());
        a2 = Double.parseDouble(editText2.getText().toString());
    }
   /* private void checker(boolean isDivide)
    {
        //Check module in program.
        if(editText1.length() == 0 || editText2.length() == 0)
        {
            errMsg("Введите оба числовых аргумента");
        }
        else
        {
            try
            {
                a1 = Double.parseDouble(editText1.getText().toString());
                a2 = Double.parseDouble(editText2.getText().toString());
                if(isDivide)
                {
                    if(a2 == 0)
                    {
                        errMsg("На ноль делить нельзя!");
                    }
                    else{state = true;}
                }
                else{state = true;}

            }
            catch (Exception ex)
            {
                errMsg("Введённые данные не соответстуют программе");
            }
        }
    }*/
    private void errMsg(String Msg)
    {
        //Error message for program
        state = false;
        Toast toast = Toast.makeText(getApplicationContext(), Msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}