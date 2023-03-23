package com.example.application1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvTest = findViewById(R.id.tv_test);
        final EditText userName = findViewById(R.id.user_name);
        final EditText userPassword = findViewById(R.id.user_password);
        Button btLogin =findViewById(R.id.bt_login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, userName.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, userPassword.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                tvTest.setText("登录成功");
            }
        });

        Button btTest2=findViewById(R.id.bt_test2);
        btTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}