package com.modxroidlabs.friendsbook.models;

import java.io.Serializable;
import java.util.ArrayList;

//You can Implement Singleton Pattern to mange data across the application
public class Friend implements Serializable
{
    private int friendId;
    private String friendName, gender, city, phoneNumber, emailId, webSite;
    private static ArrayList<Friend>mFriendArrayList;

    public Friend() {
    }


    public Friend(int friendId, String friendName, String gender, String city, String phoneNumber, String emailId, String webSite)
    {
        this.friendId = friendId;
        this.friendName = friendName;
        this.gender = gender;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.webSite = webSite;
    }

    public int getFriendId()
    {
        return friendId;
    }

    public void setFriendId(int friendId)
    {
        this.friendId = friendId;
    }

    public String getFriendName()
    {
        return friendName;
    }

    public void setFriendName(String friendName)
    {
        this.friendName = friendName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId()
    {
        return emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getWebSite()
    {
        return webSite;
    }

    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }


    public static ArrayList<Friend> getmFriendArrayList()
    {
        return mFriendArrayList;
    }

    public static void prepareFriendData() {
        mFriendArrayList = new ArrayList<>();
        mFriendArrayList.add(new Friend(1,"Pritesh Patel", "Male", "Toronto","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(3,"Olivia", "Female", "Toronto","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(4,"Ethan Hunt", "Male", "London","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(5,"Isabella", "Female", "Toronto","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(6,"Liam", "Female", "Mumbai","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(7,"Aadam Christian", "Male", "New Delhi","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(8,"Alexander Patz", "Male", "Toronto","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(9,"William", "Male", "Ahmedabad","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(10,"Sophia Lee", "Female", "Mumbai","1234567890","test@gmail.com","http://www.google.com"));
        mFriendArrayList.add(new Friend(11,"Pippa Pip", "Male", "Toronto","1234567890","test@gmail.com","http://www.google.com"));

    }

    public static void addNewFriend(Friend mFriend)
    {
        mFriendArrayList.add(mFriend);
    }

    public static Friend getFriendByName(String name)
    {
        for (Friend f: mFriendArrayList)
        {
            if(f.getFriendName().equalsIgnoreCase(name))
                return f;
        }

        return null;
    }

    public static boolean deleteFriendById(int friendId)
    {
        for (int i=0;i< mFriendArrayList.size();i++)
        {
            if(mFriendArrayList.get(i).getFriendId() == friendId)
            {
                mFriendArrayList.remove(i);
                return  true;
            }
        }
        return false;
    }
}
