package com.app.happy;

import com.app.interfaces.Isregested;
import com.resorces.user.User_info;
import com.user.database.Sign_in_dp;

import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sign_in extends ActionBarActivity {

	EditText email,pass;
	Context c=this ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		
		email=(EditText)findViewById(R.id.ed_email);
		pass=(EditText)findViewById(R.id.ed_pass);
	}
     	
	public void sign_up (View view)
	{
		
		startActivity(new Intent(Sign_in.this,Sign_up.class));
	}
	
	public void sign_in (View view)
	{
		String Uemail=email.getText().toString();
		String Upass =pass.getText().toString();
		User_info user=new User_info("", Upass, Uemail);
		startActivity(new Intent(Sign_in.this,Select_product.class));
	//	Toast.makeText(getApplicationContext(), user.getEmail()+ user.getPassword(), Toast.LENGTH_SHORT).show();
/*	new Sign_in_dp(c).fetchUserDataAsyncTask(user, new Isregested() {
		
		@Override
		public void regester_done(User_info user) {
			// TODO Auto-generated method stub
			try{
			
				Toast.makeText(getApplicationContext(), "Wellcom " + user.getUsername(), Toast.LENGTH_SHORT).show();
				startActivity(new Intent(Sign_in.this,Select_product.class));
			}catch(Exception e){Toast.makeText(getApplicationContext(), "wrong user name or pass", Toast.LENGTH_SHORT).show();
									}
		}
	});*/
		
		
		
	}
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_in, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
