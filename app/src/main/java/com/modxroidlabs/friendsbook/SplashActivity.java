/*
 * Copyright (c) 2017. moxDroid Labs Inc. Used for Education purpose only.
 */

package com.modxroidlabs.friendsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.modxroidlabs.friendsbook.models.Friend;

public class SplashActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // TODO Auto-generated method stub
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        Friend.prepareFriendData();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.hide();
        }
        Toast.makeText(this,"Example for Students",Toast.LENGTH_LONG).show();
        //getActionBar().hide();
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }
}
