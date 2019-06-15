package com.example.yangyang.learnmvp.fragment.main;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.fragment.MyAdater;
import com.example.yangyang.learnmvp.fragment.contact.GroupFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EyeFragment extends BaseFragment {
    private ViewPager viewPager;





    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

    }


}
