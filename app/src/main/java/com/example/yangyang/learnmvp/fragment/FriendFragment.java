package com.example.yangyang.learnmvp.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends BaseFragment {


    public FriendFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_friend;
    }

}
