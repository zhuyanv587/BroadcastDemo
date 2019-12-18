package com.example.otherapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TwoReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getStringExtra("name");
        Toast.makeText(context,"OtherApp的TwoReceiver接收到：" + name,Toast.LENGTH_LONG).show();
    }
}
