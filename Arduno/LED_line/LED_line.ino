char Incoming_value = 0;
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
    Incoming_value=Serial.read();
    
      if( Incoming_value == '1' ){
        digitalWrite(2,HIGH);
        blink_1();
      }
      if( Incoming_value == '2' ){
        digitalWrite(2,LOW);
        blink_2();
      }
      if( Incoming_value == '3' ){
        blink_3();
      }
  }
  
}


void blink_1()  
{
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(200, 0, 0));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(0, 200, 0)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}

void blink_2()  
{
  
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(100, 100, 0));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(100, 0, 100)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}

void blink_3()  
{
  
  for (int i = 0; i <= LED_COUNT; i++)
  {
    strip.setPixelColor(i, strip.Color(0, 0, 200));  
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  // Выключаем все светодиоды.
  for (int i = LED_COUNT; i >= 0; i--)
  {
    strip.setPixelColor(i, strip.Color(100, 100, 0)); // Черный цвет, т.е. выключено.
    // Передаем цвета ленте.
    strip.show();
    delay(25);
  }
  
}
