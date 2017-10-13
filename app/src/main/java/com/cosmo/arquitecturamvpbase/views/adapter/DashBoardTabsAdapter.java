package com.cosmo.arquitecturamvpbase.views.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cosmo.arquitecturamvpbase.helper.Constants;
import com.cosmo.arquitecturamvpbase.views.fragments.ProductsFragment;

/**
 * Created by leidycarolinazuluagabastidas on 13/10/17.
 */

public class DashBoardTabsAdapter extends FragmentStatePagerAdapter {


    public DashBoardTabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProductsFragment();
            case 1:
                return new ProductsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return Constants.TITLE_PRODUCT;
            case 1:
                return Constants.TITLE_CONTACT;
            default:
                return Constants.EMPTY;
        }
    }
}
