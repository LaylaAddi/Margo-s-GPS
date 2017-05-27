package com.chesnowitz.margosgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
  private Button signInButton;
  private EditText signInEmail;
  private  EditText signInPassword;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    signInButton = (Button) findViewById(R.id.loginButton);
    signInEmail = (EditText) findViewById(R.id.emaiLoginField);
    signInPassword = (EditText) findViewById(R.id.passwordLoginField);

    signInButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String userEmail = signInEmail.getText().toString();
        String userPassword = signInPassword.getText().toString();

        if (!userEmail.equals("") || !userPassword.equals("")) {
          ParseUser.logInInBackground(userEmail, userPassword, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
              if (e == null) {
                Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LoginActivity.this, LoadActivity.class));
              } else {
                Toast.makeText(getApplicationContext(), "There was a problem", Toast.LENGTH_LONG).show();
              }
            }
          });
        } else {
          Toast.makeText(getApplicationContext(), "Problem with Email/Password", Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}
