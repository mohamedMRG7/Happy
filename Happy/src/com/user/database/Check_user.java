package com.user.database;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.app.interfaces.Isregested;
import com.resorces.user.User_info;
import com.user.database.Sign_in_dp.fetchUserDataAsyncTask;

public class Check_user {
	

	
	private static  final int requistTimeOut=1000*15 ;
	private static  final String SERVER_ADDRESS= "http://et7arak.net78.net" ;
	
	
	
	
	 public void fetchUserDataAsyncTask(User_info user, Isregested userCallBack) { 
		        
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
				//Log.e("no data", result);
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
			
			usercallback.regester_done(returnuser);
			
			
		}
	  }
	
	
	

}
