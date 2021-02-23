package com.example.led_line_app;

public class SettingsData {

    private static int seekBarCount=0;

    public static void setSeekBarCount(Integer seekBarCount1){
        seekBarCount = seekBarCount1;
    }

    public static void setSeekBarCount(int seekBarCount1){
        seekBarCount = seekBarCount1;
    }

    public static void setSeekBarCount(String seekBarCount1){
        seekBarCount = Integer.parseInt(seekBarCount1);
    }

    public static Integer getSeekBarCount(){return seekBarCount;}

    public static String getAllSignal(String menuItem,String selectedButton,String others ) {
        return (seekBarCount>9)?(menuItem + selectedButton + Integer.toString(seekBarCount) + others )
                :
                (menuItem + selectedButton +"0"+ Integer.toString(seekBarCount) + others ) ;
    }

}
