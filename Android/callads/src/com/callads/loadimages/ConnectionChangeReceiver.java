package com.callads.loadimages;
/*
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

public class ConnectionChangeReceiver extends BroadcastReceiver 
{

	@Override
	public void onReceive(Context context, Intent intent) 
	{
		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService( Context.CONNECTIVITY_SERVICE );
	    NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
	    NetworkInfo mobNetInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE );
	   
	    /*ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		NetworkInfo mG = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mWifi != null || mG != null)
		{
	      Toast.makeText( context, "Connected To The Inetrnet : " , Toast.LENGTH_LONG ).show();
		}
		else
		{
			Toast.makeText( context, "Fuck it : " , Toast.LENGTH_SHORT ).show();
		} */
	    

/*
	    if( mobNetInfo != null ||activeNetInfo != null   )
	    {
	    	
	      Toast.makeText( context, "Mobile Network Type : " + mobNetInfo.getTypeName(), Toast.LENGTH_SHORT ).show();
	      ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			NetworkInfo mG = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mWifi.isConnected() || mG.isConnected()) 
			{
			//setContentView(R.layout.main);	
	        // Imageview to show
	        
	        
	        // Images url
	        String image_url1 = "http://mehditaarit.byethost9.com/imgs/1.jpg";
	        String image_url2 = "http://mehditaarit.byethost9.com/imgs/2.jpg";
	        String image_url3 = "http://mehditaarit.byethost9.com/imgs/3.jpg";
	        
	        // ImageLoader class instance
	        ImageLoader imgLoader = new ImageLoader(getApplicationContext());
	        
	        // Charger photos de url
	        imgLoader.DisplayImage(image_url1);
	        imgLoader.DisplayImage(image_url2);
	        imgLoader.DisplayImage(image_url3);
	    }
	    }
		
	}

}*/
