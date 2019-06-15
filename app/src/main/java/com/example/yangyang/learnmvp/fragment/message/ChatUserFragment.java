package com.example.yangyang.learnmvp.fragment.message;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.base.base.BaseFragment;
import com.example.base.base.recycler.RecyclerAdapter;
import com.example.base.base.widget.EmptyView;
import com.example.base.common.Common;
import com.example.yangyang.learnmvp.R;
import com.example.yangyang.learnmvp.activity.RealSearchActivity;

import java.util.Objects;

import cm.example.factory.model.db.Message;
import cm.example.factory.model.db.User;
import cm.example.factory.model.user.UserCard;
import de.hdodenhof.circleimageview.CircleImageView;


public class ChatUserFragment extends BaseFragment {
    private UserCard target;

    private static Context mContext;

    private EmptyView emptyView;

    private RecyclerView recyclerView;

    private Adapter mAdapter;





    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_chat_user;
    }

    private class Adapter extends RecyclerAdapter<Message> {

        @Override
        protected int getItemViewType(int position, Message message) {
            // 我发送的在右边，收到的在左边
            boolean isRight = Objects.equals(message.getSender().getUserId(), Common.getUserId(mContext) );
            if (isRight) return  R.layout.cell_layout_text_right;
            else return R.layout.cell_layout_text_left;



        }

        @Override
        protected ViewHolder<Message> onCreateViewHolder(View root, int viewType) {
            return new TextHolder(root);
        }

    }

    @Override
    protected void initArgs(Bundle bundle) {
        super.initArgs(bundle);
        target = (UserCard) bundle.getSerializable("target");
    }

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mContext = root.getContext();
        recyclerView = (RecyclerView)root.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(mAdapter = new Adapter());

    }

    class BaseHolder extends RecyclerAdapter.ViewHolder<Message> {

        CircleImageView mPortrait;

        ProgressBar mLoading;


        public BaseHolder(View itemView) {
            super(itemView);
            mPortrait = (CircleImageView)itemView.findViewById(R.id.im_portrait);
            mLoading = (ProgressBar) itemView.findViewById(R.id.loading);

        }

        @Override
        protected void onBind(Message message) {
            //User sender = message.getSender();
            // 进行数据加载
            //sender.load();
            // 头像加载
            //

            if (mLoading != null) {
                // 当前布局应该是在右边
                int status = message.getStatus();
                if (status == Message.STATUS_DONE) {
                    // 正常状态, 隐藏Loading

                    mLoading.setVisibility(View.GONE);
                } else if (status == Message.STATUS_CREATED) {
                    // 正在发送中的状态
                    mLoading.setVisibility(View.VISIBLE);
                    mLoading.setProgress(0);

                } else if (status == Message.STATUS_FAILED) {
                    // 发送失败状态, 允许重新发送
                    mLoading.setVisibility(View.VISIBLE);

                    mLoading.setProgress(1);

                }

                // 当状态是错误状态时才允许点击
                mPortrait.setEnabled(status == Message.STATUS_FAILED);
            }
        }



    }
    class TextHolder extends BaseHolder {

        TextView mContent;

        public TextHolder(View itemView) {
            super(itemView);
            mContent = (TextView)itemView.findViewById(R.id.txt_content);
        }

        @Override
        protected void onBind(Message message) {
            super.onBind(message);


            // 把内容设置到布局上
            mContent.setText(message.getContent());
        }
    }
    public  void dispatch(final Message message){
        ((Activity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mAdapter.add(message);
            }
        });


    }


}
