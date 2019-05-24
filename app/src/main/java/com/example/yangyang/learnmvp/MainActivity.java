package com.example.yangyang.learnmvp;

import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.yangyang.learnmvp.fragment.main.EyeFragment;
import com.example.yangyang.learnmvp.fragment.main.MessageFragment;
import com.example.yangyang.learnmvp.fragment.main.ContactFragment;
import com.example.yangyang.learnmvp.fragment.main.FireFragment;
import com.example.yangyang.learnmvp.helper.NavHepler;

public class MainActivity extends BaseActivity implements NavHepler.OnTabChangedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView title;

    private FrameLayout container;

    private NavHepler<String> hepler;

    private TextView currentTopView;

    private BottomNavigationView mNavigation;


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        hepler = new NavHepler<String>(this,R.id.main_layout_container,getSupportFragmentManager(),this);
        hepler.add(R.id.action_message,new NavHepler.Tab<String>(MessageFragment.class,"消息"))
                .add(R.id.action_contact,new NavHepler.Tab<String>(EyeFragment.class,"联系人"))
                .add(R.id.action_eye,new NavHepler.Tab<String>(ContactFragment.class,"看点"))
                .add(R.id.action_fire,new NavHepler.Tab<String>(FireFragment.class,"动态"));

        title = (TextView)findViewById(R.id.title);
        container = (FrameLayout) findViewById(R.id.main_layout_container);
        mNavigation = (BottomNavigationView)findViewById(R.id.navigation);

        mNavigation.setOnNavigationItemSelectedListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        Menu menu = mNavigation.getMenu();
        // 触发首次选中Home
       menu.performIdentifierAction(menu.getItem(0).getItemId(),0);
    }




    @Override
    public void onTabChanged(NavHepler.Tab newTab, NavHepler.Tab oldTab) {



    title.setText(newTab.extra.toString());

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return hepler.performClickMenu(menuItem.getItemId());
    }
}

