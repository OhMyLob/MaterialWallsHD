package com.lob.mwhd.fragments;

/*
 * *******************************************************************************
 * The second Fragment, configure the GridView using the Minimal style wallpapers
 * *******************************************************************************
 */

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.lob.mwhd.R;
import com.lob.mwhd.URLs;
import com.lob.mwhd.gridview.SetupGridView;
import com.lob.mwhd.helpers.GetWhichFragment;
import com.lob.mwhd.helpers.Utils;

public class MinimalFragment extends Fragment {

    private GridView gridView;
    private SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.generic_fragment, container, false);
        gridView = (GridView) rootView.findViewById(R.id.grid_view);
        sharedPreferences = Utils.getSharedPreferences(getActivity());
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
        GetWhichFragment.fragment = new MinimalFragment();
        Utils.setupAds(rootView);
        SetupGridView.init(getActivity(), new MinimalFragment(), getActivity().getApplicationContext(), rootView, gridView, sharedPreferences.getInt("col", 2), URLs.MINIMAL_PATH);
        return rootView;
    }
}