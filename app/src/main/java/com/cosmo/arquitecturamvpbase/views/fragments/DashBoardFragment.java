package com.cosmo.arquitecturamvpbase.views.fragments;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cosmo.arquitecturamvpbase.R;
import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.views.BaseFragment;
import com.cosmo.arquitecturamvpbase.views.adapter.DashBoardTabsAdapter;

/**
 * Created by leidycarolinazuluagabastidas on 13/10/17.
 */

public class DashBoardFragment extends BaseFragment {

    public DashBoardFragment() {
    }

    private TabLayout dashBoard_tlTabs;
    private ViewPager dashBoard_vpContainer;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dashboard, container, false);
        loadViews(view);
        loadDashBoardTabsAdapter();
        return view;
    }

    private void loadViews(View view) {
        dashBoard_tlTabs = (TabLayout) view.findViewById(R.id.dashBoard_tlTabs);
        dashBoard_vpContainer = (ViewPager) view.findViewById(R.id.dashBoard_vpContainer);
    }

    private void loadDashBoardTabsAdapter() {
        DashBoardTabsAdapter dashBoardTabsAdapter = new DashBoardTabsAdapter(getActivity().getSupportFragmentManager());
        dashBoard_vpContainer.setAdapter(dashBoardTabsAdapter);
        dashBoard_tlTabs.setupWithViewPager(dashBoard_vpContainer);
        dashBoard_tlTabs.setSelectedTabIndicatorColor(ContextCompat.getColor(getActivity(), R.color.colorWhite));
        dashBoard_tlTabs.setSelectedTabIndicatorHeight(Constants.FIVE);
        dashBoard_tlTabs.setTabTextColors(ColorStateList.valueOf(ContextCompat.getColor(getActivity(), R.color.colorWhite)));

    }
}
