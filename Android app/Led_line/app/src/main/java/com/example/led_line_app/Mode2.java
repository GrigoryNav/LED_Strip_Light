package com.example.led_line_app;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mode2 extends Activity{
    Button button1;
    Button connect;
    String signal; // 1234...
    /*
     * 1 - mode
     * 2-button num
     * 3,4 - brightness
     * ... others
     */

    String address = "98:D3:61:F9:57:97";
    BluetoothDevice hc06;
    BluetoothConnect bluetoothConnect = new BluetoothConnect(hc06,address);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mode2);

    }

    public void button1(View view){
        button1 =(Button) findViewById(R.id.mode2Button1);

        signal = SettingsData.getAllSignal( "2","1","" );

        bluetoothConnect.setMessage( signal );
    }

    public void connect(View view){

        connect =(Button) findViewById(R.id.mode2Connect);
        bluetoothConnect.startConnection();
    }

}
