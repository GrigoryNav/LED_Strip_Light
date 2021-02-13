package com.example.led_line_app;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mode extends Activity{
    Button button1;
    Button button2;
    Button button3;
    Button connect;
    String address = "98:D3:61:F9:57:97";
    BluetoothDevice hc06;
    BluetoothConnect bluetoothConnect = new BluetoothConnect(hc06,address);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mode);
        bluetoothConnect.startConnection();
    }

    public void button1(View view){
        button1 =(Button) findViewById(R.id.button1);
        bluetoothConnect.setMessage("1");
    }
    public void button2(View view){
        button2 =(Button) findViewById(R.id.button2);
        bluetoothConnect.setMessage("2");
    }

    public void button3(View view){
        button3 =(Button) findViewById(R.id.button3);
        bluetoothConnect.setMessage("3");
    }

    public void connect(View view){

        connect =(Button) findViewById(R.id.connect);
        bluetoothConnect.startConnection();
    }
}
