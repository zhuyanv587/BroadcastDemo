package com.example.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //发送标准广播按钮的事件监听和处理
        Button btnNormal = findViewById(R.id.btn_normal);
        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
                intent.putExtra("name","标准自定义广播");
                sendBroadcast(intent);
            }
        });

        //发送有序广播按钮的事件监听和处理
        Button btnOrdered = findViewById(R.id.btn_ordered);
        btnOrdered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
                intent.putExtra("name","有序自定义广播");
                sendOrderedBroadcast(intent,null);
            }
        });

    }

    private NetChangeReceiver netChangeReceiver;
    private MyCustomReceiver myCustomReceiver;

    @Override
    protected void onStart() {
        super.onStart();
        //动态注册
        if (netChangeReceiver == null) {
            netChangeReceiver = new NetChangeReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(netChangeReceiver,filter);

        //动态注册自定义广播的接收器
        if (myCustomReceiver == null){
            myCustomReceiver = new MyCustomReceiver();
        }
        filter = new IntentFilter();
        filter.addAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
        filter.addAction("com.example.android.broadcast.MY_NORMAL_BROADCAST");
        filter.setPriority(100);
        registerReceiver(myCustomReceiver,filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消注册
        if (netChangeReceiver != null){
            unregisterReceiver(netChangeReceiver);
        }
        if (myCustomReceiver != null){
            unregisterReceiver(myCustomReceiver);
        }
    }
}
