/*
 * Copyright (c) 2017. moxDroid Labs Inc. Used for Education purpose only.
 */

package com.modxroidlabs.friendsbook;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.modxroidlabs.friendsbook.models.Friend;

public class HomeActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setTitle(R.string.title_home);
            actionBar.setLogo(R.drawable.ic_action_frends);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

            final SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

            SearchView search = (SearchView) menu.findItem(R.id.action_search).getActionView();

            search.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

                @Override
                public boolean onQueryTextSubmit(String query)
                {
                    if(query.trim().length() == 0)
                        return false;

                    Friend mFriend = Friend.getFriendByName(query.trim());
                    if(mFriend == null)
                    {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);
                        alertDialog.setTitle("Search");
                        alertDialog.setMessage("No data found");
                        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        });

                        android.support.v7.app.AlertDialog dialog = alertDialog.create();
                        dialog.show();
                    }else
                    {
                        Intent mIntentSearch = new Intent(HomeActivity.this, DisplayFriendDetailsActivity.class);
                        mIntentSearch.putExtra("friendData",mFriend);
                        startActivity(mIntentSearch);
                    }
                    return true;
                }

                @Override
                public boolean onQueryTextChange(String query) {
                    return true;
                }

            });

        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

       switch (item.getItemId())
        {
            case R.id.mnuAdd:
                Intent mIntentAdd = new Intent(this,AddFriendActivity.class);
                startActivity(mIntentAdd);
                break;
            case R.id.mnuList:
                Intent mIntentList = new Intent(this,ListFriendsActivity.class);
                startActivity(mIntentList);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
