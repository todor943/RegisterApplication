package com.example.dafi.registerapplication;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity implements View.OnClickListener{

    Button btnSave;
    EditText editName, editAge, editUsername, editPassword;

    DateBaseHelper dbHelper =new DateBaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        View backgroundImage = findViewById(R.id.background);
//        Drawable background = backgroundImage.getBackground();
//        background.setAlpha(145);
//
//        editName = (EditText)findViewById(R.id.editName);
//        editAge = (EditText)findViewById(R.id.editAge);
//        editUsername = (EditText)findViewById(R.id.editUsername);
//        editPassword = (EditText)findViewById(R.id.editPassword);

//        btnSave = (Button)findViewById(R.id.btnSave);
//        btnSave.setOnClickListener(this);

    }

    public void  onSignUpClick(View v){

        if(v.getId()==R.id.btnSignUp)
        {
            editName = (EditText)findViewById(R.id.editName);
            editAge = (EditText)findViewById(R.id.editAge);
            editUsername = (EditText)findViewById(R.id.editUsername);
            editPassword = (EditText)findViewById(R.id.editPassword);

            String name = editName.getText().toString();
            int age = Integer.parseInt(editAge.getText().toString());
            String username = editUsername.getText().toString();
            String password = editPassword.getText().toString();

            User user =new User();
            user.setName(name);
            user.setAge(age);
            user.setUsername(username);
            user.setPassword(password);

            dbHelper.insertUser(user);
            startActivity(new Intent(this,Login.class));
        }

    }

    @Override
    public  void  onClick(View v){
        switch (v.getId()){
            case R.id.btnSignUp:

//                String name = editName.getText().toString();
//                String username = editUsername.getText().toString();
//                String password = editPassword.getText().toString();
//                int age =Integer.parseInt(editAge.getText().toString());
//                User registerData =new User(name, username, password, age);
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}
