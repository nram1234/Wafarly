package com.example.android.wafarly.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.wafarly.R;

public class Login extends AppCompatActivity {
String name,password;
EditText userET,passwordET;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
userET=findViewById(R.id.userName);
passwordET=findViewById(R.id.password);
textView=findViewById(R.id.textView);
textView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(Login.this, " ", Toast.LENGTH_SHORT).show();
    }
});
    }

    public void loginUser(View view) {
        name=userET.getText().toString();
        password=passwordET.getText().toString();
        if(!name.trim().isEmpty()||!password.trim().isEmpty()){
            Toast.makeText(this, " ", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Home.class));
            finish();
        }
    }

    public void registerNewUser(View view) {


    }
}
