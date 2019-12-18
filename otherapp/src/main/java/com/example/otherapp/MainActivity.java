package com.example.otherapp;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private TwoReceiver twoReceiver;
    @Override
    protected void onStart() {
        super.onStart();
        //动态注册自定义广播的接收器
        if (twoReceiver == null){
            twoReceiver = new TwoReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
        filter.addAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
        filter.setPriority(50);
        registerReceiver(twoReceiver,filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (twoReceiver != null){
            unregisterReceiver(twoReceiver);
        }
    }

}
