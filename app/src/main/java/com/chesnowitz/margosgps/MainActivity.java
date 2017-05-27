package com.chesnowitz.margosgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private Button signInButton;
  private Button createAccountButton;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    signInButton = (Button) findViewById(R.id.signInButton);
    createAccountButton = (Button) findViewById(R.id.createAccountButton);

    signInButton.setOnClickListener(this);
    createAccountButton.setOnClickListener(this);
  }

  @Override
  public void onClick(View v) {
    switch (v.getId()) {
      case R.id.signInButton:
        break;
      case R.id.createAccountButton:
        startActivity(new Intent(MainActivity.this, CreateAccount.class));
    }
  }
}
