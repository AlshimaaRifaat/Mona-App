package com.mona.mona.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mona.mona.R;
import com.mona.mona.fragment.BrandsFragment;
import com.mona.mona.fragment.CartFragment;
import com.mona.mona.fragment.CategoriesFragment;
import com.mona.mona.fragment.HomeFragment;
import com.mona.mona.fragment.ProfileFragment;
import com.mona.mona.fragment.SettingFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment;
    private int currentSelectedPosition=0;
    NavigationView navigationView;
    public static ActionBarDrawerToggle toggle;
    public static DrawerLayout drawer;

    public static Toolbar toolbar;

    View headerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        headerView=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        onNavigationItemSelected(navigationView.getMenu().getItem(0));
       drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       /* navigationView = (NavigationView) findViewById(R.id.nav_view);*/
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
        getMenuInflater().inflate(R.menu.navigation, menu);
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
        switch (item.getItemId())
        {
            case R.id.nav_home:
                currentSelectedPosition=0;
                fragment=new HomeFragment();
                break;
            case R.id.nav_cart:
                currentSelectedPosition=1;
                fragment=new CartFragment();
                break;
            case R.id.nav_categories:
                currentSelectedPosition=2;
                fragment=new CategoriesFragment();
                break;
            case R.id.nav_brands:
                currentSelectedPosition=3;
                fragment=new BrandsFragment();
                break;
            case R.id.nav_profile:
                currentSelectedPosition=4;
                fragment=new ProfileFragment();
                break;
            case R.id.nav_setting:
                currentSelectedPosition=5;
                fragment=new SettingFragment();
                break;
          /*  case R.id.nav_OldTrip:
                currentSelectedPosition=1;
                fragment=new OldTripFragment();
                break;
            case R.id.nav_ViewMyGuides:
                currentSelectedPosition=2;
                fragment=new ViewMyGuidesFragment();
                break;*/


            default:
                currentSelectedPosition=0;
                break;
        }
        if(item.isChecked())
        {
            item.setCheckable( false );
        }else
        {
            item.setChecked( true );
        }

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add( R.id.content_navigation,fragment )
                .commit();


        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
