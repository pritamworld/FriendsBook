package com.modxroidlabs.friendsbook.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.modxroidlabs.friendsbook.R;
import com.modxroidlabs.friendsbook.models.Friend;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.MyViewHolder> {

    private List<Friend> mFriendList;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        MyViewHolder(View view) {
            super(view);
            txtName = (TextView) view.findViewById(R.id.txtName);
        }
    }


    public FriendsAdapter(List<Friend> friendList) {
        this.mFriendList = friendList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_friend_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Friend friend = mFriendList.get(position);
        holder.txtName.setText(friend.getFriendName());

    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }
}
