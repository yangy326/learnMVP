package com.example.yangyang.learnmvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.igexin.sdk.PushConsts;

public class MessageReceiver extends BroadcastReceiver {

    private String TAG = "asdsadasd";
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null)
            return;

        Bundle bundle = intent.getExtras();

        // 判断当前消息的意图
        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_CLIENTID: {
                Log.i(TAG, bundle.getString("clientid"));
                // 当Id初始化的时候
                // 获取设备Id
                onClientInit(bundle.getString("clientid"));
                break;
            }
            case PushConsts.GET_MSG_DATA: {
                // 常规消息送达
                byte[] payload = bundle.getByteArray("payload");
                if (payload != null) {
                    String message = new String(payload);
                    Log.i(TAG, "GET_MSG_DATA:" + message);
                    onMessageArrived(message);
                }
                break;
            }
            default:

                break;
        }

    }

    private void onClientInit(String cid) {
        // 设置设备Id
        //Account.setPushId(cid);
        //
    }

    /**
     * 消息达到时
     *
     * @param message 新消息
     */
    private void onMessageArrived(String message) {
        // 交给Factory处理
        //Factory.dispatchPush(message);
    }
}
