/*
 * Copyright (c) 2017. moxDroid Labs Inc. Used for Education purpose only.
 */

package com.modxroidlabs.friendsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.modxroidlabs.friendsbook.adapters.FriendsAdapter;
import com.modxroidlabs.friendsbook.adapters.RecyclerTouchListener;
import com.modxroidlabs.friendsbook.models.Friend;
import com.modxroidlabs.friendsbook.utils.Util;

import java.util.ArrayList;

public class ListFriendsActivity extends AppCompatActivity
{

    RecyclerView mRecyclerViewFriends;
    FriendsAdapter mFriendsAdapter;
    ArrayList<Friend>mFriendArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friends);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_display_friends_list);
        }


        mRecyclerViewFriends = (RecyclerView) findViewById(R.id.rvFriends);
        mFriendArrayList = new ArrayList<>();

        mRecyclerViewFriends.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerViewFriends.setLayoutManager(mLayoutManager);
        mRecyclerViewFriends.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        mRecyclerViewFriends.setItemAnimator(new DefaultItemAnimator());

        mRecyclerViewFriends.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerViewFriends, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Friend friend = mFriendArrayList.get(position);
                Intent mIntentFriendDetails = new Intent(ListFriendsActivity.this,DisplayFriendDetailsActivity.class);
                mIntentFriendDetails.putExtra(Util.DATA_FRIEND,friend);
                startActivity(mIntentFriendDetails);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mFriendArrayList = Friend.getmFriendArrayList();
        mFriendsAdapter = new FriendsAdapter(mFriendArrayList);
        mRecyclerViewFriends.setAdapter(mFriendsAdapter);
    }
}
