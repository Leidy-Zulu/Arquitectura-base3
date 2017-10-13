package com.cosmo.arquitecturamvpbase.views.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.fragments.DashBoardFragment;

import static com.cosmo.arquitecturamvpbase.R.styleable.NavigationView;

/**
 * Created by leidycarolinazuluagabastidas on 13/10/17.
 */

public class MenuActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private Toolbar toolbar;
    private FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.menuActivity_drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menuActivity_drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

   @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        boolean fragmentTransactio = false;
        //final Fragment fragment = null;
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {

            final Fragment fragment = new DashBoardFragment();
            fragmentTransactio = true;
            getSupportActionBar().setTitle("Inicio");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content_layout, fragment);
                    fragmentTransaction.commit();
                }
            },200);

            // Handle the camera action
        } else if (id == R.id.nav_perfil) {

            //fragment = new DashBoardFragment();
            fragmentTransactio = true;
            getSupportActionBar().setTitle("Perfil");

        } else if (id == R.id.nav_cerrar_sesion) {
            finish();

        }
       /*if (fragment != null) {




        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.menuActivity_drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }



}