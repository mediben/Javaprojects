package com.callads.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class ParsingJson {

	// TextView tvIsConnected;
	
	private  String[]  links;
	public SharedPreferences var1;
	public ParsingJson(Context context) {
		
		String OutputData = "";
		JSONObject jsonResponse;
		var1 = context.getSharedPreferences("pub_pref", 0);
		// tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);

		/*
		 * if(isConnected()){ tvIsConnected.setText("You are conncted"); } else{
		 * tvIsConnected.setText("You are NOT conncted"); }
		 */
		new HttpAsyncTask()
				.execute("http://mehditaarit.byethost9.com/geturls.php");
		
	}

	public String[] getArrayResult() {
		
		if (links==null){Log.i("test jzon","chbi 5rak");}
		return links;
	}

	public static String GET(String url) {
		
		InputStream inputStream = null;
		String result = "";

		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
			inputStream = httpResponse.getEntity().getContent();
			if (inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}

		return result;
	}

	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;
		inputStream.close();
		return result;
	}

	/*
	 * public boolean isConnected() { ConnectivityManager connMgr =
	 * (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
	 * NetworkInfo networkInfo = connMgr.getActiveNetworkInfo(); if (networkInfo
	 * != null && networkInfo.isConnected()) return true; else return false; }
	 */
	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... urls) {
			
			return GET(urls[0]);
		}

		@Override
		protected void onPostExecute(String result) {

			
			// etResponse.setText(result);
			/*
			 * try { JSONObject json = new JSONObject(result); String str = "";
			 * JSONArray images = json.getJSONArray("images"); str +=
			 * "articles length = "+json.getJSONArray("images").length(); str +=
			 * "\n--------\n"; str += "names: "+images.getJSONObject(0).names();
			 * str += "\n--------\n"; str +=
			 * "url: "+images.getJSONObject(0).getString("url");
			 * 
			 * etResponse.setText(str); } catch (JSONException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
			try {
				Log.i("test a","1");
				JSONObject json = new JSONObject(result);
				// Log.i("test jzon",json.toString(1));
				
				JSONArray sys = json.getJSONArray("liens");
				
				
				var1.edit().putString(1+"", sys.getJSONArray(0).getJSONObject(0).getString("lien")).commit();
				var1.edit().putString(2+"", sys.getJSONArray(1).getJSONObject(0).getString("lien")).commit();
				var1.edit().putString(3+"", sys.getJSONArray(2).getJSONObject(0).getString("lien")).commit();
				
				

				// Log.i("test jzon",json.toString(1));

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	

}
