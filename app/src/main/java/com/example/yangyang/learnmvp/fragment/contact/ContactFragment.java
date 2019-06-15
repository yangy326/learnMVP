package com.example.yangyang.learnmvp.fragment.contact;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.base.base.BaseFragment;
import com.example.base.base.recycler.RecyclerAdapter;
import com.example.base.base.widget.EmptyView;
import com.example.base.callback.ShowCallback;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.activity.MessageActivity;
import com.example.yangyang.learnmvp.activity.RealSearchActivity;

import java.util.List;

import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;
import cm.example.factory.presenter.search.SearchPresenter;
import cm.example.factory.presenter.showfriend.ShowContract;
import cm.example.factory.presenter.showfriend.ShowPresenter;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends BaseFragment implements ShowContract.View,RecyclerAdapter.AdapterListener<UserCard> {
    private EmptyView emptyView;

    private RecyclerView recyclerView;

    private Context mContext;

    private int tag;

    private ShowPresenter mPresenter;

    private RecyclerAdapter<UserCard> mAdapter;


    protected ShowPresenter initPresenter() {
        return  new ShowPresenter(this);

    }    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        initPresenter();
        mContext = root.getContext();

        recyclerView = (RecyclerView)root.findViewById(R.id.recyclerView);
        emptyView = (EmptyView)root.findViewById(R.id.empty);

        recyclerView.setLayoutManager(new LinearLayoutManager(root.getContext()));
        recyclerView.setAdapter(mAdapter = new RecyclerAdapter<UserCard>() {
            @Override
            protected int getItemViewType(int position, UserCard userCard) {
                // 返回cell的布局id
                return R.layout.cell_search_list;
            }

            @Override
            protected ViewHolder<UserCard> onCreateViewHolder(View root, int viewType) {
                return new ContactFragment.ViewHolder(root);
            }
        });
        mAdapter.setListener(this);

        emptyView.bind(recyclerView);
        setPlaceHolderView(emptyView);

    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.searchFriend(Common.getUserId(mContext));
    }




    @Override
    public void showFriendSusscess(List<UserCard> card) {
        mAdapter.replace(card);
        // 如果有数据，则是OK，没有数据就显示空布局
        mPlaceHolderView.triggerOkOrEmpty(mAdapter.getItemCount() > 0);

    }

    @Override
    public void showGroupSusscess(UserCard card) {

    }

    @Override
    public Context getcontext() {
        return mRoot.getContext();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void setPresenter(ShowContract.Presenter presenter) {
        mPresenter =(ShowPresenter) presenter;

    }



    @Override
    public void onItemClick(RecyclerAdapter.ViewHolder holder, UserCard card) {
        MessageActivity.GotoMessageActivity(mContext,card,true);

    }

    @Override
    public void onItemLongClick(RecyclerAdapter.ViewHolder holder, UserCard card) {

    }

    class ViewHolder extends RecyclerAdapter.ViewHolder<UserCard>{

        private CircleImageView img ;


        private TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            img = (CircleImageView)itemView.findViewById(R.id.im_portrait);
            name = (TextView) itemView.findViewById(R.id.txt_name);

        }

        @Override
        protected void onBind(UserCard user) {
            name.setText(user.getUserName());

        }
    }


}
