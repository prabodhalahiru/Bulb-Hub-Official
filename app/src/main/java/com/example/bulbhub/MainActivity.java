package com.example.bulbhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bulbhub.Bulb.Users;
import com.example.bulbhub.Pbulb.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button joinNowButton, loginButton;
    //12
  //  private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinNowButton = (Button) findViewById(R.id.welcome_main_join_now_btn);
        loginButton = (Button) findViewById(R.id.welcome_main_login_btn);
        //13
       // loadingBar = new ProgressDialog(this);


        //8
        //Paper.init(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        joinNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        //9
        //String UserPhoneKey = Paper.book().read(Prevalent.UserPhoneKey);
        //String UserPasswordKey = Paper.book().read(Prevalent.UserPasswordKey);

        //10
       /* if (UserPhoneKey != "" && UserPasswordKey != "") {
            if (!TextUtils.isEmpty(UserPhoneKey) && !TextUtils.isEmpty(UserPasswordKey)) {
                AllowAccess(UserPhoneKey, UserPasswordKey);

                loadingBar.setTitle("Already Logged in");
                loadingBar.setMessage("Please Wait");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
            }
        } */
    }


            //11
            //private void AllowAccess(final String phone, final String password) {
                //paste code
                //12
               /* final DatabaseReference RootRef;
                RootRef = FirebaseDatabase.getInstance().getReference();

                RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.child("Users").child(phone).exists()){
                            Users usersData = dataSnapshot.child("Users").child(phone).getValue(Users.class);

                            if(usersData.getPhone().equals(phone)){
                                if(usersData.getPassword().equals(password)){
                                    Toast.makeText(MainActivity.this,"Wait, You are already Logged in",Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();

                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                    //SEE HERE
                                    startActivity(intent);
                                }
                                else{
                                    loadingBar.dismiss();
                                    Toast.makeText(MainActivity.this,"Incorrect Password",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this,"Account with this "+phone+"not exits",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            Toast.makeText(MainActivity.this,"Create a new account",Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }); */
            }

