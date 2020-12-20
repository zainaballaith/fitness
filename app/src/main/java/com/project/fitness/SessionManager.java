package com.project.fitness;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public SessionManager(Context context) {

        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();
    }


    public void setLogin(boolean login)
    {

        editor.putBoolean("KEY_LOGIN",login);
        editor.commit();

    }


    public boolean getLogin()
    {

        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }



    public void setUsername(String username)
    {

        editor.putString("KEY_USERNAME",username);
        editor.commit();
    }


    public String getUsername()
    {
    return sharedPreferences.getString("KEY_USERNAME","");

    }
}
