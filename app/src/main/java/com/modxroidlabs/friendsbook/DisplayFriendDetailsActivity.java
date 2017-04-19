/*
 * Copyright (c) 2017. moxDroid Labs Inc. Used for Education purpose only.
 */

package com.modxroidlabs.friendsbook;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.modxroidlabs.friendsbook.models.Friend;
import com.modxroidlabs.friendsbook.utils.Util;

public class DisplayFriendDetailsActivity extends AppCompatActivity
{
    Friend mFriend;
    TextView tvId, tvName, tvGender, tvCity, tvPhno, tvEmail, tvWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_friend_details);

        initView();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_display_friends_details);
        }

        mFriend = (Friend)getIntent().getSerializableExtra(Util.DATA_FRIEND);

        if(mFriend != null)
        {
            setFriendData();
        }
    }

    private void initView()
    {
        tvId = (TextView)findViewById(R.id.tvFriendID);
        tvName = (TextView)findViewById(R.id.tvFriendName);
        tvGender = (TextView)findViewById(R.id.tvGender);
        tvCity = (TextView)findViewById(R.id.tvFriendCity);
        tvPhno = (TextView)findViewById(R.id.tvFriendPhoneNumber);
        tvEmail = (TextView)findViewById(R.id.tvFriendEmail);
        tvWeb = (TextView)findViewById(R.id.tvFriendWebLink);
    }


    private void setFriendData()
    {
        tvId.setText(String.valueOf(mFriend.getFriendId()));
        tvName.setText(mFriend.getFriendName());
        tvGender.setText(mFriend.getGender());
        tvCity.setText(mFriend.getCity());
        tvPhno.setText(mFriend.getPhoneNumber());
        tvEmail.setText(mFriend.getEmailId());
        tvWeb.setText(mFriend.getWebSite());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_delete, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.mnuStop)
        {
            if(Friend.deleteFriendById(mFriend.getFriendId()))
            {
                Toast.makeText(this, "Delete Record", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
