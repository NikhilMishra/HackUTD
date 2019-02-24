package com.simcoder.tinder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import java.util.*;
import java.io.*;


public class RegistrationActivity extends AppCompatActivity {

    private Button mRegister;
    private EditText mEmail, mPassword, mName;

    private RadioGroup mRadioGroup;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        /*mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user !=null){
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };*/

        mAuth = FirebaseAuth.getInstance();
        firebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user !=null){
                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };


        mRegister = (Button) findViewById(R.id.register);

        mEmail = (EditText) findViewById(R.id.email);
        mPassword = (EditText) findViewById(R.id.password);
        mName = (EditText) findViewById(R.id.name);

        mRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        // RATING BARS
        //all the question ratingbars:
        final RatingBar ratingBar29 = (RatingBar) findViewById(R.id.ratingBar29);
        final RatingBar ratingBar4 = (RatingBar) findViewById(R.id.ratingBar4);
        final RatingBar ratingBar7 = (RatingBar) findViewById(R.id.ratingBar7);
        final RatingBar ratingBar9 = (RatingBar) findViewById(R.id.ratingBar9);
        final RatingBar ratingBar11 = (RatingBar) findViewById(R.id.ratingBar11);
        final RatingBar ratingBar13 = (RatingBar) findViewById(R.id.ratingBar13);
        final RatingBar ratingBar15 = (RatingBar) findViewById(R.id.ratingBar15);
        final RatingBar ratingBar17 = (RatingBar) findViewById(R.id.ratingBar17);
        final RatingBar ratingBar19 = (RatingBar) findViewById(R.id.ratingBar19);
        final RatingBar ratingBar21 = (RatingBar) findViewById(R.id.ratingBar21);
        final RatingBar ratingBar23 = (RatingBar) findViewById(R.id.ratingBar23);
        final RatingBar ratingBar25 = (RatingBar) findViewById(R.id.ratingBar25);
        final RatingBar ratingBar27 = (RatingBar) findViewById(R.id.ratingBar27);



        //these are the importance ratingBars
        final RatingBar ratingBar30 = (RatingBar) findViewById(R.id.ratingBar30);
        final RatingBar ratingBar6 = (RatingBar) findViewById(R.id.ratingBar6);
        final RatingBar ratingBar8 = (RatingBar) findViewById(R.id.ratingBar8);
        final RatingBar ratingBar10 = (RatingBar) findViewById(R.id.ratingBar10);
        final RatingBar ratingBar12 = (RatingBar) findViewById(R.id.ratingBar12);
        final RatingBar ratingBar14 = (RatingBar) findViewById(R.id.ratingBar14);
        final RatingBar ratingBar16 = (RatingBar) findViewById(R.id.ratingBar16);
        final RatingBar ratingBar18 = (RatingBar) findViewById(R.id.ratingBar18);
        final RatingBar ratingBar20 = (RatingBar) findViewById(R.id.ratingBar20);
        final RatingBar ratingBar22 = (RatingBar) findViewById(R.id.ratingBar22);
        final RatingBar ratingBar24 = (RatingBar) findViewById(R.id.ratingBar24);
        final RatingBar ratingBar26 = (RatingBar) findViewById(R.id.ratingBar26);
        final RatingBar ratingBar28 = (RatingBar) findViewById(R.id.ratingBar28);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String answers = "";
                String priorities = "";

                answers += Math.round(ratingBar29.getRating());
                answers += Math.round(ratingBar4.getRating());
                answers += Math.round(ratingBar7.getRating());
                answers += Math.round(ratingBar9.getRating());
                answers += Math.round(ratingBar11.getRating());
                answers += Math.round(ratingBar13.getRating());
                answers += Math.round(ratingBar15.getRating());
                answers += Math.round(ratingBar17.getRating());
                answers += Math.round(ratingBar19.getRating());
                answers += Math.round(ratingBar21.getRating());
                answers += Math.round(ratingBar23.getRating());
                answers += Math.round(ratingBar25.getRating());
                answers += Math.round(ratingBar27.getRating());

                priorities += Math.round(ratingBar30.getRating());
                priorities += Math.round(ratingBar6.getRating());
                priorities += Math.round(ratingBar8.getRating());
                priorities += Math.round(ratingBar10.getRating());
                priorities += Math.round(ratingBar12.getRating());
                priorities += Math.round(ratingBar14.getRating());
                priorities += Math.round(ratingBar16.getRating());
                priorities += Math.round(ratingBar18.getRating());
                priorities += Math.round(ratingBar20.getRating());
                priorities += Math.round(ratingBar22.getRating());
                priorities += Math.round(ratingBar24.getRating());
                priorities += Math.round(ratingBar26.getRating());
                priorities += Math.round(ratingBar28.getRating());

                int selectId = mRadioGroup.getCheckedRadioButtonId();

                final RadioButton radioButton = (RadioButton) findViewById(selectId);

                if(radioButton.getText() == null){
                    return;
                }

                final String email = mEmail.getText().toString();
                final String password = mPassword.getText().toString();
                final String name = mName.getText().toString();
                final String newAnswers = answers;
                final String newPriorities = priorities;

               // mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                //@Override
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(RegistrationActivity.this, "sign up error", Toast.LENGTH_SHORT).show();
                        }else{
                            String userId = mAuth.getCurrentUser().getUid();
                            DatabaseReference currentUserDb = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);
                            Map userInfo = new HashMap<>();
                            userInfo.put("name", name);
                            userInfo.put("sex", radioButton.getText().toString());
                            userInfo.put("profileImageUrl", "default");
                            userInfo.put("answers", newAnswers);
                            userInfo.put("priorities", newPriorities);
                            currentUserDb.updateChildren(userInfo);
                        }
                    }
                });
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(firebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(firebaseAuthStateListener);
    }
}
