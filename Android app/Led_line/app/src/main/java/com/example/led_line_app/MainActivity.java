package com.example.led_line_app;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.*;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //Button button1;
    //Button button11;
    //Switch switch1;
    Button button1;
    Button button2;
    Button button3;
    String address = "98:D3:61:F9:57:97";
    OutputStream outputStream ;
    BluetoothAdapter btAdapter;
    BluetoothDevice hc06;
    BluetoothSocket btSocket;
    BluetoothConnect bluetoothConnect = new BluetoothConnect( hc06, address );
    //boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //btAdapter = BluetoothAdapter.getDefaultAdapter();

        //btAdapter = BluetoothAdapter.getDefaultAdapter();
        //hc06 = btAdapter.getRemoteDevice("98:D3:61:F9:57:97");

        bluetoothConnect.startConnection();
    }

    public void button1(View view){
        button1 =(Button) findViewById(R.id.button1);
        //btAdapter.getName();

        bluetoothConnect.setMessage("1");

    }
    public void button2(View view){
        button2 =(Button) findViewById(R.id.button2);
        //btAdapter.getName();

        bluetoothConnect.setMessage("2");

    }
    public void button3(View view){
        button3 =(Button) findViewById(R.id.button3);
        //btAdapter.getName();

        bluetoothConnect.setMessage("3");

    }

}
