package com.example.base.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.base.base.widget.convention.PlaceHolderView;

public abstract class BaseFragment extends Fragment {

    protected View mRoot;
    protected PlaceHolderView mPlaceHolderView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());

    }

    /**
     * 设置占位布局
     *
     * @param placeHolderView 继承了占位布局规范的View
     */
    public void setPlaceHolderView(PlaceHolderView placeHolderView) {
        this.mPlaceHolderView = placeHolderView;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null){
            int layoutId = getContentLayoutId();
            View root =inflater.inflate(layoutId,container,false);
            initWidget(root);
            mRoot = root ;
        }
        else {
            //有可能Fragment被回收了，但是mRoot没有被回收
            if (mRoot.getParent() != null){
                ((ViewGroup)(mRoot.getParent())).removeView(mRoot);
            }
        }






        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract int getContentLayoutId();

    protected void initWidget(View root){

    }

    protected void initData(){

    }

    protected void initArgs(Bundle bundle){  // Bundle传值拿参数时可以复写这个函数

    }

    public boolean onBackPressed(){
        return  false;  //返回true代表我处理返回了，Activity不用自己finish
    }
}
