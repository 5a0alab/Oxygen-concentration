package app.tabsample.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.tabsample.R;

/**
 * Created by adilsoomro on 8/19/16.
 *  * Edit by Jim YMU lab421 2016/11/27

 */
public class heartFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.heart_layout, container, false);
    }
}
