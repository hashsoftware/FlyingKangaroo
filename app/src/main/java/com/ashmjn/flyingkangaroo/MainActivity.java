package com.ashmjn.flyingkangaroo;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public final static String about_us = "com.ashmjn.flyingKangaroo.ABOUT_US";
    public final static String contact_us = "com.ashmjn.flyingKangaroo.CONTANCT_US";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        switch (id) {
            case R.id.nav_home:

                break;
            case R.id.nav_tax:

                break;
            case R.id.nav_slideshow:

                break;
            case R.id.nav_manage:
                break;
            case R.id.nav_about_us:
                System.out.println("about us");
                fragment = new AboutUsFragment();
                break;
            case R.id.nav_contact_us:
                System.out.println("contact us");
                fragment = new ContactUsFragment();
//                String contactUs = "Application Developers for this project are: \n" +
//                        "1. Ashish Maharjan nnnn\n" +
//                        "2. Pramesh Shrestha \n" +
//                        "3. Madanmani Adhikari \n" +
//                        "4. Pradeep Kumar \n" +
//                        "Please contact us for the any queries realated to the software.";
//                Intent intent = new Intent(this, ContanctUs.class);
//                intent.putExtra(contact_us,contactUs);
//                startActivity(intent);
                break;
            default:
                break;
        }
//        if (id == R.id.nav_home) {
//            // Handle the camera action
//        } else if (id == R.id.nav_tax) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_about_us) {
//            System.out.println("about us");
//            fragment = new AboutUsFragment();
////            String aboutUs = "Flying Kangaroo is an android application for our Project. This is a version 0.0.1 application released.";
////            Intent intent = new Intent(this, AboutUs.class);
////            intent.putExtra(about_us,aboutUs);
////            startActivity(intent);
//        } else if (id == R.id.nav_contact_us) {
//            System.out.println("contact us");
//            String contactUs = "Application Developers for this project are: \n" +
//                    "1. Ashish Maharjan \n" +
//                    "2. Pramesh Shrestha \n" +
//                    "3. Madanmani Adhikari \n" +
//                    "4. Pradeep Kumar \n" +
//                    "Please contact us for the any queries realated to the software.";
//            Intent intent = new Intent(this, ContanctUs.class);
//            intent.putExtra(contact_us,contactUs);
//            startActivity(intent);
//
//        }

        if (fragment != null) {
            System.out.println("here inside layout ");

            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }
}
