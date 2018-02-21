package com.ghostdev.callingpub.services;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

public class PubService extends Service {

   public static final String PREFERENCE_FILENAME = "pub_pref";
   private Button chatHead;
   private Button secondHead;
   private WindowManager windowManager;


   public IBinder onBind(Intent var1) {
      return null;
   }

   public void onCreate() {
      super.onCreate();
      this.windowManager = (WindowManager)this.getSystemService("window");
      this.chatHead = new Button(this);
      this.chatHead.setEnabled(true);
      this.chatHead.setClickable(true);
      this.secondHead = new Button(this);
      SharedPreferences var1 = this.getSharedPreferences("pub_pref", 0);
      this.secondHead.setBackgroundResource(var1.getInt("rect", 2130837512));
      this.chatHead.setBackgroundResource(var1.getInt("circ", 2130837504));
      final LayoutParams var2 = new LayoutParams(-2, -2, 2002, 8, -3);
      var2.windowAnimations = 16973827;
      var2.gravity = 51;
      var2.x = 165;
      var2.y = 160;
      this.windowManager.addView(this.secondHead, var2);
      final LayoutParams var3 = new LayoutParams(-2, -2, 2002, 8, -3);
      var3.windowAnimations = 16973910;
      var3.gravity = 51;
      var3.x = 5;
      var3.y = 150;
      this.windowManager.addView(this.chatHead, var3);
      this.chatHead.setClickable(true);
      this.chatHead.setOnTouchListener(new OnTouchListener() {

         private float initialTouchX;
         private float initialTouchY;
         private int initialX;
         private int initialY;

         public boolean onTouch(View var1, MotionEvent var2x) {
            boolean var3x = true;
            switch(var2x.getAction()) {
            case 0:
               this.initialX = var3.x;
               this.initialY = var3.y;
               this.initialTouchX = var2x.getRawX();
               this.initialTouchY = var2x.getRawY();
               return var3x;
            case 1:
               if(var3.y < 80) {
                  PubService.this.stopService(new Intent(PubService.this.getApplicationContext(), PubService.class));
                  Editor var8 = PubService.this.getSharedPreferences("pub_pref", 0).edit();
                  var8.putString("url", "http://www.google.com");
                  var8.commit();
                  PubService.this.stopSelf();
               }

               if(var3.y > -220 + PubService.this.windowManager.getDefaultDisplay().getHeight()) {
                  Editor var4 = PubService.this.getSharedPreferences("pub_pref", 0).edit();
                  var4.putString("url", "null");
                  var4.commit();
                  PubService.this.stopSelf();
                  return var3x;
               }
               break;
            case 2:
               if(var3.y > 20 && var3.y < -220 + PubService.this.windowManager.getDefaultDisplay().getHeight()) {
                  var2.y = 10 + this.initialY + (int)(var2x.getRawY() - this.initialTouchY);
                  var3.y = this.initialY + (int)(var2x.getRawY() - this.initialTouchY);
               }

               PubService.this.windowManager.updateViewLayout(PubService.this.chatHead, var3);
               PubService.this.windowManager.updateViewLayout(PubService.this.secondHead, var2);
               return var3x;
            default:
               var3x = false;
            }

            return var3x;
         }
      });
   }

   public void onDestroy() {
      super.onDestroy();
      if(this.chatHead != null) {
         this.windowManager.removeView(this.chatHead);
      }

      if(this.secondHead != null) {
         this.windowManager.removeView(this.secondHead);
      }

   }
}
