package com.user.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.app.interfaces.Isregested;
import com.resorces.user.User_info;



import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;



public class Sign_in_dp {


	ProgressDialog progressDialoge ;
	private static  final int requistTimeOut=1000*15 ;
	private static  final String SERVER_ADDRESS= "http://et7arak.net78.net" ;
	
	public Sign_in_dp (Context context)
	{
		progressDialoge=new ProgressDialog(context);
		progressDialoge.setCancelable(false);
		progressDialoge.setTitle("Processing...");
		progressDialoge.setMessage("Please wait");
		
	}
	
	
	 public void fetchUserDataAsyncTask(User_info user, Isregested userCallBack) { 
		         progressDialoge.show(); 
		         new fetchUserDataAsyncTask(user, userCallBack).execute(); 
		      } 
	 
	 
	  public class fetchUserDataAsyncTask extends AsyncTask<Void, Void, User_info>
	  {
		  User_info user;
		  Isregested usercallback;

		public fetchUserDataAsyncTask(User_info user, Isregested usercallback) {
			super();
			this.user = user;
			this.usercallback = usercallback;
		}

		@Override
		protected User_info doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NameValuePair> datatosend=new ArrayList<>();
			
			datatosend.add(new BasicNameValuePair("email", user.getEmail()));
			datatosend.add(new BasicNameValuePair("password", user.getPassword()));
			
			HttpParams httprequistparams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httprequistparams, requistTimeOut);
			HttpConnectionParams.setSoTimeout(httprequistparams, requistTimeOut);
		        
			HttpClient client =new DefaultHttpClient(httprequistparams);
			
			HttpPost post=new HttpPost(SERVER_ADDRESS+"/"+"happy_users.php");
			
			User_info returnuser=null ;
			
			try{
				
				post.setEntity(new UrlEncodedFormEntity(datatosend));
				HttpResponse httpResponse=client.execute(post);
				
				HttpEntity entity=httpResponse.getEntity();
				String result =EntityUtils.toString(entity);
				Log.e("no data", result);
				JSONObject object =new JSONObject(result);
				if(object.length()!=0)
				{
					//String name =object.getString("username");
					String name=object.getString("username");
					String email=object.getString("email");
					String pass=object.getString("password");
					
					
					returnuser=new User_info(name, pass,email);
				}else Log.e("no data", "error");
				
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			return returnuser;
		}
		@Override
		protected void onPostExecute(User_info returnuser) {
			// TODO Auto-generated method stub
			super.onPostExecute(returnuser);
			progressDialoge.dismiss();
			usercallback.regester_done(returnuser);
			
			
		}
	  }
	
	
	
}
