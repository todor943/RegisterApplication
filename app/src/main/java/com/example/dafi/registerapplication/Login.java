package com.example.dafi.registerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    Button btnLogin;
    EditText editUsername, editPassword;
    TextView tvRegisterLink;
    UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUsername = (EditText)findViewById(R.id.editUsername);
        editPassword = (EditText)findViewById(R.id.editPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);
//        tvRegisterLink =(TextView)findViewById(R.id.tvRegistrationLink);
        btnLogin.setOnClickListener(this);

//        tvRegisterLink.setOnClickListener(this);
        userLocalStore =new UserLocalStore(this);

    }
    @Override
    public  void  onClick(View v){
        switch (v.getId()){
            case R.id.btnLogin:
//                User user = new User(null, null);
//                userLocalStore.storeUserData(user);
//                userLocalStore.setUserLeggedIn(true);

                break;
//            case R.id.tvRegistrationLink:
//                startActivity(new Intent(this,Register.class));
//                break;
        }
    }
}
