package com.example.dafi.registerapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnRegister, btnLogin;
    EditText  editUsername, editPassword;
    UserLocalStore userLocalStore;

    DateBaseHelper dbHelper =new DateBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
//        editUsername = (EditText)findViewById(R.id.editUsername);
        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(this);

        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

//    @Override
//    public void  onStart(){
//        super.onStart();
//        if(authenticate()){
//            displayDetails();
//        }
//    }

//    private void displayDetails(){
//
//        User user = userLocalStore.getLoggedUser();
//
//        editName.setText(user.name);
//        editUsername.setText(user.username);
//        editAge.setText(user.age+"");
//    }

    private  boolean  authenticate(){
        return userLocalStore.getUserLoggedIn();
    }


    public void  LogIn(){

        editUsername = (EditText)findViewById(R.id.editUsername);
        editPassword = (EditText)findViewById(R.id.editPassword);
        String username = editUsername.getText().toString();
        String password = editPassword.getText().toString();

        String searchedPassword =   dbHelper.searchPass(username);
        if(password.equals(searchedPassword)){
            startActivity(new Intent(this,CatalogActivity.class));
        }
        else {
            Toast.makeText(MainActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public  void  onClick(View v){
        switch (v.getId()){
            case R.id.btnRegister:
                startActivity(new Intent(this,Register.class));
                break;
            case R.id.btnLogin:
                LogIn();
                break;
        }
    }
}
