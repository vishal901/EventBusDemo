package com.example.eventbusdemo;

/**
 * Created by vishal on 20/5/16.
 */
public class ChargingEvent {

    private String data;

    public ChargingEvent(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}
