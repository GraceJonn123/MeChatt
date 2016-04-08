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

//    //the usetname for this client(indicates which message originated from where)
//    private String mUsername;
//
//    public ChatListAdapter(Query ref, Activity activity,int layout, String mUsername){
//        super(ref, Chat.class, layout, activity);
//        this.mUsername = mUsername;
//    }
//    @Override
//    protected void populateView(View view, Chat chat) {
//
//        //Map a chat object to an entry in our list view
//        String author = chat.getAuthor();
//        TextView authorText = (TextView) view.findViewById(R.id.author);
//        authorText.setText(author + "; ");
//
//        if (author != null && author.equals(mUsername)) {
//            authorText.setTextColor(Color.RED);
//        } else {
//            authorText.setTextColor(Color.BLUE);
//        }
//        ((TextView)view.findViewById(R.id.message)).setText(chat.getMessage());
//    }

        // The mUsername for this client. We use this to indicate which messages originated from this user
        private String mUsername;

        public ChatListAdapter(Query ref, Activity activity, int layout, String mUsername) {
            super(ref, Chat.class, layout, activity);
            this.mUsername = mUsername;
        }

        /**
         * Bind an instance of the <code>Chat</code> class to our view. This method is called by <code>FirebaseListAdapter</code>
         * when there is a data change, and we are given an instance of a View that corresponds to the layout that we passed
         * to the constructor, as well as a single <code>Chat</code> instance that represents the current data to bind.
         *
         * @param view A view instance corresponding to the layout we passed to the constructor.
         * @param chat An instance representing the current state of a chat message
         */
        @Override
        protected void populateView(View view, Chat chat) {
            // Map a Chat object to an entry in our listview
            String author = chat.getAuthor();
            TextView authorText = (TextView) view.findViewById(R.id.author);
            authorText.setText(author + ": ");
            // If the message was sent by this user, color it differently
            if (author != null && author.equals(mUsername)) {
                authorText.setTextColor(Color.RED);
            } else {
                authorText.setTextColor(Color.BLUE);
            }
            ((TextView) view.findViewById(R.id.message)).setText(chat.getMessage());
        }
}
