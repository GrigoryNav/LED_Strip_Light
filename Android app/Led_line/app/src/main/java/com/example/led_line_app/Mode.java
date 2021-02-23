package com.example.led_line_app;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Mode extends Activity{
    Button button1;
    Button button2;
    Button button3;
    Button connect;
    TextView textView ;
    Integer col=0;
    String signal; // 1234...
    /*
    * 1 - mode
    * 2-button num
    * 3,4 - brightness
    * ... others
     */
    Button brightness1Button;

    SeekBar seekBar;
    String address = "98:D3:61:F9:57:97";
    BluetoothDevice hc06;

    BluetoothConnect bluetoothConnect = new BluetoothConnect(hc06,address);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mode);

    }

    public void button1(View view){
        button1 =(Button) findViewById(R.id.button1);

        //col = SettingsData.getSeekBarCount();
        signal = SettingsData.getAllSignal( "1","1","" );
        TextView textView = findViewById(R.id.textView);

        textView.setText( signal );
        bluetoothConnect.setMessage( signal );
    }

    public void button2(View view){
        button2 =(Button) findViewById(R.id.button2);

        //col = SettingsData.getSeekBarCount();
        signal = SettingsData.getAllSignal( "1","2","" );
        TextView textView = findViewById(R.id.textView);

        textView.setText( signal );
        bluetoothConnect.setMessage( signal );


    }

    public void button3(View view){
        button3 =(Button) findViewById(R.id.button3);

        //col = SettingsData.getSeekBarCount();
        signal = SettingsData.getAllSignal( "1","3","" );
        TextView textView = findViewById(R.id.textView);

        textView.setText( signal );
        bluetoothConnect.setMessage( signal );
    }

    public void connect(View view){

        connect =(Button) findViewById(R.id.connect);
        bluetoothConnect.startConnection();
    }
/*
    public void seekBar(View view){

        saveButton=(Button) findViewById(R.id.saveButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        col = seekBar.getProgress();
    }
*/
}
