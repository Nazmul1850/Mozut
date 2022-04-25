package com.example.mozut11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mozut11.database.Controller;
import com.example.mozut11.database.User;
import com.google.android.gms.common.api.Api;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ClientRegisterActivity extends AppCompatActivity implements Controller.CreateAccountInterface {
    EditText nameText,emailText,phoneNumberText,passwordText,rePasswordText;
    Button registerButton;
    TextView registerText,messageText;
    ImageView clientProfile;
    Button imageSetButton;
    Bitmap imageBitmap;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_register);
        nameText = (EditText) findViewById(R.id.client_register_name);
        emailText = (EditText) findViewById(R.id.client_register_email);
        phoneNumberText = (EditText) findViewById(R.id.client_register_phone_number);
        passwordText = (EditText) findViewById(R.id.client_register_password);
        rePasswordText = (EditText) findViewById(R.id.client_register_retype_password);
        registerButton = (Button) findViewById(R.id.client_register_button);
        registerText = (TextView) findViewById(R.id.client_register_text);
        messageText = (TextView) findViewById(R.id.client_register_message_text);
        progressBar = (ProgressBar) findViewById(R.id.register_progress);
        Controller.CreateAccountInterface createAccountInterface = this;
        registerButton.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View view) {
                String name,email,phoneNumber,password,rePassword;
                name = nameText.getText().toString();
                email = emailText.getText().toString();
                phoneNumber = phoneNumberText.getText().toString();
                password = passwordText.getText().toString();
                rePassword = rePasswordText.getText().toString();
                //Log.d("noaman",imageBitmap.toString());
                if(name.compareTo("") == 0)
                {
                    messageText.setText("Type your name");
                    nameText.setFocusable(true);
                    return;
                }
                if(email.compareTo("") == 0)
                {
                    messageText.setText("Type your email");
                    emailText.setFocusable(true);
                    return;
                }
                if(phoneNumber.compareTo("") == 0)
                {
                    messageText.setText("Type your phone number");
                    phoneNumberText.setFocusable(true);
                    return;
                }
                if(password.compareTo("") == 0)
                {
                    messageText.setText("Type your password");
                    passwordText.setFocusable(true);
                    return;
                }
                if(rePassword.compareTo("") == 0)
                {
                    messageText.setText("Re-type your password");
                    rePasswordText.setFocusable(true);
                    return;
                }
                if(password.compareTo(rePassword) != 0)
                {
                    messageText.setText("Password must have to be same");
                    return;
                }

                Log.d("noman",name);
                User user = new User(name,phoneNumber,email,"doctor");
                Controller.createAccount(user,password,createAccountInterface);
                makeButtonInvisible();



            }
        });

    }
    private void makeButtonVisible()
    {
        progressBar.setVisibility(View.INVISIBLE);
        registerButton.setVisibility(View.VISIBLE);
    }
    private void makeButtonInvisible()
    {
        registerButton.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }


    @Override
    public void setAccount(String message) {
        makeButtonVisible();
        messageText.setText(message);
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
