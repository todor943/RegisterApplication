package com.example.dafi.registerapplication;

import android.content.SharedPreferences;
import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;

/**
 * Created by Dafi on 2.5.2016 г..
 */
public class UserLocalStore {
    public  static final String SP_NAME ="userDetails";
    SharedPreferences userLocalDatabase;

    public  UserLocalStore(Context context) {
      userLocalDatabase = context.getSharedPreferences(SP_NAME,0);
    }

    public  void  storeUserData(User user){
SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name",user.name);
        spEditor.putString("password",user.password);
        spEditor.putString("username",user.username);
        spEditor.putInt("age",user.age);
        spEditor.commit();
    }

    public  User getLoggedUser() {
        String name = userLocalDatabase.getString("name","");
        String username = userLocalDatabase.getString("username","");
        String password = userLocalDatabase.getString("password","");
        int age = userLocalDatabase.getInt("age",1);

        User user =new User(name,username,password,age);
        return  user;
    }

    public boolean  getUserLoggedIn(){
         if(userLocalDatabase.getBoolean("LoggedIn",false)){
             return  true;
         }else {
             return false;
         }
    }

    public  void  setUserLeggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn",loggedIn);
        spEditor.commit();
    }

    public  void  cleanUserData(){
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
    }

}
