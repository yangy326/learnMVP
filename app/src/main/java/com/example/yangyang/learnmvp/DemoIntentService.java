package com.example.yangyang.learnmvp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.yangyang.learnmvp.fragment.message.ChatUserFragment;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;

public class DemoIntentService extends GTIntentService {

    public DemoIntentService() {

    }

    @Override
    public void onReceiveServicePid(Context context, int pid) {
        //Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
    }

    @Override
    public void onReceiveMessageData(Context context, GTTransmitMessage msg) {
       // Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
        byte[] payload = msg.getPayload();
        if (payload != null) {
            String message = new String(payload);
            ChatUserFragment.

        }
        // 透传消息的处理，详看SDK demo
    }

    @Override
    public void onReceiveClientId(Context context, String clientid) {
        Log.e(TAG, "onReceiveClientId -> " + "clientid = " + clientid);
        SharedPreferences.Editor editor= context.getSharedPreferences("GET_ID",MODE_PRIVATE).edit();

        editor.putString("pushId",clientid);

        editor.apply();
    }

    @Override
    public void onReceiveOnlineState(Context context, boolean online) {
       // Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
    }

    @Override
    public void onReceiveCommandResult(Context context, GTCmdMessage cmdMessage) {
       // Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
    }

    @Override
    public void onNotificationMessageArrived(Context context, GTNotificationMessage msg) {
     //   Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
    }

    @Override
    public void onNotificationMessageClicked(Context context, GTNotificationMessage msg) {
       // Log.i(TAG, "GET_MSG_DATA:" + "sdaf");
    }
}