package com.example.yangyang.learnmvp.fragment.main;


import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.TabLayout;
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
public class FriendFragment extends BaseFragment  {




    private ViewPager viewPager;
    private TabLayout tabLayout;







    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_friend;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        viewPager = (ViewPager)root.findViewById(R.id.viewpager);
        tabLayout = (TabLayout)root.findViewById(R.id.tablayout);

    }

    @Override
    protected void initData() {
        super.initData();
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new com.example.yangyang.learnmvp.fragment.contact.ContactFragment());
        fragments.add(new GroupFragment());

        //tabLayout.setupWithViewPager(viewPager,false);


        MyAdater adater= new MyAdater(getChildFragmentManager(),fragments);
        viewPager.setAdapter(adater);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.setupWithViewPager(viewPager,false);
        tabLayout.getTabAt(0).setText("好友");
        tabLayout.getTabAt(1).setText("群聊");

    }

}
