package com.cosmo.arquitecturamvpbase.views.activities;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.helper.CustomSharedPreferences;
import com.cosmo.arquitecturamvpbase.model.User;
import com.cosmo.arquitecturamvpbase.views.BaseActivity;
import com.cosmo.arquitecturamvpbase.views.adapter.DashBoardTabsAdapter;

/**
 * Created by leidycarolinazuluagabastidas on 13/10/17.
 */

public class DashboardActivity extends BaseActivity {

    private TabLayout dashBoard_tlTabs;
    private ViewPager dashBoard_vpContainer;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadViews();
        loadToolbar();
        loadDashBoardTabsAdapter();
    }

    private void loadToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(Constants.EMPTY);
        setSupportActionBar(toolbar);
    }


    private void loadViews() {
        dashBoard_tlTabs = (TabLayout) findViewById(R.id.dashBoard_tlTabs);
        dashBoard_vpContainer = (ViewPager) findViewById(R.id.dashBoard_vpContainer);
    }

    private void loadDashBoardTabsAdapter() {
        DashBoardTabsAdapter dashBoardTabsAdapter = new DashBoardTabsAdapter(getSupportFragmentManager());
        dashBoard_vpContainer.setAdapter(dashBoardTabsAdapter);
        dashBoard_tlTabs.setupWithViewPager(dashBoard_vpContainer);
        dashBoard_tlTabs.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorWhite));
        dashBoard_tlTabs.setSelectedTabIndicatorHeight(Constants.FIVE);
        dashBoard_tlTabs.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(this, R.color.colorWhite)));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.accion_cerrar_sesion){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }
}
