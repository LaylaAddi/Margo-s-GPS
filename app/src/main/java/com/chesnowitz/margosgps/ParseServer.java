package com.chesnowitz.margosgps;

/**
 * Created by steve on 5/26/2017.
 */



import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class ParseServer extends Application {
  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Database.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("vYJ3YcZoCUDjT2nbBugynzyR2Sk0TGYtXk4NKtLI")
            .clientKey("pL1AaeRMhRWLLVwFfzNMgxhzMAqOtJW9bBu1tzH5")
            .server("https://parseapi.back4app.com/")
            .build()
    );

    //ParseUser.enableAutomaticUser();

    ParseACL defaultACL = new ParseACL();
    defaultACL.setPublicReadAccess(true);
    defaultACL.setPublicWriteAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);

    //Test code to see if the APP is working properly.
//        ParseObject object = new ParseObject("AssClass");
//        object.put("user","TestUser");
//
//        object.saveEventually(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.i("Parse","SUCCESS");
//                } else {
//                    Log.i("Parse","FAILED");
//                }
//            }
//        });
  }
}
