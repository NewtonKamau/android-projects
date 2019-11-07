package com.example.database;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView txtDetails;
    private EditText inputName, inputEmail;
    private Button btnSave;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //display tool bar icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        //refrence to main xml
        txtDetails = (TextView) findViewById(R.id.txt_user);
        inputName = (EditText) findViewById(R.id.name);
        inputEmail = (EditText) findViewById(R.id.email);
        btnSave = (Button) findViewById(R.id.btn_save);

        //initialize database
        mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        //store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("Realtime Database");

        //app title change listener
        mFirebaseInstance.getReference("app_title").addValueEventListener(new ValueEventListener() {           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               Log.e(TAG, "App title changed");

               //get app title
               String appTitle = dataSnapshot.getValue(String.class);
            // update toolbar title
            getSupportActionBar().setTitle(appTitle);

           }
           //No changes made
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e(TAG, "Failed to read app title value.", error.toException());
            }
        });
        //save / update user
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String email = inputEmail.getText().toString();

                //check if user exists using user id and if not call create user method
                if (TextUtils.isEmpty(userId)){

                    createUser(name, email);
                }else{
                    updateUser(name, email);
                }
            }

        });

        toggleButton();
    }
    //changing button text
    private void toggleButton() {
        if (TextUtils.isEmpty(userId)){
            btnSave.setText("Save");
        }else{
            btnSave.setText("Update");
        }
    }
    /**
     * Creating new user node under 'users'\
     * @params String name , String email
     */

    private void createUser(String name, String email) {

        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDatabase.push().getKey();
        }

        User user = new User(name, email);

        mFirebaseDatabase.child(userId).setValue(user);

        addUserChangeListener();
    }

    /**
     * User data change listener
     */
    private void addUserChangeListener() {
        //user data change listener

        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {

                    User user = dataSnapshot.getValue(User.class);

                    //check for null
                    if (user == null){
                        Log.e(TAG, "User data is null ");
                        return ;
                    }
                    Log.e(TAG, "User data is changed" + user.name + "," + user.email);

                    //Display newly updated name and email
                    txtDetails.setText(user.name + " ," + user.email);

                //clear edit text
                inputEmail.setText("");
                inputName.setText("");

                toggleButton();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
        //failed to read value
                Log.e(TAG, "Failed to read user");
            }
        });

    }
    private void updateUser(String name , String email){
        //update user via child nodes
        if(TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("name").setValue(name);

        if (TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("email").setValue(email);

    }
}
