package com.jijjy.grace.mechat;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.Query;

import java.util.Queue;

/**
 * Created by grace on 4/8/16.
 */
public class ChatListAdapter extends FirebaseListAdapter<Chat> {

    //the usetname for this client(indicates which message originated from where)
    private String mUsername;

    public ChatListAdapter(Query ref, Activity activity,int layout, String mUsername){
        super(ref, Chat.class, layout, activity);
        this.mUsername = mUsername;
    }
    @Override
    protected void populateView(View view, Chat chat) {

        //Map a chat object to an entry in our list view
        String author = chat.getAuthor();
        TextView authorText = (TextView) view.findViewById(R.id.author);
        authorText.setText(author + "; ");

        if (author != null && author.equals(mUsername)) {
            authorText.setTextColor(Color.RED);
        } else {
            authorText.setTextColor(Color.BLUE);
        }
        ((TextView)view.findViewById(R.id.message)).setText(chat.getMessage());
    }
}
