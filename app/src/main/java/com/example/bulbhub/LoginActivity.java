package com.example.bulbhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bulbhub.Bulb.Users;
import com.example.bulbhub.Pbulb.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

//import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    private String parentDbName = "Users";
    //4
    //private CheckBox chkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        loadingBar = new ProgressDialog(this);

        //5
        //chkBoxRememberMe = (CheckBox) findViewById(R.id.remember_me_chkb);
        //6
        //Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });
    }


            private void LoginUser() {

                String phone = InputPhoneNumber.getText().toString();
                String password = InputPassword.getText().toString();

                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(this,"Please Input a User Name",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Please a Phone Number",Toast.LENGTH_SHORT).show();

                }
                else if(TextUtils.isEmpty(password)){
                    Toast.makeText(this,"Please Input a Paasword",Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),"Please Input a password",Toast.LENGTH_SHORT).show();

                }
                else{
                    loadingBar.setTitle("Login Account");
                    loadingBar.setMessage("Please Wait");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();
                    
                    AllowAccessToAccount(phone, password);
                            
                }
            }

            //final text added
            private void AllowAccessToAccount(final String phone,final String password) {

        //7
        //if(chkBoxRememberMe.isChecked()){

            //Paper.book().write(Prevalent.UserPhoneKey, phone);
           // Paper.book().write(Prevalent.UserPasswordKey, password);
       // }

        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child(parentDbName).child(phone).exists()){
                    Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);

                    if(usersData.getPhone().equals(phone)){
                        if(usersData.getPassword().equals(password)){
                            Toast.makeText(LoginActivity.this,"Successfully Logged in",Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();

                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            //Prevalent.currentOnlineUser = usersData; //newly
                            startActivity(intent);
                        }
                        else{
                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this,"Incorrect Password",Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                else{
                    Toast.makeText(LoginActivity.this,"Account with this "+phone+"not exits",Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this,"Create a new account",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}