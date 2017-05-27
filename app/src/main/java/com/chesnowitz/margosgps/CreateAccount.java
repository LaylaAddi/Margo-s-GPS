package com.chesnowitz.margosgps;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class CreateAccount extends AppCompatActivity {
  private EditText emailField;
  private EditText usernameField;
  private EditText passwordField;
  private Button createAccountButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);

    emailField = (EditText) findViewById(R.id.userEmaiInput);
    passwordField = (EditText) findViewById(R.id.userPasswordInput);
    usernameField = (EditText) findViewById(R.id.userUsernameInput);
    createAccountButton = (Button) findViewById(R.id.createAccountButton);

    createAccountButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        createAccount();
      }
    });
  }

  private void createAccount() {
    final String userEmail = emailField.getText().toString();
    final String userName = usernameField.getText().toString();
    final String userPassword = passwordField.getText().toString();

    if (userEmail.equals("") || userName.equals("") || userPassword.equals("")) {
      AlertDialog.Builder dialog = new AlertDialog.Builder(CreateAccount.this);
      dialog.setTitle("Empty Fields");
      dialog.setMessage("You need to complete all fields");
      dialog.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
          dialog.dismiss();
        }
      });
      dialog.show();
    } else {
      ParseUser user = new ParseUser();


      user.setUsername(userName);
      user.setPassword(userPassword);
      user.setEmail(userEmail);

      user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
          if (e == null) {
            emailField.setEnabled(false);
            passwordField.setEnabled(false);
            usernameField.setEnabled(false);
            createAccountButton.setEnabled(false);

            // log them in

            logTheUserIn(userName, userPassword);
          }
        }
      });
    }
  }

  private void logTheUserIn(String userName, String userPassword) {
    if (!userName.equals("") || !passwordField.equals("")) {

      ParseUser.logInInBackground(userName, userPassword, new LogInCallback() {
        @Override
        public void done(ParseUser user, ParseException e) {
          if (e == null) {
            Log.v("User logged in is --> ", user.getUsername());

            startActivity(new Intent(CreateAccount.this, LoadActivity.class));

          } else {

          }
        }
      });
    } else {

    }
  }
}