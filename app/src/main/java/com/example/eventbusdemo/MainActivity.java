package com.example.eventbusdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private EventBus bus = EventBus.getDefault();

    private TextView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        view = new TextView(this);

        view.setTextSize(20f);
        view.setPadding(20, 20, 20, 20);
        view.setText("Waiting for events...");

        setContentView(view);

        // Register as a subscriber
        bus.register(this);

        Intent serviceIntent = new Intent(this, ChargingReceiver.class);
        startService(serviceIntent);
    }

    @Override
    protected void onDestroy() {
        // Unregister
        bus.unregister(this);
        super.onDestroy();
    }


    @Subscribe
    public void onEvent(ChargingEvent event){
        view.setText(view.getText() + "\n" + event.getData());
    }
}
