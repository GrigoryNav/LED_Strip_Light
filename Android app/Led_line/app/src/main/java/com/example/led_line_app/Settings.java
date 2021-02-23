package com.example.led_line_app;

import android.app.Activity;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.content.Intent;
public class Settings extends Activity {
    Button saveButton;
    SeekBar seekBar;
    String address = "98:D3:61:F9:57:97";
    BluetoothDevice hc06;
    BluetoothConnect bluetoothConnect = new BluetoothConnect(hc06,address);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.settings);

    }

    public void brightness(View view){

        saveButton=(Button) findViewById(R.id.saveButton);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        int col = seekBar.getProgress();
        SettingsData.setSeekBarCount(col);

        Intent intent = new Intent(Settings.this, MainActivity.class);
        startActivity(intent);

    }

}
