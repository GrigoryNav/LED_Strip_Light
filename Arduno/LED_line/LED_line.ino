#include "String.h"
// Подключаем библиотеку Adafruit NeoPixel.
#include "Adafruit_NeoPixel.h"
 
// Указываем, какое количество пикселей у нашей ленты.
#define LED_COUNT 540
 
// Указываем, к какому порту подключен вход ленты DIN.
#define LED_PIN 6
 
// Создаем переменную strip для управления нашей лентой.
Adafruit_NeoPixel strip = Adafruit_NeoPixel(LED_COUNT, LED_PIN, NEO_GRB + NEO_KHZ800);
 
void setup()
{
  // Инициализируем ленту.
  
  Serial.begin(9600); 
  pinMode(2,OUTPUT);

  
}
 
void loop()
{
  
  if( Serial.available()>0 ){
    
    strip.begin();
    int Incoming_value= Serial.parseInt(); 
    /*
     * Incoming_value = 1234...
     * 1-menu item
     * 2-selected button
     * 3,4-brightness
     * ... others
    */
    
    switch( define_left_num(Incoming_value) ){
      case 1:{
        //Serial.print( "loop() case1 Incoming_value = " );
        //Serial.println(Incoming_value);
        
        mode(delete_left_num(Incoming_value));
        break;
      }
      case 2:{
        //Serial.print( "loop() case1 Incoming_value = " );
        //Serial.println(Incoming_value);
        
        mode_2(delete_left_num(Incoming_value));
        break;
      }
    }
      
  }
  
  
}




void mode(int Incoming_value_mode){
  /*
     * Incoming_value_mode = 234...
     * 2-selected button
     * 3,4-brightness
     * ... others
    */
    switch( define_left_num(Incoming_value_mode) ){
      case 1:{
        //Serial.print( "mode() case1 Incoming_value_mode = " );
        //Serial.println(Incoming_value_mode);
        blink_1(delete_left_num(Incoming_value_mode) );  
        break;
      }
      case 2:{
        //Serial.print( "mode() case2 Incoming_value_mode = " );
        //Serial.println(Incoming_value_mode);
        //blink_2(delete_left_num(Incoming_value_mode) );  
        blink_2( delete_left_num(Incoming_value_mode) );
        break;
      }
      case 3:{
        //Serial.print( "mode() case3 Incoming_value_mode = " );
        //Serial.println(Incoming_value_mode);
        
        blink_3( delete_left_num(Incoming_value_mode) );  
        break;
      }
    }
  
}
void mode_2(int Incoming_value_mode){
  /*
     * Incoming_value_mode = 234...
     * 2-selected button
     * 3,4-brightness
     * ... others
    */
    switch( define_left_num(Incoming_value_mode) ){
      case 1:{
        //Serial.print( "mode() case1 Incoming_value_mode = " );
        //Serial.println(Incoming_value_mode);
        mode_2_blink_1(delete_left_num(Incoming_value_mode) );  
        break;
      }
      
    }
  
}

int define_left_num(int x){
  int n = check_size(x);
  for(int i=0;i<(n-1);i++)
    x /= 10 ;
  return x;  
}

int delete_left_num(int x){
  int x_cpy = x;
  int n = check_size(x);

  for(int i=0;i<(n-1);i++)
    x_cpy /=10;
  for(int i=0;i<(n-1);i++)
    x_cpy *=10;
  
  
  return (x-x_cpy);
}

int check_size(int x){
  int i=0;
  while(x>0){
    x/=10;
    i++;
  }
  return i;
}

void blink_1(int brightness)  
{
  /*пример
   * brightness = 99
   * col_br = 2.55
   * brightness *= col_br получим значение яркости 99*2.55 = 252
  */
  strip.begin();
  int n =100; 
  double col_br = 255/n;
  brightness *= col_br;

  //Serial.println( "blink_1()" );
  
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(brightness, 0, 0));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(brightness,0,brightness)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}

void blink_2(int brightness)  
{
  //Serial.print( "blink_2()" );
  strip.begin();
  int n =100; 
  double col_br = 255/n;
  brightness *= col_br;

  //Serial.println( brightness );
  
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(brightness, 0, brightness));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(brightness,0,0)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}

void blink_3(int brightness)  
{
  //Serial.println( "blink_3()" );
  strip.begin();
  int n =100; 
  double col_br = 255/n;
  brightness *= col_br;

  
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(brightness, 0, 0));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(0,0,brightness)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}

void mode_2_blink_1(int brightness)  
{
  //Serial.println( "blink_3()" );
  strip.begin();
  int n =100; 
  double col_br = 255/n;
  brightness *= col_br;

    for (int i = 0; i <= LED_COUNT; i++)
    {
      strip.setPixelColor(i, (i%2==0)?strip.Color(brightness, brightness, brightness):strip.Color(0,0, brightness) );  
      // Передаем цвета ленте.
      strip.show();
      delay(10);
    }
    for (int i = 0; i <= LED_COUNT; i++)
    {
      strip.setPixelColor(i, (i%2==0)?strip.Color(0,0, brightness):strip.Color(brightness, brightness, brightness) );  
      // Передаем цвета ленте.
      strip.show();
      delay(10);
    }

}
