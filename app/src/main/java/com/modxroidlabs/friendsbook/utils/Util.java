package com.modxroidlabs.friendsbook.utils;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by moxdroid on 2017-04-18.
 */

public class Util {

    public static String DATA_FRIEND = "friendData";

    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone) {
        return !TextUtils.isEmpty(phone) && phone.length() != 10 && Patterns.PHONE.matcher(phone).matches();
    }

    public static boolean isValidWebUrl(String webUrl) {
        return !TextUtils.isEmpty(webUrl) && Patterns.WEB_URL.matcher(webUrl).matches();
    }

    public static boolean isEmpty(String str) {
        return !TextUtils.isEmpty(str) && str.trim().length() !=0;
    }
}
