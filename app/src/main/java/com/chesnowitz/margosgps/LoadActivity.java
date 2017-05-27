package com.chesnowitz.margosgps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;

public class LoadActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_load);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == R.id.logout) {
      ParseUser.logOutInBackground(new LogOutCallback() {
        @Override
        public void done(ParseException e) {
          if (e == null) {
            startActivity(new Intent(LoadActivity.this, MainActivity.class));
            Toast.makeText(LoadActivity.this, "See you later...", Toast.LENGTH_LONG).show();
          } else {

          }
        }
      });
    }
    return super.onOptionsItemSelected(item);
  }
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
//    return super.onCreateOptionsMenu(menu);
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.main_menu, menu);
    return true;
  }

}
