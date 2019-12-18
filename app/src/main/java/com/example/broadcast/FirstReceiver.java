package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//广播接收器，接收系统广播
public class FirstReceiver extends BroadcastReceiver {

    //接收到广播之后的处理有一点
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"开机启动完成",Toast.LENGTH_LONG).show();
    }
}
