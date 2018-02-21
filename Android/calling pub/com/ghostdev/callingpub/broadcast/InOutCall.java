package com.ghostdev.callingpub.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.ghostdev.callingpub.services.PubService;

public class InOutCall extends BroadcastReceiver {

   public static final String PREFERENCE_FILENAME = "pub_pref";
   Context context;
   Intent mIntent;


   public void onReceive(Context var1, Intent var2) {
      this.context = var1;

      try {
         ((TelephonyManager)var1.getSystemService("phone")).listen(new InOutCall.MyPhoneStateListener((InOutCall.MyPhoneStateListener)null), 32);
      } catch (Exception var4) {
         Log.e("Phone Receive Error", " " + var4);
      }
   }

   private class MyPhoneStateListener extends PhoneStateListener {

      private MyPhoneStateListener() {}

      // $FF: synthetic method
      MyPhoneStateListener(InOutCall.MyPhoneStateListener var2) {
         this();
      }

      public void onCallStateChanged(int var1, String var2) {
         InOutCall.this.mIntent = new Intent(InOutCall.this.context, PubService.class);
         Log.d("MyPhoneListener", var1 + "   incoming no:" + var2);
         if(var1 == 2) {
            InOutCall.this.context.startService(InOutCall.this.mIntent);
         }

         if(var1 == 1) {
            InOutCall.this.context.startService(InOutCall.this.mIntent);
         }

         if(var1 == 0) {
            if(!InOutCall.this.context.getSharedPreferences("pub_pref", 0).getString("url", "null").equals("null")) {
               Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse("http://www.google.com"));
               var4.setFlags(268435456);
               InOutCall.this.context.startActivity(var4);
            }

            InOutCall.this.context.stopService(InOutCall.this.mIntent);
         }

      }
   }
}
