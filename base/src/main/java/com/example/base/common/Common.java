package com.example.base.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Common {

    public static void decodeFailedCode(Context context ,int code){
        switch (code){
            case 100 :
                Toast.makeText(context, "数据不能为空", Toast.LENGTH_SHORT).show();
                break;
            case 101:
                Toast.makeText(context, "手机号码格式不对", Toast.LENGTH_SHORT).show();
                break;
            case 102:
                Toast.makeText(context, "密码必须大于6位", Toast.LENGTH_SHORT).show();
                break;


        }
    }

    public static String getPushId(Context context ){
        SharedPreferences sharedPreferences = context.getSharedPreferences("GET_ID",MODE_PRIVATE);
        return sharedPreferences.getString("pushId",null);


    }
    public static String getToken(Context context ){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token",MODE_PRIVATE);
        return sharedPreferences.getString("token",null);


    }
    public static int getUserId(Context context ){
        SharedPreferences sharedPreferences = context.getSharedPreferences("Token",MODE_PRIVATE);
        return sharedPreferences.getInt("userId",0);


    }


}
