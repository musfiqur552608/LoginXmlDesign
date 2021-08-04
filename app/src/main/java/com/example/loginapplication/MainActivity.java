package com.example.loginapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.BulletSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userName, password;
    private Button login;
    private TextView text;
    private int count = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.userNameId);
        password = findViewById(R.id.userPasswordId);
        login = findViewById(R.id.loginBtn);
        text = findViewById(R.id.textId);
        text.setText("Number of Attempts Remaining : 3");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();
                String userpassword = password.getText().toString();

                if(username.equals("admin") && userpassword.equals("1234")){
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
                else{
                    count--;
                    text.setText("Number of Attempts Remaining : "+count);
                    if(count==0){
                        login.setEnabled(false);
                    }
                }

            }
        });
    }
}