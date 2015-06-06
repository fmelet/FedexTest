package com.example.federico.fedextest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Crashlytics.getInstance().core.setInt("current_level", 1);
        Crashlytics.getInstance().core.setString("last_UI_action", "logged_in1");
        Crashlytics.getInstance().core.log(Log.ERROR, "MyApp2", "Higgs-Boson detected! Bailing out...");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement



        if (id == R.id.action_settings) {
            try {
                throw new RuntimeException("This is a crash");
            } catch (Exception e) {
                Crashlytics.getInstance().core.logException(e);
                // handle your exception here!
            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
