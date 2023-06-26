package com.example.exp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text1;
    private EditText text2;

    private TextView text5;
    private Button btn1;

    private ImageView exit_app;

    private CheckBox keep_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        text5 = findViewById(R.id.textView5);
        btn1 = findViewById(R.id.btn1);
        exit_app = findViewById(R.id.exit);
        keep_password = findViewById(R.id.checkBox2);

        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text1.setText("");
                text2.setText("");
            }
        });

        exit_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text1.getText().toString().equals("123456")){
                    if (!text2.getText().toString().equals("123456")){
                        Toast toast = Toast.makeText(MainActivity.this,
                                "Wrong Password", Toast.LENGTH_LONG);
                        toast.show();
                        text2.setText("");}
                    else{
                        Toast toast = Toast.makeText(MainActivity.this,
                                "Login Successfully", Toast.LENGTH_LONG);
                        toast.show();
                        if (!keep_password.isChecked()){
                            text2.setText("");}
                        Intent intent = new Intent(MainActivity.this,
                                Logined.class);
                        System.out.println(intent);
                        startActivity(intent);}}
             else{
                    Toast toast = Toast.makeText(MainActivity.this,
                            "Please input Account", Toast.LENGTH_LONG);
                    toast.show();}}});}}