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
public class BluetoothConnect {

    BluetoothDevice bluetoothDevice;    //hc-06
    BluetoothAdapter btAdapter;          //BluetoothAdapter.getDefaultAdapter();
    BluetoothSocket btSocket;
    OutputStream outputStream;
    String address;
    public BluetoothConnect(   ){}
    public BluetoothConnect( BluetoothDevice btDevice,String address1  ){ //"98:D3:61:F9:57:97" hc-06 address
        address=address1;
        bluetoothDevice=btDevice;
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothDevice = btAdapter.getRemoteDevice(address);

    }

    public void startConnection(  ) {
        if (bluetoothDevice != null) {
            try {
                Method method = bluetoothDevice.getClass().getMethod("createRfcommSocket", new Class[]{int.class});
                btSocket = (BluetoothSocket) method.invoke(bluetoothDevice, 1);
                btSocket.connect();

                outputStream = btSocket.getOutputStream();


            } catch (Exception e) {

                e.printStackTrace();
            }

        }
    }

    public void setMessage(String command) {
        byte[] buffer = command.getBytes();
        if( (btAdapter!=null)&&( btAdapter.isEnabled() ) ) {
            if (outputStream != null) {
                try {
                    outputStream.write(buffer);
                    outputStream.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
