package com.example.yangyang.learnmvp.fragment.search;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.base.base.BaseFragment;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.activity.RealSearchActivity;
import com.example.yangyang.learnmvp.fragment.user.UserTrigger;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddPersonFragment extends BaseFragment implements View.OnClickListener {
    private UserTrigger userTrigger;

    private LinearLayout search_layout;





    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_add_person;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        userTrigger = (UserTrigger) context;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);

        search_layout = root.findViewById(R.id.search_layout);

        search_layout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_layout:
                RealSearchActivity.GoRealSearchActivity(v.getContext(),1);
                break;

        }
    }
}
