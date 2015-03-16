package com.example.osdevlab.simplefragmenttutorial;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //set to activity_main.xml

        /*way of adding fragment with java*/
        //FragmentOne is the class which inflate the fragment_one.xml and return the view
        FragmentOne myFragment = new FragmentOne();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //'container' is android id in activity_main.xml
        //add android:id="@+id/container" in activity_main.xml
        transaction.add(R.id.container, myFragment, "main_layout_container");
        transaction.commit();
    }
}
