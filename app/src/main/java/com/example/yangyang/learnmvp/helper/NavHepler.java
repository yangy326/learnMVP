package com.example.yangyang.learnmvp.helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;

import com.example.base.base.BaseFragment;

public class NavHepler<T> {

    private final SparseArray<Tab<T>> tabs = new SparseArray<>();
    private final Context context;
    private final int containerId;
    private final FragmentManager fragmentManager;
    private final OnTabChangedListener<T> listener;

    public NavHepler(Context context, int containerId, FragmentManager fragmentManager, OnTabChangedListener<T> listener) {
        this.context = context;
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
        this.listener = listener;
    }

    // 当前的一个选中的Tab
    private Tab<T> currentTab;

    public NavHepler<T> add(int menuId, Tab<T> tab) {
        tabs.put(menuId, tab);
        return this;
    }

    /**
     * 获取当前的显示的Tab
     *
     * @return 当前的Tab
     */
    public Tab<T> getCurrentTab() {
        return currentTab;
    }

    public boolean performClickMenu(int menuId) {
        // 集合中寻找点击的菜单对应的Tab，
        // 如果有则进行处理
        Tab<T> tab = tabs.get(menuId);
        if (tab != null) {
            doSelect(tab);
            return true;
        }

        return false;
    }

    /**
     * 进行真实的Tab选择操作
     *
     * @param tab Tab
     */
    private void doSelect(Tab<T> tab) {
        Tab<T> oldTab = null;

        if (currentTab != null) {
            oldTab = currentTab;
            if (oldTab == tab) {
                // 如果说当前的Tab就是点击的Tab，
                // 那么我们不做处理
                notifyTabReselect(tab);
                return;
            }
        }
        // 赋值并调用切换方法
        currentTab = tab;
        doTabChanged(currentTab, oldTab);

    }

    /**
     * 进行Fragment的真实的调度操作
     * @param newTab 新的
     * @param oldTab 旧的
     */
    private void doTabChanged(Tab<T> newTab, Tab<T> oldTab) {
        FragmentTransaction ft = fragmentManager.beginTransaction();

        if (oldTab != null) {
            if (oldTab.fragment != null) {
                // 从界面移除，但是还在Fragment的缓存空间中
                ft.detach(oldTab.fragment);
            }
        }

        if (newTab != null) {
            if (newTab.fragment == null) {
                // 首次新建
                Fragment fragment = Fragment.instantiate(context, newTab.clx.getName(), null);
                // 缓存起来
                newTab.fragment = fragment;
                // 提交到FragmentManger
                ft.add(containerId, fragment, newTab.clx.getName());
            } else {
                // 从FragmentManger的缓存空间中重新加载到界面中
                ft.attach(newTab.fragment);
            }
        }
        // 提交事务
        ft.commit();
        // 通知回调
        notifyTabSelect(newTab, oldTab);
    }

    /**
     * 回调我们的监听器
     *
     * @param newTab 新的Tab<T>
     * @param oldTab 旧的Tab<T>
     */
    private void notifyTabSelect(Tab<T> newTab, Tab<T> oldTab) {
        if (listener != null) {
            listener.onTabChanged(newTab, oldTab);
        }
    }

    private void notifyTabReselect(Tab<T> tab) {
        // TODO 二次点击Tab所做的操作
    }


    public static class Tab<T>{
        public Tab(Class<?> clx, T extra) {
            this.clx = clx;
            this.extra = extra;
        }

        // Fragment对应的Class信息
        public Class<?> clx;
        // 额外的字段，用户自己设定需要使用
        public T extra;

        // 内部缓存的对应的Fragment，
        // Package权限，外部无法使用
        Fragment fragment;


    }

    public interface OnTabChangedListener<T> {
        void onTabChanged(Tab<T> newTab, Tab<T> oldTab);
    }
}
