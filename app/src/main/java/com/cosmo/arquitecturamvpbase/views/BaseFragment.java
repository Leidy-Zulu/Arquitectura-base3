package com.cosmo.arquitecturamvpbase.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cosmo.arquitecturamvpbase.helper.IValidateInternet;
import com.cosmo.arquitecturamvpbase.presenter.BasePresenter;

/**
 * Created by leidycarolinazuluagabastidas on 13/10/17.
 */

public class BaseFragment<T extends BasePresenter> extends Fragment implements IBaseView {

    private BaseActivity baseActivity;
    private IValidateInternet validateInternet;
    private T presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseActivity = (BaseActivity) getActivity();
        validateInternet = baseActivity.getValidateInternet();
    }

    @Override
    public void showProgress(int message) {
        baseActivity.showProgress(message);
    }

    @Override
    public void hideProgress() {
        baseActivity.hideProgress();

    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }


    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }


    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
