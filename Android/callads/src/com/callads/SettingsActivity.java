package com.callads;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.callads.services.AddsService;


public class SettingsActivity extends Activity {

   public static final String PREFERENCE_FILENAME = "pub_pref";
   Button change;
   int value;


   protected void onCreate(Bundle var1) {
	  
      super.onCreate(var1);
     
      this.setContentView(R.layout.activity_main);
      
      this.value = this.getSharedPreferences("pub_pref", 0).getInt("value", 1);
      
      this.startService(new Intent(this, AddsService.class));
      
      this.change = (Button)this.findViewById(R.id.btn_change);
      
      this.change.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            SettingsActivity var2 = SettingsActivity.this;
            //++var2.value;
            //if(SettingsActivity.this.value > 7) {
               SettingsActivity.this.value = 1;
            //}
              
            SettingsActivity.this.stopService(new Intent(SettingsActivity.this.getApplicationContext(), AddsService.class));
            Editor var4 = SettingsActivity.this.getSharedPreferences("pub_pref", 0).edit();
            var4.putInt("value", SettingsActivity.this.value);
            
            switch(SettingsActivity.this.value) {
            case 1:
               var4.putInt("rect", R.drawable.test);
               var4.putInt("circ", android.R.drawable.ic_input_delete);
               
               break;
            /*case 2:
               var4.putInt("rect", 2130837513);
               var4.putInt("circ", 2130837505);
               break;
            case 3:
               var4.putInt("rect", 2130837514);
               var4.putInt("circ", 2130837506);
               break;
            case 4:
               var4.putInt("rect", 2130837515);
               var4.putInt("circ", 2130837507);
               break;
            case 5:
               var4.putInt("rect", 2130837516);
               var4.putInt("circ", 2130837508);
               break;
            case 6:
               var4.putInt("rect", 2130837517);
               var4.putInt("circ", 2130837509);
               break;
            case 7:
               var4.putInt("rect", 2130837518);
               var4.putInt("circ", 2130837510);*/
            }
            
            var4.commit();
            SettingsActivity.this.startService(new Intent(SettingsActivity.this.getApplicationContext(), AddsService.class));
         }
      });
      
   }
   
}
