package com.callads.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

import com.callads.R;
import com.callads.loadimages.ImageLoader;
import com.callads.utils.ParsingJson;

@SuppressLint("NewApi")
public class AddsService extends Service {

	public static final String PREFERENCE_FILENAME = "pub_pref";
	private ImageView chatHead;
	private ImageView secondHead;
	private WindowManager windowManager;
	public SharedPreferences var1;
	private int number_days_delay = 1;
	private String matin = "07:00";// +1hour
	private String midi = "13:00";// +1hour
	private String soir = "19:00"; // +1hour
	private int period = 0;
	private String[] links;

	public IBinder onBind(Intent var1) {
		return null;
	}

	public void onCreate() {
		super.onCreate();
		var1 = this.getSharedPreferences("pub_pref", 0);

		this.windowManager = (WindowManager) this.getSystemService("window");
		this.chatHead = new ImageView(this);
		this.chatHead.setEnabled(true);
		this.chatHead.setClickable(true);
		this.secondHead = new ImageView(this);

		if (var1.getBoolean("my_first_time", true)) {
			// the app is being launched for first time, do something
			Log.d("Comments", "First time");

			LoadImages();

			// record the fact that the app has been started at least once
			var1.edit().putBoolean("my_first_time", false).commit();
		}

		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");

		Date dnow = new Date();
		String lastup = var1.getString("last_update_date", "no");
		String newFormat1 = formatter1.format(dnow);
		Date lastupdate = null;
		try {
			dnow = formatter1.parse(newFormat1);// catch exception
			lastupdate = formatter1.parse(lastup);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar cnow = Calendar.getInstance();
		cnow.setTime(dnow);
		Calendar clastup = Calendar.getInstance();
		clastup.setTime(lastupdate);
		long diff = cnow.getTimeInMillis() - clastup.getTimeInMillis();

		if (diff > number_days_delay) {
			LoadImages();
		}
		String pic = "";
		String pic2 = "";
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");

		String newFormat2 = formatter.format(dnow);
		Date compareTo8 = null;
		Date compareTo14 = null;
		Date compareTo20 = null;
		try {
			dnow = formatter.parse(newFormat2);// catch exception
			compareTo8 = formatter.parse(matin);
			compareTo14 = formatter.parse(midi);
			compareTo20 = formatter.parse(soir);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		date.getDate();

		if ((date.getHours() > compareTo8.getHours())
				&& (date.getHours() <= compareTo14.getHours())) {
			period = 1;
			pic = "1.png";
			pic2 = "11.png";
		} else if ((date.getHours() > compareTo14.getHours())
				&& (date.getHours() <= compareTo20.getHours())) {
			period = 2;
			pic = "2.png";
			pic2 = "21.png";
		} else {
			period = 3;
			pic = "3.png";
			pic2 = "31.png";
		}
		
		Context context;
		//Log.i("test jzon",p.getJzonResult());
		Bitmap bmp = BitmapFactory.decodeFile(Environment
				.getExternalStorageDirectory().getPath() + "/SMILE/" + pic);
		Display  display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
		 display.getWidth(); // to get width of the screen
		 display.getHeight();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		Log.i("test x",width+"");
		int height = size.y;
		Log.i("test y",height+"");
		this.secondHead.setImageBitmap(bmp);
		Bitmap bmp2 = BitmapFactory.decodeFile(Environment
				.getExternalStorageDirectory().getPath() + "/SMILE/" + pic2);
		this.chatHead.setImageBitmap(bmp2);
		final LayoutParams var2 = new LayoutParams(-1, -2, 2002, 8, -3);
		var2.windowAnimations = R.style.Bann;
		var2.gravity = 51;
		var2.height = height/9 - height/18; 
		var2.width = width  ;
		var2.x = 0 ;
		var2.y = height/4 + height/32 - height /15;
		this.windowManager.addView(this.secondHead, var2);
		final LayoutParams var3 = new LayoutParams(-2, -2, 2002, 8, -3);
		var3.windowAnimations = R.style.Logo;
		var3.gravity = 51;
		var3.height = height/9; 
		var3.width = height/9;
		var3.x = width/20;
		var3.y = height/4 - height /15;
		this.windowManager.addView(this.chatHead, var3);
		this.chatHead.setClickable(true);
		this.chatHead.setOnTouchListener(new OnTouchListener() {
			
			private float initialTouchX;
			private float initialTouchY;
			private int initialX;
			private int initialY;
			

			public boolean onTouch(View var1, MotionEvent var2x) {
				boolean var3x = true;
				SharedPreferences var = getSharedPreferences("pub_pref", 0);
				
				switch (var2x.getAction()) {
				case 0:
					this.initialX = var3.x;
					this.initialY = var3.y;
					this.initialTouchX = var2x.getRawX();
					this.initialTouchY = var2x.getRawY();
					return var3x;
				case 1:
					if (var3.y < 80) {
						AddsService.this.stopService(new Intent(AddsService.this
								.getApplicationContext(), AddsService.class));
						Editor var8 = AddsService.this.getSharedPreferences(
								"pub_pref", 0).edit();
						Log.i("test link",var.getString(period+"", "xD"));
						Log.i("test link","yeah lol");
						var8.putString("url",var.getString(period+"", ""));
						var8.commit();
						AddsService.this.stopSelf();
					}

					if (var3.y > -220
							+ AddsService.this.windowManager.getDefaultDisplay()
									.getHeight()) {
						Editor var4 = AddsService.this.getSharedPreferences(
								"pub_pref", 0).edit();
						var4.putString("url", "null");
						var4.commit();
						AddsService.this.stopSelf();
						return var3x;
					}
					break;
				case 2:
					if (var3.y > 20
							&& var3.y < -220
									+ AddsService.this.windowManager
											.getDefaultDisplay().getHeight()) {
						var2.y = 10 + this.initialY
								+ (int) (var2x.getRawY() - this.initialTouchY);
						var3.y = this.initialY
								+ (int) (var2x.getRawY() - this.initialTouchY);
					}

					AddsService.this.windowManager.updateViewLayout(
							AddsService.this.chatHead, var3);
					AddsService.this.windowManager.updateViewLayout(
							AddsService.this.secondHead, var2);
					return var3x;
				default:
					var3x = false;
				}

				return var3x;
			}
		});
	}

	private void LoadImages() {

		ParsingJson p = new ParsingJson(this);
		links = p.getArrayResult();
		Log.i("test","el hamm 2");

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		String newFormat = formatter.format(now);
		var1.edit().putString("last_update_date", newFormat).commit();
		ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mWifi = connManager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		NetworkInfo mG = connManager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mWifi.isConnected() || mG.isConnected()) {
			// setContentView(R.layout.main);
			// Imageview to show

			// Images url
			String image_url1 = "http://mehditaarit.byethost9.com/callads/photos/1.png";
			String image_url2 = "http://mehditaarit.byethost9.com/callads/photos/2.png";
			String image_url3 = "http://mehditaarit.byethost9.com/callads/photos/3.png";
			String image_url11 = "http://mehditaarit.byethost9.com/callads/photos/11.png";
			String image_url21 = "http://mehditaarit.byethost9.com/callads/photos/21.png";
			String image_url31 = "http://mehditaarit.byethost9.com/callads/photos/31.png";
			// ImageLoader class instance
			ImageLoader imgLoader = new ImageLoader(getApplicationContext());

			// Charger photos de url
			imgLoader.DisplayImage(image_url1);
			imgLoader.DisplayImage(image_url2);
			imgLoader.DisplayImage(image_url3);
			imgLoader.DisplayImage(image_url11);
			imgLoader.DisplayImage(image_url21);
			imgLoader.DisplayImage(image_url31);
		}

	}

	public void onDestroy() {

		super.onDestroy();

		if (this.chatHead != null) {
			this.windowManager.removeView(this.chatHead);
		}

		if (this.secondHead != null) {
			this.windowManager.removeView(this.secondHead);
		}

	}
}
