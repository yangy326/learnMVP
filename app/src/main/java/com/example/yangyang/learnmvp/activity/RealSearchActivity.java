package com.example.yangyang.learnmvp.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.base.base.BaseActivity;
import com.example.base.base.recycler.RecyclerAdapter;
import com.example.base.base.widget.EmptyView;
import com.example.yangyang.learnmvp.R;

import java.util.List;

import butterknife.BindView;
import cm.example.factory.model.db.User;
import cm.example.factory.presenter.account.register.RegisterPresenter;
import cm.example.factory.presenter.search.SearchContract;
import cm.example.factory.presenter.search.SearchPresenter;
import de.hdodenhof.circleimageview.CircleImageView;

public class RealSearchActivity extends BaseActivity implements View.OnClickListener
,SearchContract.View, RecyclerAdapter.AdapterListener<User> {
    private EditText search;

    private TextView txt_search;

    private EmptyView emptyView;

    private RecyclerView recyclerView;

    private int tag;

    private SearchPresenter mPresenter;

    private RecyclerAdapter<User> mAdapter;



    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_real_search;
    }
    protected SearchPresenter initPresenter() {
        return  new SearchPresenter(this);

    }


    @Override
    protected void initWidget() {
        super.initWidget();
        initPresenter();
        txt_search =(TextView) findViewById(R.id.txt_search);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        emptyView = (EmptyView)findViewById(R.id.empty);
        search = (EditText)findViewById(R.id.real_edit_search);
        search.setOnClickListener(this);
        txt_search.setOnClickListener(this);
        tag = getIntent().getExtras().getInt("who");
        if (tag == 1)   search.setHint("手机号");
        else search.setHint("群号群名称");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new RecyclerAdapter<User>() {
            @Override
            protected int getItemViewType(int position, User userCard) {
                // 返回cell的布局id
                return R.layout.cell_search_list;
            }

            @Override
            protected ViewHolder<User> onCreateViewHolder(View root, int viewType) {
                return new RealSearchActivity.ViewHolder(root);
            }
        });
        mAdapter.setListener(this);

        emptyView.bind(recyclerView);
        setPlaceHolderView(emptyView);

    }


    public static void GoRealSearchActivity(Context context, int tag){
        Intent intent = new Intent(context,RealSearchActivity.class );
        Bundle bundle = new Bundle();
        bundle.putInt("who",tag);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.txt_search:
                mPresenter.search(search.getText().toString());





                break;



        }

    }



    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = (SearchPresenter) presenter;

    }

    @Override
    public void searchSusscess(List<User> user) {
        mAdapter.replace(user);
        // 如果有数据，则是OK，没有数据就显示空布局
        mPlaceHolderView.triggerOkOrEmpty(mAdapter.getItemCount() > 0);

    }

    @Override
    public Context getcontext() {
        return this;
    }

    public RealSearchActivity() {

    }

    @Override
    public void onItemClick(RecyclerAdapter.ViewHolder holder, User user) {
        UserInfoActivity.GoUserInfoActivity(this,user.getUserId());
    }

    @Override
    public void onItemLongClick(RecyclerAdapter.ViewHolder holder, User user) {

    }


    class ViewHolder extends RecyclerAdapter.ViewHolder<User>{

        private CircleImageView img ;


        private TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.im_portrait);
            name = (TextView) itemView.findViewById(R.id.txt_name);

        }

        @Override
        protected void onBind(User user) {
            name.setText(user.getUserName());

        }
    }
}
