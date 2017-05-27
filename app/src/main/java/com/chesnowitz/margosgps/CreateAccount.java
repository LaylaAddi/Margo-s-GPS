package com.chesnowitz.margosgps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {
  private EditText emailField;
  private EditText usernameField;
  private EditText passwordField;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_account);
  }
}
