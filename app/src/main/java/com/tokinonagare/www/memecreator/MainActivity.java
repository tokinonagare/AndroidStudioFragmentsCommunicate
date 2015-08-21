package com.tokinonagare.www.memecreator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity implements TopSectionFragment.TopSectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //This gets called by the Top Fragment when the User clicks the button
    @Override
    public void createMeme(String Top, String Bottom) {
        BottomPictureFragment bottomFragment = (BottomPictureFragment) getFragmentManager().findFragmentById(R.id.fragment2);
        //In the tutorial Video use `getSupportFragmentManager`, but it's not valid here
        //Guess to use `getFragmentManager`, work well ^_^
        //Perhaps the question is because of the new version use different import
        //`android.support.v7.app.ActionBarActivity` replaced by `android.app.Activity`
        bottomFragment.setMemeText(Top, Bottom);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
