package com.example.led_line_app;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.*;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Switch;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    Button modButton;
    String address = "98:D3:61:F9:57:97";
    //BluetoothDevice hc06;
    //BluetoothConnect bluetoothConnect = new BluetoothConnect( hc06, address );

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bluetoothConnect.startConnection();

    }
    public void modButton (View view){
        Intent intent = new Intent(MainActivity.this, Mode.class);
        startActivity(intent);
    }
    public void settingsButton (View view){
        Intent intent = new Intent(MainActivity.this, Settings.class);
        startActivity(intent);
    }
}
