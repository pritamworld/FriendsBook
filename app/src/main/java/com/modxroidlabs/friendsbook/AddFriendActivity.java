/*
 * Copyright (c) 2017. moxDroid Labs Inc. Used for Education purpose only.
 */

package com.modxroidlabs.friendsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.modxroidlabs.friendsbook.models.Friend;
import com.modxroidlabs.friendsbook.utils.Util;

public class AddFriendActivity extends AppCompatActivity implements View.OnClickListener
{
    String arrayCity[];
    EditText edtId, edtName, edtPhno, edtEmail, edtWebLink;
    TextInputLayout tilId, tilName, tilPhno, tilEmail, tilWebLink, tilCity, tilGender;
    RadioGroup rgGender;
    Spinner mSpinnerCity;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_add_new_friend);
        }

        initView();

        arrayCity = getResources().getStringArray(R.array.array_city_list);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayCity);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        mSpinnerCity.setAdapter(dataAdapter);

    }

    private void initView() {
        edtId = (EditText)findViewById(R.id.edtFriendId);
        tilId = (TextInputLayout)findViewById(R.id.tilId);

        edtName = (EditText)findViewById(R.id.edtFriendName);
        tilName = (TextInputLayout)findViewById(R.id.tilName);

        edtPhno = (EditText)findViewById(R.id.edtFriendPhoneNumber);
        tilPhno = (TextInputLayout)findViewById(R.id.tilPhno);

        edtEmail = (EditText)findViewById(R.id.edtFriendEmail);
        tilEmail = (TextInputLayout)findViewById(R.id.tilEmail);

        edtWebLink = (EditText)findViewById(R.id.edtFriendWebLink);
        tilWebLink = (TextInputLayout)findViewById(R.id.tilWebUrl);

        rgGender = (RadioGroup)findViewById(R.id.rbgGender);
        tilGender = (TextInputLayout)findViewById(R.id.tilGender);

        mSpinnerCity = (Spinner)findViewById(R.id.spCity);
        tilCity = (TextInputLayout)findViewById(R.id.tilCity);

        btnSave = (Button)findViewById(R.id.btnSubmit);
        btnSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Friend mFriend = new Friend();
        boolean isValid = true;

        //Friend ID Validation
        if (Util.isEmpty(edtId.getText().toString())) {
            mFriend.setFriendId(Integer.parseInt(edtId.getText().toString()));
            tilId.setErrorEnabled(false);
        } else {
            isValid = false;
            tilId.setError(getString(R.string.error_enter_id));
        }

        //Friend Name Validation
        if (Util.isEmpty(edtName.getText().toString())) {
            mFriend.setFriendName(edtName.getText().toString());
            tilName.setErrorEnabled(false);
        } else {
            isValid = false;
            tilName.setError(getString(R.string.error_enter_name));
        }

        //Friend Gender Selection Validation
        if (rgGender.getCheckedRadioButtonId() != -1) {
            if (rgGender.getCheckedRadioButtonId() == R.id.rbMale) {
                mFriend.setGender(getString(R.string.lbl_male));
            }else {
                mFriend.setGender(getString(R.string.lbl_female));
            }
            tilGender.setErrorEnabled(false);
        } else {
            isValid = false;
            tilGender.setError(getString(R.string.error_gender));
        }

        //Friend City Selection Validation
        if (!mSpinnerCity.getSelectedItem().toString().equalsIgnoreCase(arrayCity[0])) {
            mFriend.setCity(mSpinnerCity.getSelectedItem().toString());
            tilCity.setErrorEnabled(false);
        } else {
            isValid = false;
            tilCity.setError(getString(R.string.error_city));
            //Toast.makeText(AddFriendActivity.this, "Select City", Toast.LENGTH_SHORT).show();
        }

        //Friend Phone Number Validation
        if (Util.isValidPhone(edtPhno.getText().toString())) {
            mFriend.setPhoneNumber(edtPhno.getText().toString());
            tilPhno.setErrorEnabled(false);
        } else {
            isValid = false;
            tilPhno.setError(getString(R.string.error_phone));
        }

        //Friend Email ID Validation
        if (Util.isValidEmail(edtEmail.getText().toString())) {
            mFriend.setEmailId(edtEmail.getText().toString());
            tilEmail.setErrorEnabled(false);
        } else {
            isValid = false;
            tilEmail.setError(getString(R.string.error_email));
        }

        //Friend Web URL Validation
        if(Util.isValidWebUrl(edtWebLink.getText().toString())) {
            mFriend.setWebSite(edtWebLink.getText().toString());
            tilWebLink.setErrorEnabled(false);
        }
        else {
            isValid = false;
            tilWebLink.setError(getString(R.string.error_web_link));
        }

        //Final submit check
        if (isValid) {
            Friend.addNewFriend(mFriend);
            Toast.makeText(this, R.string.msg_add_success, Toast.LENGTH_SHORT).show();

            Intent mIntent = new Intent(AddFriendActivity.this, ListFriendsActivity.class);
            startActivity(mIntent);
        }
    }

}
