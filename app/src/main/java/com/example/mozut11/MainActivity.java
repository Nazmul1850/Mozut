package com.example.mozut11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {
    private TextView test;
    private TextView name;
    private Button logIn;
    private Button signUp;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.test);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.password);
        logIn = findViewById(R.id.loginButton);
        signUp = findViewById(R.id.signupButton);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.loginButton:
                authenticate();
                break;
            case R.id.signupButton:
                break;
        }
    }

    private void authenticate() {
        test.setText("Log in Clicked");
    }
}