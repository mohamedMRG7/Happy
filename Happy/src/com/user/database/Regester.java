package com.user.database;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.app.interfaces.Isregested;
import com.resorces.user.User_info;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;



public class Regester {

	ProgressDialog progressDialoge ;
	private static  final int requistTimeOut=1000*15 ;
	private static  final String SERVER_ADDRESS= "http://et7arak.net78.net" ;
	
	public Regester (Context context)
	{
		progressDialoge=new ProgressDialog(context);
		progressDialoge.setCancelable(false);
		progressDialoge.setTitle("Processing...");
		progressDialoge.setMessage("Please wait");
		
	}
	public void storinbackground (User_info user ,Isregested userCallBack,Context context){
		progressDialoge.show();
		new StoreUserDataAsyncTask(user, userCallBack,context ).execute();
	
		
	}
	
	 

	
	
	
	
  public class StoreUserDataAsyncTask extends AsyncTask<Void, Void, Void>
	{

		User_info user;
		Isregested usercallback ;
		Context ctx;
		
		public StoreUserDataAsyncTask (User_info user,Isregested usercallback ,Context ctx)
		{
			this.ctx=ctx;
			this.user=user;
			this.usercallback=usercallback;
		}
		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			ArrayList<NameValuePair> datatosend=new ArrayList<>();
			
		datatosend.add(new BasicNameValuePair("username", user.getUsername()));
		datatosend.add(new BasicNameValuePair("password", user.getPassword()));
		datatosend.add(new BasicNameValuePair("email", user.getEmail()));
			
			HttpParams httpparams = gethttpparams();
			
			HttpClient clieint=new DefaultHttpClient(httpparams);
			HttpPost post =new HttpPost(SERVER_ADDRESS+"/"+"happy_regester.php");
			
			try {
				post.setEntity(new UrlEncodedFormEntity(datatosend));
				clieint.execute(post);
			//	HttpResponse httpResponse=clieint.execute(post);
				
			//	HttpEntity entity=httpResponse.getEntity();
			//	String result =EntityUtils.toString(entity);
				//Log.e("", result);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

			
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressDialoge.dismiss();
			usercallback.regester_done(null);
		}
		
		private HttpParams gethttpparams ()
		{
			HttpParams httprequistparams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httprequistparams, requistTimeOut);
			HttpConnectionParams.setSoTimeout(httprequistparams, requistTimeOut);
			
			return httprequistparams;
			
		}
		
	}
}
